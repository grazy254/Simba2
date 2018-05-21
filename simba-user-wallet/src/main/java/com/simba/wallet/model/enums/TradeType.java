package com.simba.wallet.model.enums;

public enum TradeType {

	RECHARGE("RECHARGE", "01", "充值"), CONSUME("CONSUME", "02", "消费");
	
	private String name;
	private String no;
	private String desc;
	
	private TradeType(String name, String no, String desc) {
		this.name = name;
		this.no = no;
		this.desc = desc;
	}
	
	public String getName() {
		return name;
	}

	public String getNO() {
		return no;
	}
	
	public String getDesc() {
		return desc;
	}

}
