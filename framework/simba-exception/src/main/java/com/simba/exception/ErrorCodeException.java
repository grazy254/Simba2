package com.simba.exception;

/**
 * 带有错误妈异常类
 * 
 * @author caozj
 * 
 */
public class ErrorCodeException extends RuntimeException {

	private static final long serialVersionUID = -2320399934788651830L;

	private int code = 400;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ErrorCodeException(String message) {
		super(message);
	}

	public ErrorCodeException(String message, int code) {
		super(message);
		this.code = code;
	}
}
