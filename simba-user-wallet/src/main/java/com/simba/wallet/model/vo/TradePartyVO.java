package com.simba.wallet.model.vo;

import java.util.Date;

public class TradePartyVO {
	private String tradeType;
	private Long paymentAmount;
	private Date tradePaymentTime;
	private String tradeStatus;

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public Long getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Long paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Date getTradePaymentTime() {
		return tradePaymentTime;
	}

	public void setTradePaymentTime(Date tradePaymentTime) {
		this.tradePaymentTime = tradePaymentTime;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}


}
