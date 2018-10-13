package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum CardMoneyBillStatus {

	All("", "所有"), SUCCESS("SUCCESS", "转账成功"), FAILED("FAILED", "转账失败"), PROCESSING("PROCESSING", "处理中"), BANK_FAIL("BANK_FAIL", "银行退票");

	private String status;

	private String name;

	private CardMoneyBillStatus(String status, String name) {
		this.status = status;
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Map<String, String> maps = new HashMap<String, String>();

	static {

		for (CardMoneyBillStatus type : CardMoneyBillStatus.values()) {
			maps.put(type.getStatus(), type.getName());
		}
	}

	private static Map<String, CardMoneyBillStatus> map = new HashMap<String, CardMoneyBillStatus>();

	static {

		for (CardMoneyBillStatus type : CardMoneyBillStatus.values()) {
			map.put(type.getStatus(), type);
		}
	}

	public static CardMoneyBillStatus get(String status) {
		return map.get(status);
	}

}
