package com.dev.noteBook.controller;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.script.ScriptException;
import javax.security.auth.callback.LanguageCallback;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.noteBook.model.ExecutionRequest;
import com.dev.noteBook.model.ExecutionResponse;
import com.dev.noteBook.model.Input;
import com.dev.noteBook.model.Response;
import com.dev.noteBook.service.ExecutionService;
import com.dev.noteBook.util.InvalidLanguageException;
import com.dev.noteBook.util.Language;
import com.dev.noteBook.util.TimeOutException;


@RestController
@RequestMapping("/")
public class InterpreterController {

	@Autowired
	ExecutionService executionService;
	
	

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    public Response search(@RequestBody Input inputRequest,HttpSession httpSession) throws IOException, ScriptException {
    	
    	Response response = new Response();
    	ExecutionRequest request = executionService.parseInterpreterRequest(inputRequest);
        if(!executionService.getSupportedLanguges().contains(request.getLanguage())) {
        	throw new InvalidLanguageException();
        }
        String sessionId = inputRequest.getSessionId() != null ? inputRequest.getSessionId() : httpSession.getId();
        request.setSessionId(sessionId);
        ExecutionResponse executionResponse;
		executionResponse = executionService.execute(request.getCode());
    	response.setResult(executionResponse.getOutput());
    	response.setErrors(executionResponse.getErrors());
        response.setSessionId(sessionId);
    	return response;
        
    }
    

}