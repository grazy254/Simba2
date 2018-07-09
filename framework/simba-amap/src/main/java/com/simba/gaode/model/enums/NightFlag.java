package com.simba.gaode.model.enums;

/**
 * 是否计算夜班车
 * 
 * @author caozhejun
 *
 */
public enum NightFlag {

	N("0", "不计算夜班车"),

	Y("1", "计算夜班车");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private NightFlag(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
