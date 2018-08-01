package com.simba.websocket.distributed;

import java.io.Serializable;

/**
 * 推送实时消息给用户在集群中传递的对象
 * 
 * @author caozhejun
 *
 */
public class UserIdMessageData implements Serializable {

	private static final long serialVersionUID = -7521849117967501233L;

	/**
	 * 用户ID
	 */
	private String userId;

	/**
	 * 实时推送的内容
	 */
	private String content;

	private String appid;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserIdMessageData [userId=");
		builder.append(userId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", appid=");
		builder.append(appid);
		builder.append("]");
		return builder.toString();
	}

}
