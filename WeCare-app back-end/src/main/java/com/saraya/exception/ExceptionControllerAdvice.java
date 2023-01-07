package com.saraya.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saraya.dto.ErrorMessage;



@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(WecareExeception.class)
	public ResponseEntity<ErrorMessage> exceptoinHandler1(WecareExeception ex){
		ErrorMessage error = new ErrorMessage();
		error.setMessage(ex.getMessage());
		return ResponseEntity.ok(error);
	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler2(Exception ex) {
		return ex.getMessage();
	}

}
