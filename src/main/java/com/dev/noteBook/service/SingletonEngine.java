package com.dev.noteBook.service;

import java.io.StringWriter;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

import com.dev.noteBook.util.Language;

public class SingletonEngine {
	private ScriptEngine engine;
	 private static SingletonEngine instance = null;
	    private SingletonEngine() {
	    }
	    private SingletonEngine(ScriptEngine engine) {
	    	this.engine = engine;
	    }
	    public static SingletonEngine getInstance() {
	        if (instance == null) {
	        	
	            ScriptEngineManager manager = new ScriptEngineManager();
	            ScriptEngine engine = manager.getEngineByName(Language.PYTHON.getName());
	            instance = new SingletonEngine(engine);
	        }
	        return instance;
	    }
		public ScriptEngine getEngine() {
			return engine;
		}
		public void setEngine(ScriptEngine engine) {
			this.engine = engine;
		}
	    
	    
	    

}
