package com.hcl.training.AccountManagementSystemApp.services.exceptions;

public class FaultException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;
	
	public FaultException() {}
	
	public FaultException(String message){
		super(message);
		this.message = message;
	}
	
	public FaultException(String message, Throwable th) {
		super(message, th);
	}

	public String getMessage() {
		return message;
	}
	
}
