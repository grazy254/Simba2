package com.simba.controller.form;

/**
 * 查询红包记录的请求对象
 */
public class SearchRedPackForm {

	

	/**
	 * 商户订单号(商户发放红包的商户订单号 )
	 */
	private String mch_billno;

	/**
	 * 订单类型 (MCHT:通过商户订单号获取红包信息。 )
	 */
	private String bill_type = "MCHT";

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	@Override
	public String toString() {
		return "SearchRedPackForm [mch_billno=" + mch_billno + ", bill_type=" + bill_type + "]";
	}
	
}