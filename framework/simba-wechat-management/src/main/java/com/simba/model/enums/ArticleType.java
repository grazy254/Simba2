package com.simba.model.enums;

/**
 * 图文类型
 * 
 * @author caozhejun
 *
 */
public enum ArticleType {

	TEMP(1, "临时"),

	FOREVER(2, "永久");

	private ArticleType(int id, String description) {
		this.id = id;
		this.description = description;
	}

	private int id;

	private String description;

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
