package com.simba.enterprise.pay.model.loosemoney;

import com.simba.framework.util.common.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业转账到零钱的请求类对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class LooseMoneyReq {

	/**
	 * 商户账号appid(申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）)
	 */
	private String mch_appid;

	/**
	 * 商户号(微信支付分配的商户号)
	 */
	private String mchid;

	/**
	 * 设备号(微信支付分配的终端设备号)
	 */
	private String device_info;

	/**
	 * 随机字符串(随机字符串，不长于32位)
	 */
	private String nonce_str;

	/**
	 * 签名
	 */
	private String sign;

	/**
	 * 商户订单号，需保持唯一性 (只能是字母或者数字，不能包含有符号)
	 */
	private String partner_trade_no;

	/**
	 * 用户openid(商户appid下，某用户的openid)
	 */
	private String openid;

	/**
	 * 校验用户姓名选项 (NO_CHECK：不校验真实姓名 FORCE_CHECK：强校验真实姓名)
	 */
	private String check_name;

	/**
	 * 收款用户姓名(收款用户真实姓名。 如果check_name设置为FORCE_CHECK，则必填用户真实姓名)
	 */
	private String re_user_name;

	/**
	 * 金额(企业付款金额，单位为分)
	 */
	private int amount;

	/**
	 * 企业付款描述信息(企业付款操作说明信息。必填。)
	 */
	private String desc;

	/**
	 * 调用接口的机器Ip地址
	 */
	private String spbill_create_ip;

	public String getMch_appid() {
		return mch_appid;
	}

	public void setMch_appid(String mch_appid) {
		this.mch_appid = mch_appid;
	}

	public String getMchid() {
		return mchid;
	}

	public void setMchid(String mchid) {
		this.mchid = mchid;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
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

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCheck_name() {
		return check_name;
	}

	public void setCheck_name(String check_name) {
		this.check_name = check_name;
	}

	public String getRe_user_name() {
		return re_user_name;
	}

	public void setRe_user_name(String re_user_name) {
		this.re_user_name = re_user_name;
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

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String toXML() {
		return XmlUtil.fromObject(this);
	}

	@Override
	public String toString() {
		return toXML();
	}
}
