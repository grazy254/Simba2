package com.simba.model;
/***********************************************************************
 * Module:  AliPayBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class AliPayBill
 ***********************************************************************/

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 阿里支付账单
 */
@DescAnnotation(desc = "阿里支付账单")
public class AliPayBill {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 应用ID
	 */
	@DescAnnotation(desc = "应用ID")
	private String appid;

	/**
	 * 描述
	 */
	@DescAnnotation(desc = "描述")
	private String body;

	/**
	 * 订单总金额(单位为分)
	 */
	@DescAnnotation(desc = "订单总金额")
	private String totalAmount;

	/**
	 * 标题
	 */
	@DescAnnotation(desc = "标题")
	private String subject;

	/**
	 * 商户订单号
	 */
	@DescAnnotation(desc = "商户订单号")
	private String outTradeNo;

	/**
	 * 支付宝交易流水号
	 */
	@DescAnnotation(desc = "支付宝交易流水号")
	private String tradeNo;

	/**
	 * 产品码
	 */
	@DescAnnotation(desc = "产品码")
	private String productCode;

	/**
	 * 商品主类型
	 */
	@DescAnnotation(desc = "商品主类型")
	private String goodType;

	/**
	 * 商户门店编号
	 */
	@DescAnnotation(desc = "商户门店编号")
	private String storeId;

	/**
	 * 收款支付宝账号ID
	 */
	@DescAnnotation(desc = "收款支付宝账号ID")
	private String sellId;

	/**
	 * 最晚付款时间
	 */
	@DescAnnotation(desc = "最晚付款时间")
	private String timeoutExpress;

	/**
	 * 订单时间
	 */
	@DescAnnotation(desc = "订单时间")
	private Date createTime;

	/**
	 * 状态(TradeStatus)
	 */
	@DescAnnotation(desc = "状态")
	private String status;

	private String outBizNo = StringUtils.EMPTY;

	private String buyerId = StringUtils.EMPTY;

	private String buyerLogonId = StringUtils.EMPTY;

	private String sellerEmail = StringUtils.EMPTY;

	private String receiptAmount = StringUtils.EMPTY;

	private String invoiceAmount = StringUtils.EMPTY;

	private String buyerPayAmount = StringUtils.EMPTY;

	private String refundFee = StringUtils.EMPTY;

	private String payTime = StringUtils.EMPTY;

	private String refundTime = StringUtils.EMPTY;

	private String closeTime = StringUtils.EMPTY;

	public String getOutBizNo() {
		return outBizNo;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerLogonId() {
		return buyerLogonId;
	}

	public void setBuyerLogonId(String buyerLogonId) {
		this.buyerLogonId = buyerLogonId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(String receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getBuyerPayAmount() {
		return buyerPayAmount;
	}

	public void setBuyerPayAmount(String buyerPayAmount) {
		this.buyerPayAmount = buyerPayAmount;
	}

	public String getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(String refundFee) {
		this.refundFee = refundFee;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getSellId() {
		return sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AliPayBill [id=");
		builder.append(id);
		builder.append(", appid=");
		builder.append(appid);
		builder.append(", body=");
		builder.append(body);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", outTradeNo=");
		builder.append(outTradeNo);
		builder.append(", tradeNo=");
		builder.append(tradeNo);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append(", goodType=");
		builder.append(goodType);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", sellId=");
		builder.append(sellId);
		builder.append(", timeoutExpress=");
		builder.append(timeoutExpress);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", outBizNo=");
		builder.append(outBizNo);
		builder.append(", buyerId=");
		builder.append(buyerId);
		builder.append(", buyerLogonId=");
		builder.append(buyerLogonId);
		builder.append(", sellerEmail=");
		builder.append(sellerEmail);
		builder.append(", receiptAmount=");
		builder.append(receiptAmount);
		builder.append(", invoiceAmount=");
		builder.append(invoiceAmount);
		builder.append(", buyerPayAmount=");
		builder.append(buyerPayAmount);
		builder.append(", refundFee=");
		builder.append(refundFee);
		builder.append(", payTime=");
		builder.append(payTime);
		builder.append(", refundTime=");
		builder.append(refundTime);
		builder.append(", closeTime=");
		builder.append(closeTime);
		builder.append("]");
		return builder.toString();
	}

}