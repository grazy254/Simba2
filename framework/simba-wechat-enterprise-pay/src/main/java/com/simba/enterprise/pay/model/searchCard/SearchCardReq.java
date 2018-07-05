package com.simba.enterprise.pay.model.searchCard;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询企业付款到银行卡的请求对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SearchCardReq {

	/**
	 * 商户号-微信支付分配的商户号
	 */
	private String mch_id;

	/**
	 * 商户企业付款单号--商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]最短8位，最长32位）
	 */
	private String partner_trade_no;

	/**
	 * 随机字符串，长度小于32位
	 */
	private String nonce_str;

	/**
	 * 商户自带签名
	 */
	private String sign;

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

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
