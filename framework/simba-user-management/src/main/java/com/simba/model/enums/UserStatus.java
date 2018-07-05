package com.simba.model.enums;

public enum UserStatus {

	DISABLED(2, "禁用"),

	ENABLED(1, "启用");

	private UserStatus(int id, String name) {
		this.id = id;
		this.name = name;
	}

	private int id;

	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
