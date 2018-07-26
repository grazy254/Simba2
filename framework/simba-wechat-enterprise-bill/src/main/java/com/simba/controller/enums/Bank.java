package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 银行
 * 
 * @author caozhejun
 *
 */
public enum Bank {

	ICBC("1002", "工商银行"),

	ABC("1005", "农业银行"),

	BC("1026", "中国银行"),

	CBC("1003", "建设银行"),

	CMBC("1001", "招商银行"),

	YZYH("1066", "邮储银行"),

	BCM("1020", "交通银行"),

	SPDB("1004", "浦发银行"),

	CMSB("1006", "民生银行"),

	CIB("1009", "兴业银行"),

	PAB("1010", "平安银行"),

	CITIC("1021", "中信银行"),

	HXYH("1025", "华夏银行"),

	GDB("1027", "广发银行"),

	GDYH("1022", "光大银行"),

	BJYH("1032", "北京银行"),

	NBYH("1056", "宁波银行");

	private String code;

	private String name;

	private Bank(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	private static Map<String, Bank> bankMap = new HashMap<>();

	static {
		for (Bank bank : Bank.values()) {
			bankMap.put(bank.getCode(), bank);
		}
	}

	public static Bank get(String code) {
		return bankMap.get(code);
	}

}
