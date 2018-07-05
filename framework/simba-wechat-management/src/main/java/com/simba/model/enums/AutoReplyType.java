package com.simba.model.enums;

public enum AutoReplyType {

	SUBSCRIBE(1, "关注"),

	RECEIVEMSG(2, "收到用户信息");

	private int id;

	private String name;

	private AutoReplyType(int id, String name) {
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
