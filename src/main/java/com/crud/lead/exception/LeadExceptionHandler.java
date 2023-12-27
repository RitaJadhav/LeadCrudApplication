package com.crud.lead.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.experimental.StandardException;

@StandardException
public class LeadExceptionHandler extends Exception{
	private long leadId;
	public LeadExceptionHandler(long leadId) {
        super(String.format("Lead is not found with id : '%s'", leadId));
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleMethodArgResponseEntity(MethodArgumentNotValidException exception){
		Map<String, String> errors = new HashMap<>();
		exception.getBindingResult().getAllErrors().forEach((error) -> {
			String feildname = ((FieldError) error ).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(feildname,errorMessage);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
}
