package com.simba.wallet.model.enums;

public enum TradeStatus {

	INPROCESS("INPROCESS"),
	FAILED("FAILED"),
	SUCCESS( "SUCCESS");
	
	private String name;
	
	private TradeStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
