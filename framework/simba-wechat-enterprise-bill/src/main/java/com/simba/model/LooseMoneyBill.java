package com.simba.model;
/***********************************************************************
 * Module:  LooseMoneyBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class LooseMoneyBill
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 零钱账单
 */
@DescAnnotation(desc = "零钱账单")
public class LooseMoneyBill {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 商户账号appid
	 */
	@DescAnnotation(desc = "商户账号appid")
	private String appid;

	/**
	 * 商户号
	 */
	@DescAnnotation(desc = "商户号")
	private String mchid;

	/**
	 * 设备号
	 */
	@DescAnnotation(desc = "设备号")
	private String deviceInfo;

	/**
	 * 商户订单号
	 */
	@DescAnnotation(desc = "商户订单号")
	private String partnerTradeNo;

	/**
	 * 用户openid
	 */
	@DescAnnotation(desc = "用户openid")
	private String openid;

	/**
	 * 收款用户姓名
	 */
	@DescAnnotation(desc = "收款用户姓名")
	private String reUserName;

	/**
	 * 金额
	 */
	@DescAnnotation(desc = "金额")
	private int amount;

	/**
	 * 企业付款描述信息
	 */
	@DescAnnotation(desc = "企业付款描述信息")
	private String description;

	/**
	 * Ip地址
	 */
	@DescAnnotation(desc = "Ip地址")
	private String clientIp;

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
	 * 微信订单号
	 */
	@DescAnnotation(desc = "微信订单号")
	private String paymentNo;

	/**
	 * 微信支付成功时间
	 */
	@DescAnnotation(desc = "微信支付成功时间")
	private String paymentTime;

	/**
	 * 创建时间
	 */
	@DescAnnotation(desc = "创建时间")
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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

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

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
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

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
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
		return "LooseMoneyBill{" + "id=" + id + ", appid='" + appid + '\'' + ", mchid='" + mchid + '\'' + ", deviceInfo='" + deviceInfo + '\'' + ", partnerTradeNo='" + partnerTradeNo + '\''
				+ ", openid='" + openid + '\'' + ", reUserName='" + reUserName + '\'' + ", amount=" + amount + ", description='" + description + '\'' + ", clientIp='" + clientIp + '\'' + ", status='"
				+ status + '\'' + ", errMsg='" + errMsg + '\'' + ", paymentNo='" + paymentNo + '\'' + ", paymentTime='" + paymentTime + '\'' + ", createTime=" + createTime + ", createUser='"
				+ createUser + '\'' + '}';
	}

}