package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum LooseMoneyBillStatus {

	All("", "所有"), SUCCESS("SUCCESS", "转账成功"), FAILED("FAILED", "转账失败"), PROCESSING("PROCESSING", "处理中");

	private String status;

	private String name;

	private LooseMoneyBillStatus(String status, String name) {
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

		for (LooseMoneyBillStatus type : LooseMoneyBillStatus.values()) {
			maps.put(type.getStatus(), type.getName());
		}
	}

	private static Map<String, LooseMoneyBillStatus> map = new HashMap<String, LooseMoneyBillStatus>();

	static {

		for (LooseMoneyBillStatus type : LooseMoneyBillStatus.values()) {
			map.put(type.getStatus(), type);
		}
	}

	public static LooseMoneyBillStatus get(String status) {
		return map.get(status);
	}

}
