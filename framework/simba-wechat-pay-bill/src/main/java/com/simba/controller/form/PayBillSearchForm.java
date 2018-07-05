package com.simba.controller.form;

/**
 * 支付账单查询对象
 */
public class PayBillSearchForm {

	/**
	 * 商户订单号
	 */
	private String outTradeNo;

	/**
	 * 订单优惠标记
	 */
	private String goodsTag;

	/**
	 * 交易类型
	 */
	private String tradeType;

	/**
	 * 商品ID
	 */
	private String productId;

	/**
	 * 用户标识
	 */
	private String openid;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 预支付交易会话标识
	 */
	private String prepayId;

	private String startTime;

	private String endTime;

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

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getGoodsTag() {
		return goodsTag;
	}

	public void setGoodsTag(String goodsTag) {
		this.goodsTag = goodsTag;
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

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

}