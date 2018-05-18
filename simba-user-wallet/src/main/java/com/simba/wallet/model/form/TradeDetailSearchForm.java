package com.simba.wallet.model.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.simba.annotation.DBFieldAnnotation;

public class TradeDetailSearchForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@DBFieldAnnotation(desc = "开始日期", field = "tradePaymentTime", oper = ">=")
	private Date startTime;

	@DBFieldAnnotation(desc = "结束日期", field = "tradePaymentTime", oper = "<")
	private Date endTime;

	@DBFieldAnnotation(desc = "订单号")
	private String tradeNO;

	@DBFieldAnnotation(desc = "交易类型")
	private String tradeType;

	@DBFieldAnnotation(desc = "交易状态")
	private String tradeStatus;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTradeNO() {
		return tradeNO;
	}

	public void setTradeNO(String tradeNO) {
		this.tradeNO = tradeNO;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}


}
