package com.simba.alipay.controller.form;

/**
 * 阿里支付退款参数对象
 * 
 * @author caozhejun
 *
 */
public class AliPayRefundForm {

	/**
	 * 支付时传入的商户订单号，与tradeNo必填一个
	 */
	private String outTradeNo;

	/**
	 * 支付时返回的支付宝交易号，与outTradeNo必填一个
	 */
	private String tradeNo;

	/**
	 * 本次退款请求流水号，部分退款时必传
	 */
	private String outRequestNo;

	/**
	 * 本次退款金额
	 */
	private String refundAmount;

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

	public String getOutRequestNo() {
		return outRequestNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AliPayRefundForm [outTradeNo=");
		builder.append(outTradeNo);
		builder.append(", tradeNo=");
		builder.append(tradeNo);
		builder.append(", outRequestNo=");
		builder.append(outRequestNo);
		builder.append(", refundAmount=");
		builder.append(refundAmount);
		builder.append("]");
		return builder.toString();
	}

}
