package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum RedPackBillStatus {

	All("", "所有"),

	SENDING("SENDING", "发放中"),

	SENT("SENT", "已发放待领取"),

	FAILED("FAILED", "发放失败"),

	RECEIVED("RECEIVED", "已领取"),

	RFUND_ING("RFUND_ING", "退款中"),

	REFUND("REFUND", "已退款");

	private String status;

	private String name;

	private RedPackBillStatus(String status, String name) {
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

		for (RedPackBillStatus type : RedPackBillStatus.values()) {
			maps.put(type.getStatus(), type.getName());
		}
	}

	private static Map<String, RedPackBillStatus> map = new HashMap<String, RedPackBillStatus>();

	static {

		for (RedPackBillStatus type : RedPackBillStatus.values()) {
			map.put(type.getStatus(), type);
		}
	}

	public static RedPackBillStatus get(String status) {
		return map.get(status);
	}

}
