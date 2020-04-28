package com.boot.sql.springsqlexample.exception;

/**
 * 
 * @author mrama
 *
 */
public class CustomerNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;
	String errorCode;
	
	public CustomerNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(String message) {
		super(message);
		this.errorMessage= message;
		
		// TODO Auto-generated constructor stub
	}
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	

}
