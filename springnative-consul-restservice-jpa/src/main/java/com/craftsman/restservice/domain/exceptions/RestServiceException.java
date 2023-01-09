package com.craftsman.restservice.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestServiceException extends RuntimeException {

	private static final long serialVersionUID = -1932808270673621129L;

	public RestServiceException() {
		super();
	}

	public RestServiceException(String message, Throwable e) {
		super(message, e);
	}

}
