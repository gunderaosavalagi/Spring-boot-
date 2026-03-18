package com.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value= {InvalidIdException.class})
	public ResponseEntity<Object> handleInvalidIdException(Exception ex,WebRequest request) throws Exception{
		String bodyOfResponse=ex.toString();
		return handleExceptionInternal(ex, bodyOfResponse,new HttpHeaders(),HttpStatus.NOT_FOUND, request);
	}
}
