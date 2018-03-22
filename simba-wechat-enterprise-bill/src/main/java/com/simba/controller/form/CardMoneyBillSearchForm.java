package com.simba.controller.form;

/**
 * 银行卡账单查询对象
 */
public class CardMoneyBillSearchForm {

	/**
	 * 商户企业付款单号
	 */
	private String partnerTradeNo;

	/**
	 * 收款方银行卡号
	 */
	private String bankNo;

	/**
	 * 收款方用户名
	 */
	private String trueName;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 微信企业付款单号
	 */
	private String paymentNo;

	private String startTime;

	private String endTime;

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}