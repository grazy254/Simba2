package com.simba.service.exceptions;

/**
 * Created by shuoGG on 2018/8/3
 */
public class RetryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RetryException() {
	}

	public RetryException(String message) {
		super(message);
	}

	public RetryException(String message, Throwable cause) {
		super(message, cause);
	}
}
