package com.lcwd.user.UserService.Exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource is not found for the given user");
		
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ResourceNotFoundException(String message) {
		super(message);
		
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
