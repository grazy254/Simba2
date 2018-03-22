package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum RedPackBillType {

	All("","所有"),
	SENDING("sending","发放中"),
	SENT("sent","已发放待领取"),
	FAILED("failed","发放失败"),
	RECEIVED("received","已领取"),
	RFUND_ING("rfunding","退款中"),
	REFUND("refund","已退款");
	
	
	private String status;
	
	private String name;

	private RedPackBillType(String status,String name){
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
		
		for(RedPackBillType type :RedPackBillType.values()){
			maps.put(type.getStatus(), type.getName());
		}
	}
	
	private static Map<String ,RedPackBillType> map=new HashMap<String ,RedPackBillType>();
	
	static{
		
		for(RedPackBillType type :RedPackBillType.values()){
			map.put(type.getStatus(), type);
		}
	}
	
	public static RedPackBillType get(String status){
		return map.get(status);
	}
	
	
	
	
	
	
	
}
