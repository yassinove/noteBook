package com.dev.noteBook.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Language")
public class InvalidLanguageException extends RuntimeException {}
