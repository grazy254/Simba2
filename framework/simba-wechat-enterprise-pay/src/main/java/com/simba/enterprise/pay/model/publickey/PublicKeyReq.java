package com.simba.enterprise.pay.model.publickey;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 获取RSA加密公钥的请求对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class PublicKeyReq {

	/**
	 * 商户号(微信支付分配的商户号)
	 */
	private String mch_id;

	/**
	 * 随机字符串，长度小于32位
	 */
	private String nonce_str;

	/**
	 * 商户自带签名
	 */
	private String sign;

	/**
	 * 签名类型，支持HMAC-SHA256和MD5。
	 */
	private String sign_type = "MD5";

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
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

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
