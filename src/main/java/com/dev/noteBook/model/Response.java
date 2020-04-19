package com.dev.noteBook.model;

public class Response {
    private String result;
    private String errors;
    private String sessionId;



    public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
