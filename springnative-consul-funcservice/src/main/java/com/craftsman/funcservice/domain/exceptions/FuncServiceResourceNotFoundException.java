package com.craftsman.funcservice.domain.exceptions;

public class FuncServiceResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public FuncServiceResourceNotFoundException() {
		super();
	}

	public FuncServiceResourceNotFoundException(String message, Throwable e) {
		super(message, e);
	}

}
