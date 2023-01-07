package com.craftsman.reactservice.domain.exceptions;

public class ReactServiceException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public ReactServiceException() {
		super();
	}

	public ReactServiceException(String message, Throwable e) {
		super(message, e);
	}

}
