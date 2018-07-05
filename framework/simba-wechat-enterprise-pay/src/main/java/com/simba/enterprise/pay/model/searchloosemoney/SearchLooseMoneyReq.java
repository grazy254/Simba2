package com.simba.enterprise.pay.model.searchloosemoney;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 请求查询转账到零钱的对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SearchLooseMoneyReq {

	/**
	 * 随机字符串 (不长于32位)
	 */
	private String nonce_str;

	/**
	 * 签名 (生成签名方式查看3.2.1节 )
	 */
	private String sign;

	/**
	 * 商户订单号 (商户调用企业付款API时使用的商户订单号 )
	 */
	private String partner_trade_no;

	/**
	 * 商户号 (微信支付分配的商户号 )
	 */
	private String mch_id;

	/**
	 * Appid (商户号的appid )
	 */
	private String appid;

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

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
