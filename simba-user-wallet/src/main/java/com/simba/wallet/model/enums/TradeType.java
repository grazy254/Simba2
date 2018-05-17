package com.simba.wallet.model.enums;

public enum TradeType {

	RECHARGE("RECHARGE"),
	CONSUME("CONSUME");
	
	private String name;
	
	private TradeType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
