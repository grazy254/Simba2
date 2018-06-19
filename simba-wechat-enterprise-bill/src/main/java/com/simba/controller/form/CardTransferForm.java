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
	 * 收款方银行卡号-收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见获取RSA加密公钥API
	 */
	private String enc_bank_no;

	/**
	 * 收款方用户名
	 */
	private String trueName;

	/**
	 * 付款金额：RMB分（支付总额，不含手续费） 注：大于0的整数
	 */
	private int amount;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEnc_bank_no() {
		return enc_bank_no;
	}

	public void setEnc_bank_no(String enc_bank_no) {
		this.enc_bank_no = enc_bank_no;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardTransferForm [partner_trade_no=");
		builder.append(partner_trade_no);
		builder.append(", bank_code=");
		builder.append(bank_code);
		builder.append(", enc_bank_no=");
		builder.append(enc_bank_no);
		builder.append(", trueName=");
		builder.append(trueName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", desc=");
		builder.append(desc);
		builder.append("]");
		return builder.toString();
	}

}
