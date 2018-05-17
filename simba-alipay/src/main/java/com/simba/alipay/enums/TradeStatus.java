package com.simba.alipay.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 交易状态
 * 
 * @author caozhejun
 *
 */
public enum TradeStatus {

	PAY("WAIT_BUYER_PAY", "交易创建，等待买家付款"),

	CLOSED("TRADE_CLOSED", "未付款交易超时关闭，或支付完成后全额退款"),

	SUCCESS("TRADE_SUCCESS", "交易支付成功"),

	FINISH("TRADE_FINISHED", "交易结束，不可退款");

	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	private TradeStatus(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	private static final Map<String ,TradeStatus> maps = new HashMap<>();
	
	static{
		for(TradeStatus status:TradeStatus.values()){
			maps.put(status.getName(), status);
		}
	}
	
	public static TradeStatus get(String name){
		return maps.get(name);
	}
}
