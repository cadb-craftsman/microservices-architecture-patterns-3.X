package com.craftsman.reactservice.domain.exceptions;

public class ReactServiceResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public ReactServiceResourceNotFoundException() {
		super();
	}

	public ReactServiceResourceNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
