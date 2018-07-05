package com.simba.model;
/***********************************************************************
 * Module:  PayBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class PayBill
 ***********************************************************************/

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 支付账单
 */
@DescAnnotation(desc = "支付账单")
public class PayBill {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * AppID
	 */
	@DescAnnotation(desc = "AppID")
	private String appid;

	/**
	 * 商户号
	 */
	@DescAnnotation(desc = "商户号")
	private String mchId;

	/**
	 * 设备号
	 */
	@DescAnnotation(desc = "设备号")
	private String deviceInfo = StringUtils.EMPTY;

	/**
	 * 商品描述
	 */
	@DescAnnotation(desc = "商品描述")
	private String productDesc = StringUtils.EMPTY;

	/**
	 * 商品详情
	 */
	@DescAnnotation(desc = "商品详情")
	private String detail = StringUtils.EMPTY;

	/**
	 * 附加数据
	 */
	@DescAnnotation(desc = "附加数据")
	private String attach = StringUtils.EMPTY;

	/**
	 * 商户订单号
	 */
	@DescAnnotation(desc = "商户订单号")
	private String outTradeNo;

	/**
	 * 标价金额
	 */
	@DescAnnotation(desc = "标价金额")
	private int fee;

	/**
	 * 终端IP
	 */
	@DescAnnotation(desc = "终端IP")
	private String clientIp = StringUtils.EMPTY;

	/**
	 * 交易起始时间
	 */
	@DescAnnotation(desc = "交易起始时间")
	private String startTime = StringUtils.EMPTY;

	/**
	 * 交易结束时间
	 */
	@DescAnnotation(desc = "交易结束时间")
	private String endTime = StringUtils.EMPTY;

	/**
	 * 订单优惠标记
	 */
	@DescAnnotation(desc = "订单优惠标记")
	private String goodsTag = StringUtils.EMPTY;

	/**
	 * 通知地址
	 */
	@DescAnnotation(desc = "通知地址")
	private String notifyUrl = StringUtils.EMPTY;

	/**
	 * 交易类型
	 */
	@DescAnnotation(desc = "交易类型")
	private String tradeType = StringUtils.EMPTY;

	/**
	 * 商品ID
	 */
	@DescAnnotation(desc = "商品ID")
	private String productId = StringUtils.EMPTY;

	/**
	 * 用户标识
	 */
	@DescAnnotation(desc = "用户标识")
	private String openid;

	/**
	 * 状态(SUCCESS—支付成功
	 * 
	 * REFUND—转入退款
	 * 
	 * NOTPAY—未支付
	 * 
	 * CLOSED—已关闭
	 * 
	 * REVOKED—已撤销（刷卡支付）
	 * 
	 * USERPAYING--用户支付中
	 * 
	 * PAYERROR--支付失败 )
	 */
	@DescAnnotation(desc = "状态")
	private String status;

	/**
	 * 错误信息
	 */
	@DescAnnotation(desc = "错误信息")
	private String errMsg = StringUtils.EMPTY;

	/**
	 * 预支付交易会话标识
	 */
	@DescAnnotation(desc = "预支付交易会话标识")
	private String prepayId;

	/**
	 * 二维码链接
	 */
	@DescAnnotation(desc = "二维码链接")
	private String codeUrl = StringUtils.EMPTY;

	/**
	 * H5支付链接
	 */
	@DescAnnotation(desc = "H5支付链接")
	private String mwebUrl = StringUtils.EMPTY;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

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

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
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

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getMwebUrl() {
		return mwebUrl;
	}

	public void setMwebUrl(String mwebUrl) {
		this.mwebUrl = mwebUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "PayBill{" + "id=" + id + ", appid='" + appid + '\'' + ", mchId='" + mchId + '\'' + ", deviceInfo='" + deviceInfo + '\'' + ", productDesc='" + productDesc + '\'' + ", detail='" + detail
				+ '\'' + ", attach='" + attach + '\'' + ", outTradeNo='" + outTradeNo + '\'' + ", fee=" + fee + ", clientIp='" + clientIp + '\'' + ", startTime='" + startTime + '\'' + ", endTime='"
				+ endTime + '\'' + ", goodsTag='" + goodsTag + '\'' + ", notifyUrl='" + notifyUrl + '\'' + ", tradeType='" + tradeType + '\'' + ", productId='" + productId + '\'' + ", openid='"
				+ openid + '\'' + ", status='" + status + '\'' + ", errMsg='" + errMsg + '\'' + ", prepayId='" + prepayId + '\'' + ", codeUrl='" + codeUrl + '\'' + ", mwebUrl='" + mwebUrl + '\''
				+ ", createTime=" + createTime + '}';
	}

}