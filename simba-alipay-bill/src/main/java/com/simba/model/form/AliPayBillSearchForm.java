package com.simba.model.form;

import com.simba.annotation.DBFieldAnnotation;

/**
 * 阿里支付账单查询对象
 * 
 * @author caozhejun
 *
 */
public class AliPayBillSearchForm {

	@DBFieldAnnotation(desc = "产品码")
	private String productCode;

	@DBFieldAnnotation(desc = "商户订单号")
	private String ourTradeNo;

	@DBFieldAnnotation(desc = "支付宝交易流水号")
	private String tradeNo;

	@DBFieldAnnotation(desc = "开始时间", oper = ">=", field = "createTime")
	private String startCreateTime;

	@DBFieldAnnotation(desc = "结束时间", oper = "<=", field = "createTime")
	private String endCreateTime;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getOurTradeNo() {
		return ourTradeNo;
	}

	public void setOurTradeNo(String ourTradeNo) {
		this.ourTradeNo = ourTradeNo;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

}
