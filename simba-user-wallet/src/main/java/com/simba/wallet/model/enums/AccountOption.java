package com.simba.wallet.model.enums;

public enum AccountOption {

	OPENACTIVE("开通并激活", 1), OPENNOTACTIVE("开通未激活", 0);
	private String name;
	private int type;

	private AccountOption(String name, int type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}

	public int getType() {
		return type;
	}

}
