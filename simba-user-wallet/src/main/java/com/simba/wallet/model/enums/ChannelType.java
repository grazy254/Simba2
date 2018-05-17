package com.simba.wallet.model.enums;

public enum ChannelType {

	WXPAY("微信支付", "WXPAY"),

	ALIPAY("支付宝", "ALIPAY");
	
	private String name;
	private String type;
	
	private ChannelType(String name, String type) {
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
