package com.simba.alipay.controller.form;

/**
 * 阿里支付关闭订单参数对象
 * 
 * @author caozhejun
 *
 */
public class AliPayCloseForm {

	/**
	 * 订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 tradeNo,outTradeNo如果同时存在优先取tradeNo
	 */
	private String outTradeNo;

	/**
	 * 该交易在支付宝系统中的交易流水号。最短 16 位，最长 64 位。和outTradeNo不能同时为空，如果同时传了 outTradeNo和
	 * tradeNo，则以 tradeNo为准
	 */
	private String tradeNo;

	/**
	 * 卖家端自定义的的操作员 ID
	 */
	private String operatorId;

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

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

}
