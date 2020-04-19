package com.dev.noteBook.service;

import java.util.TimerTask;

import com.dev.noteBook.util.TimeOutException;

public class InterpreterTimerTask extends TimerTask {

	@Override
	public void run() {
		throw new TimeOutException();
		
	}
	
}
