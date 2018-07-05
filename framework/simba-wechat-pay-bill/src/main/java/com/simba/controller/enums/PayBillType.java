package com.simba.controller.enums;

import java.util.HashMap;
import java.util.Map;

public enum PayBillType {

	All("","所有"),
	SUCCESS("success","支付成功"),
	REFUND("refund","转入退款"),
	NOTPAY("notpay","未支付"),
	CLOSED("closed","已关闭"),
	REVOKED("revoked","已撤销（刷卡支付）"),
	USERPAYING("userpaying","用户支付中"),
	PAYERROR("payerror","支付失败");
	
	private String status;
	
	private String name;

	private PayBillType(String status,String name){
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
		
		for(PayBillType type :PayBillType.values()){
			maps.put(type.getStatus(), type.getName());
		}
	}
	
	private static Map<String ,PayBillType> map=new HashMap<String ,PayBillType>();
	
	static{
		
		for(PayBillType type :PayBillType.values()){
			map.put(type.getStatus(), type);
		}
	}
	
	public static PayBillType get(String status){
		return map.get(status);
	}
	
	
	
	
	
	
	
}
