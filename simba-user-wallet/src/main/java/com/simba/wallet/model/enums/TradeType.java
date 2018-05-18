package com.simba.wallet.model.enums;

public enum TradeType {

	RECHARGE("RECHARGE", "01"), CONSUME("CONSUME", "02");
	
	private String name;
	private String no;
	
	private TradeType(String name, String no) {
		this.name = name;
		this.no = no;
	}
	
	public String getName() {
		return name;
	}

	public String getNO() {
		return no;
	}
	
}
