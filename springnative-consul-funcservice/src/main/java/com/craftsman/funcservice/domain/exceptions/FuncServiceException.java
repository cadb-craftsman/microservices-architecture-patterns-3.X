package com.craftsman.funcservice.domain.exceptions;

public class FuncServiceException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public FuncServiceException() {
		super();
	}

	public FuncServiceException(String message, Throwable e) {
		super(message, e);
	}

}
