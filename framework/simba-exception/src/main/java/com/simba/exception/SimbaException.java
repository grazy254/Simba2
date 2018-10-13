package com.simba.exception;

/**
 * 框架异常类
 * 
 * @author caozj
 * 
 */
public class SimbaException extends RuntimeException {

	private static final long serialVersionUID = -2320399934788651830L;

	public SimbaException(String message) {
		super(message);
	}
}
