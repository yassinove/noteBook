package com.dev.noteBook.service;

import java.util.List;

import javax.script.ScriptException;

import com.dev.noteBook.model.ExecutionRequest;
import com.dev.noteBook.model.ExecutionResponse;
import com.dev.noteBook.model.Input;
import com.dev.noteBook.model.Response;

public interface ExecutionService {
	ExecutionResponse execute(String cmd);
	ExecutionRequest parseInterpreterRequest(Input request);
	public List<String> getSupportedLanguges() ;
	public void setSupportedLanguges(List<String> supportedLanguges) ;
}
