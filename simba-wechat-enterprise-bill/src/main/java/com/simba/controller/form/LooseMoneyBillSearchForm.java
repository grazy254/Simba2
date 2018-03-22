package com.simba.controller.form;

/**
 * 零钱账单查询对象
 * 
 * @author caozhejun
 *
 */
public class LooseMoneyBillSearchForm {

	private String partnerTradeNo;

	private String openid;

	private String reUserName;

	private String status;

	private String paymentNo;

	private String startTime;

	private String endTime;

	public String getPartnerTradeNo() {
		return partnerTradeNo;
	}

	public void setPartnerTradeNo(String partnerTradeNo) {
		this.partnerTradeNo = partnerTradeNo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getReUserName() {
		return reUserName;
	}

	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LooseMoneyBillSearchForm [partnerTradeNo=");
		builder.append(partnerTradeNo);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", reUserName=");
		builder.append(reUserName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", paymentNo=");
		builder.append(paymentNo);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}

}
