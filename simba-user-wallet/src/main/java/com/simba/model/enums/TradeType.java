package com.simba.model.enums;

public enum TradeType {

	RECHARGE("充值"),
	CONSUME("支付");
	
	private String name;
	
	private TradeType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
