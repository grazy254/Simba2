package com.simba.redpack.model.search;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询红包记录的请求对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SearchReq {

	/**
	 * 随机字符串，不长于32位
	 */
	private String nonce_str;

	/**
	 * 签名(详见签名生成算法)
	 */
	private String sign;

	/**
	 * 商户订单号(商户发放红包的商户订单号 )
	 */
	private String mch_billno;

	/**
	 * 商户号(微信支付分配的商户号)
	 */
	private String mch_id;

	/**
	 * Appid --
	 * 微信分配的公众账号ID（企业号corpid即为此appId），接口传入的所有appid应该为公众号的appid（在mp.weixin.qq.com申请的），不能为APP的appid（在open.weixin.qq.com申请的）。
	 */
	private String appid;

	/**
	 * 订单类型 (MCHT:通过商户订单号获取红包信息。 )
	 */
	private String bill_type = "MCHT";

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

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
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

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
