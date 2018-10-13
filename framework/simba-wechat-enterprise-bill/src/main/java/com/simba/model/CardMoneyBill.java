package com.simba.model;
/***********************************************************************
 * Module:  CardMoneyBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class CardMoneyBill
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 银行卡账单
 */
@DescAnnotation(desc = "银行卡账单")
public class CardMoneyBill {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 商户号
	 */
	@DescAnnotation(desc = "商户号")
	private String mchId;

	/**
	 * 商户企业付款单号
	 */
	@DescAnnotation(desc = "商户企业付款单号")
	private String partnerTradeNo;

	/**
	 * 收款方银行卡号
	 */
	@DescAnnotation(desc = "收款方银行卡号")
	private String bankNo;

	/**
	 * 收款方用户名
	 */
	@DescAnnotation(desc = "收款方用户名")
	private String trueName;

	/**
	 * 收款方开户行
	 */
	@DescAnnotation(desc = "收款方开户行")
	private String bankCode;

	/**
	 * 付款金额
	 */
	@DescAnnotation(desc = "付款金额")
	private int amount;

	/**
	 * 付款说明
	 */
	@DescAnnotation(desc = "付款说明")
	private String description;

	/**
	 * 状态
	 */
	@DescAnnotation(desc = "状态")
	private String status;

	/**
	 * 错误信息
	 */
	@DescAnnotation(desc = "错误信息")
	private String errMsg;

	/**
	 * 微信企业付款单号
	 */
	@DescAnnotation(desc = "微信企业付款单号")
	private String paymentNo;

	/**
	 * 手续费金额
	 */
	@DescAnnotation(desc = "手续费金额")
	private int cmmsAmt;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 付款者
	 */
	@DescAnnotation(desc = "付款者")
	private String createUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

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

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public int getCmmsAmt() {
		return cmmsAmt;
	}

	public void setCmmsAmt(int cmmsAmt) {
		this.cmmsAmt = cmmsAmt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Override
	public String toString() {
		return "CardMoneyBill{" + "id=" + id + ", mchId='" + mchId + '\'' + ", partneTradeNo='" + partnerTradeNo + '\'' + ", bankNo='" + bankNo + '\'' + ", trueName='" + trueName + '\''
				+ ", bankCode='" + bankCode + '\'' + ", amount=" + amount + ", description='" + description + '\'' + ", status='" + status + '\'' + ", errMsg='" + errMsg + '\'' + ", paymentNo='"
				+ paymentNo + '\'' + ", cmmsAmt=" + cmmsAmt + ", createTime=" + createTime + ", createUser='" + createUser + '\'' + '}';
	}

}