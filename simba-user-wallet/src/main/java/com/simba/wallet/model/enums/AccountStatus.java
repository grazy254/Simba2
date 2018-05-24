package com.simba.wallet.model.enums;

public enum AccountStatus {

	ACTIVE("已激活"), NOTACTIVE("未激活"), CLOSED("已注销"), FRONZON("已冻结"),
	NOTEXIST("未开通");
	
	private String name;
	
	
	private AccountStatus(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
