package com.simba.model.enums;

public enum TradeUserType {

	PERSION("个人用户", "PE"),

	COMPANY("公司用户", "CO");
	private String name;
	private String type;
	
	
	private TradeUserType(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
}
