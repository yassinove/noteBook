package com.dev.noteBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dev.noteBook.service.SingletonEngine;

@SpringBootApplication
public class NoteBookApplication {

	public static void main(String[] args) {
		System.out.println("ok");
		SingletonEngine.getInstance().getEngine();
		SpringApplication.run(NoteBookApplication.class, args);
		
	}

}
