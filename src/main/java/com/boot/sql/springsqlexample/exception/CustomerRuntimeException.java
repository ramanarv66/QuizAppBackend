package com.boot.sql.springsqlexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.boot.sql.springsqlexample.model.UserResponse;

@ControllerAdvice
public class CustomerRuntimeException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<UserResponse>customerNotFoundException(CustomerNotFoundException ces){
		
		UserResponse errorResponse = new UserResponse();
		errorResponse.setErrorMessage(ces.getErrorMessage());
		return new ResponseEntity<UserResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
