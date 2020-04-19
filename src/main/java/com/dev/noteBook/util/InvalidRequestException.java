package com.dev.noteBook.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Request Format")
public class InvalidRequestException extends RuntimeException {}
