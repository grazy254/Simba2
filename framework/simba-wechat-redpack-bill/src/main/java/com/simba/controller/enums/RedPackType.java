package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 红包类型
 * 
 * @author caozhejun
 *
 */
public enum RedPackType {

	NORMAL("NORMAL", "普通红包"),

	GROUP("GROUP", "裂变红包");

	private String name;

	private String description;

	private RedPackType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private static Map<String, RedPackType> types = new HashMap<>();

	static {
		for (RedPackType type : RedPackType.values()) {
			types.put(type.getName(), type);
		}
	}

	public static RedPackType get(String name) {
		return types.get(name);
	}
}
