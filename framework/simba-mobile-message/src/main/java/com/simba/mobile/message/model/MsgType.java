package com.simba.mobile.message.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 支持发送的手机短信平台类型
 *
 * @author caozhejun
 */
public enum MsgType {

	JPUSH("jpush", "极光短信"),

	ALI("ali", "阿里云短信服务");

	private String type;

	private String description;

	private static Map<String, MsgType> typeMap = new HashMap<String, MsgType>();

	static {
		for (MsgType msgType : MsgType.values()) {
			typeMap.put(msgType.getType(), msgType);
		}
	}

	private MsgType(String type, String description) {
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public static MsgType getByType(String type) {
		return typeMap.get(type);
	}

}
