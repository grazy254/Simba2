package com.simba.baidu.ai.model.error;

/**
 * 调用接口返回错误信息对象
 * 
 * @author caozhejun
 *
 */
public class Error {

	private int error_code;

	private String error_msg;

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Error [error_code=");
		builder.append(error_code);
		builder.append(", error_msg=");
		builder.append(error_msg);
		builder.append("]");
		return builder.toString();
	}

}
