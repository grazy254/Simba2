package com.simba.gaode.model.fence;

/**
 * 返回数据内容消息体
 * 
 * @author caozhejun
 *
 */
public class UpdateFenceData {

	/**
	 * 状态说明信息
	 */
	private String message;

	/**
	 * 状态值
	 */
	private String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateFenceData [message=");
		builder.append(message);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
