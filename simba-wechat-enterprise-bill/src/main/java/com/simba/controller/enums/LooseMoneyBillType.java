package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum LooseMoneyBillType {

	All("","所有"),
	SUCCESS("success","转账成功"),
	FAILED("failed","转账失败"),
	PROCESSING("processing","处理中");
	
	private String status;
	
	private String name;

	private LooseMoneyBillType(String status,String name){
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
		
		for(LooseMoneyBillType type :LooseMoneyBillType.values()){
			maps.put(type.getStatus(), type.getName());
		}
	}
	
	private static Map<String ,LooseMoneyBillType> map=new HashMap<String ,LooseMoneyBillType>();
	
	static{
		
		for(LooseMoneyBillType type :LooseMoneyBillType.values()){
			map.put(type.getStatus(), type);
		}
	}
	
	public static LooseMoneyBillType get(String status){
		return map.get(status);
	}
	
	
	
	
	
	
	
}
