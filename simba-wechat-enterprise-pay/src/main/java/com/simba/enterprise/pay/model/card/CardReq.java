package com.simba.enterprise.pay.model.card;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信企业转账到银行卡的请求对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class CardReq {

	/**
	 * 商户号(微信支付分配的商户号)
	 */
	private String mch_id;

	/**
	 * 商户企业付款单号-商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
	 */
	private String partner_trade_no;

	/**
	 * 随机字符串，不长于32位
	 */
	private String nonce_str;

	/**
	 * 签名(通过MD5签名算法计算得出的签名值，详见MD5签名生成算法)
	 */
	private String sign;

	/**
	 * 收款方银行卡号-收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见获取RSA加密公钥API
	 */
	private String enc_bank_no;

	/**
	 * 收款方用户名（采用标准RSA算法，公钥由微信侧提供）详见获取RSA加密公钥API
	 */
	private String enc_true_name;

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

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getEnc_bank_no() {
		return enc_bank_no;
	}

	public void setEnc_bank_no(String enc_bank_no) {
		this.enc_bank_no = enc_bank_no;
	}

	public String getEnc_true_name() {
		return enc_true_name;
	}

	public void setEnc_true_name(String enc_true_name) {
		this.enc_true_name = enc_true_name;
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

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
