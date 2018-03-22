package com.simba.model;

/**
 * 第三方系统用户
 * 
 * @author caozhejun
 *
 */
public class ThirdSystemUser {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 用户ID
	 */
	private long userId;

	/**
	 * 第三方系统
	 */
	private String thirdSystem;

	/**
	 * 第三方系统用户ID标识
	 */
	private String thirdSystemUserId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getThirdSystem() {
		return thirdSystem;
	}

	public void setThirdSystem(String thirdSystem) {
		this.thirdSystem = thirdSystem;
	}

	public String getThirdSystemUserId() {
		return thirdSystemUserId;
	}

	public void setThirdSystemUserId(String thirdSystemUserId) {
		this.thirdSystemUserId = thirdSystemUserId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ThirdSystemUser [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", thirdSystem=");
		builder.append(thirdSystem);
		builder.append(", thirdSystemUserId=");
		builder.append(thirdSystemUserId);
		builder.append("]");
		return builder.toString();
	}

}
