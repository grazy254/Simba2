package com.simba.wallet.model.enums;

public enum AccountType {

	PERSIONAL_ACCOUNT("PE", "个人账号"),

	COMPANY_ACCOUNT("CO", "公司账号"),
	
	CHANNEL_ACCOUNT("CH","渠道账号");
	
	private String name;
	
	private String shortName;
	
	private AccountType(String shortName, String name) {
		this.shortName = shortName;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getShortName() {
		return shortName;
	}

}
