package com.simba.wallet.model.enums;

public enum ChannelType {

	WXPAY("WXPAY", "01"),

	ALIPAY("ALIPAY", "02");
	
	private String name;
	private String no;

	private ChannelType(String name, String no) {
		this.no = no;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public String getNo() {
		return no;
	}
}
