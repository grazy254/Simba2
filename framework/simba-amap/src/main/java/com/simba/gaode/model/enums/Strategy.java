package com.simba.gaode.model.enums;

/**
 * 公交换乘策略
 * 
 * @author caozhejun
 *
 */
public enum Strategy {

	QUICK("0", "最快捷模式"),

	LESSMONEY("1", "最经济模式"),

	LESSCHANGE("2", "最少换乘模式"),

	LESSWORK("3", "最少步行模式"),

	NOSUBWAY("5", "不乘地铁模式");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private Strategy(String name, String description) {
		this.name = name;
		this.description = description;
	}

}
