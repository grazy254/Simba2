package com.simba.model.enums;

/**
 * 发送状态
 * 
 * @author caozhejun
 *
 */
public enum SendStatus {

	SENDED(1, "已发送"),

	SUCCESS(2, "发送成功");

	private int id;

	private String name;

	private SendStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
