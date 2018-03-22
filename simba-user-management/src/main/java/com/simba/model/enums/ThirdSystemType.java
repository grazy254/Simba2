package com.simba.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum ThirdSystemType {

	WX("wx", "微信公众号", "wx_"),

	WXMINI("wxmini", "微信小程序", "wxmini"),

	WEBO("sinaweibo", "新浪微博", "sinaweibo_"),

	QQ("qq", "QQ", "qq_");

	private static Map<String, ThirdSystemType> maps = new HashMap<>();

	static {
		for (ThirdSystemType type : ThirdSystemType.values()) {
			maps.put(type.getName(), type);
		}
	}

	private ThirdSystemType(String name, String description, String prefix) {
		this.name = name;
		this.description = description;
		this.prefix = prefix;
	}

	private String name;

	private String description;

	private String prefix;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPrefix() {
		return prefix;
	}

	public static ThirdSystemType get(String name) {
		return maps.get(name);
	}
}
