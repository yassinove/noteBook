package com.dev.noteBook.service;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.python.core.PyException;
import org.springframework.stereotype.Service;

import com.dev.noteBook.model.ExecutionRequest;
import com.dev.noteBook.model.ExecutionResponse;
import com.dev.noteBook.model.Input;
import com.dev.noteBook.model.Response;
import com.dev.noteBook.util.InvalidRequestException;
import com.dev.noteBook.util.Language;
import com.dev.noteBook.util.TimeOutException;

@Service
public class ExecutionServiceImpl implements ExecutionService {
	
    private static final String REQUEST_PATTERN = "%(\\w+)\\s+(.*)";
    private static final Pattern pattern = Pattern.compile(REQUEST_PATTERN);
    
    private List<String> supportedLanguges;
    {
    	supportedLanguges = new ArrayList<String>();
    	supportedLanguges.add(Language.PYTHON.getName());
    }
    

	@Override
	public ExecutionResponse execute(String cmd) {

		Timer timer = new Timer(true);
		timer.schedule(new InterpreterTimerTask(),3000);
		ExecutionResponse executionResponse= new ExecutionResponse();
		try {
			
			
			//ouput will be stored here
	        StringWriter writer = new StringWriter(); 
	        ScriptContext context = new SimpleScriptContext();
	        //configures output redirection
	        context.setWriter(writer); 
	        ScriptEngine engine = SingletonEngine.getInstance().getEngine();
	        engine.eval(cmd, context); 
	        executionResponse.setOutput(writer.toString());
	        timer.cancel();
            timer.purge();
		}catch (ScriptException e) {
			// TODO: handle exception
			executionResponse.setErrors(e.getMessage());
		}
		return executionResponse;
		
	}
	
    @Override
    public ExecutionRequest parseInterpreterRequest(Input request) {
        Matcher matcher = pattern.matcher(request.getCode());
        if (matcher.matches()) {
            String language = matcher.group(1);
            String code = matcher.group(2);

            ExecutionRequest executionRequest = new ExecutionRequest();
            executionRequest.setCode(code);
            executionRequest.setLanguage(language);

            return executionRequest;
        }

        throw new InvalidRequestException();
    }


	public List<String> getSupportedLanguges() {
		return supportedLanguges;
	}


	public void setSupportedLanguges(List<String> supportedLanguges) {
		this.supportedLanguges = supportedLanguges;
	}
    
    

}
