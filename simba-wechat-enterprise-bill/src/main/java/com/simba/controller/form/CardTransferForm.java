package com.simba.controller.form;

/**
 * 微信企业转账到银行卡的请求对象
 * 
 * @author caozhejun
 *
 */
public class CardTransferForm {

	/**
	 * 商户企业付款单号-商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
	 */
	private String partner_trade_no;

	/**
	 * 银行卡所在开户行编号,详见银行编号列表
	 */
	private String bank_code;

	/**
	 * 付款金额：RMB分（支付总额，不含手续费） 注：大于0的整数
	 */
	private String amount;

	/**
	 * 付款说明 -- 企业付款到银行卡付款说明,即订单备注（UTF8编码，允许100个字符以内）
	 */
	private String desc;

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "CardTransferForm [partner_trade_no=" + partner_trade_no + ", bank_code=" + bank_code + ", amount=" + amount + ", desc=" + desc + "]";
	}

}
