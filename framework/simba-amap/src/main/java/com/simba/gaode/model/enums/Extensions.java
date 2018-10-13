package com.simba.gaode.model.enums;

/**
 * 返回结果详略
 * 
 * @author caozhejun
 *
 */
public enum Extensions {

	BASE("base", "返回基本信息"),

	ALL("all", "返回全部信息");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private Extensions(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
