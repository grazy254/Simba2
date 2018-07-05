package com.simba.alipay.model;

/**
 * 分账明细信息
 * 
 * @author caozhejun
 *
 */
public class RoyaltyParameter {

	/**
	 * 分账支出方账户，类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
	 */
	private String trans_out;

	/**
	 * 分账收入方账户，类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
	 */
	private String trans_in;

	/**
	 * 分账的金额，单位为元
	 */
	private double amount;

	/**
	 * 分账信息中分账百分比。取值范围为大于0，少于或等于100的整数
	 */
	private int amount_percentage;

	/**
	 * 分账描述
	 */
	private String desc;

	public String getTrans_out() {
		return trans_out;
	}

	public void setTrans_out(String trans_out) {
		this.trans_out = trans_out;
	}

	public String getTrans_in() {
		return trans_in;
	}

	public void setTrans_in(String trans_in) {
		this.trans_in = trans_in;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAmount_percentage() {
		return amount_percentage;
	}

	public void setAmount_percentage(int amount_percentage) {
		this.amount_percentage = amount_percentage;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
