package com.simba.wallet.model.enums;

public enum FeeType {
	
	CNY("CNY");
	
	private String name;
	
	private FeeType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
