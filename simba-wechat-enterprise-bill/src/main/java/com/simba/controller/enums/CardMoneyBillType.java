package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum CardMoneyBillType {

	All("","所有"),
	SUCCESS("success","转账成功"),
	FAILED("failed","转账失败"),
	PROCESSING("processing","处理中"),
	BANK_FAIL("bankfail","银行退票");
	
	private String status;
	
	private String name;

	private CardMoneyBillType(String status,String name){
		this.status=status;
		this.name=name;
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
	public static Map<String ,String> maps=new HashMap<String ,String>();
	
	static{
		
		for(CardMoneyBillType type :CardMoneyBillType.values()){
			maps.put(type.getStatus(), type.getName());
		}
	}
	
	private static Map<String ,CardMoneyBillType> map=new HashMap<String ,CardMoneyBillType>();
	
	static{
		
		for(CardMoneyBillType type :CardMoneyBillType.values()){
			map.put(type.getStatus(), type);
		}
	}
	
	public static CardMoneyBillType get(String status){
		return map.get(status);
	}
	
	
	
	
	
	
	
}
