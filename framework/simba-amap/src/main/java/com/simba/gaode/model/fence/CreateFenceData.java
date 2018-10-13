package com.simba.gaode.model.fence;

/**
 * 返回数据内容消息体
 * 
 * @author caozhejun
 *
 */
public class CreateFenceData {

	/**
	 * 围栏全局id
	 */
	private String gid;

	/**
	 * 围栏id
	 */
	private String id;

	/**
	 * 状态说明信息
	 */
	private String message;

	/**
	 * 状态值
	 */
	private String status;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
		builder.append("CreateFenceData [gid=");
		builder.append(gid);
		builder.append(", id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
