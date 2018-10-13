package com.simba.enterprise.pay.model.loosemoney;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 企业转账到零钱的响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class LooseMoneyRes {

	/**
	 * 返回状态码(SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断)
	 */
	private String return_code;

	/**
	 * 返回信息(返回信息，如非空，为错误原因 签名失败 参数格式校验错误)
	 */
	private String return_msg;

	/**
	 * 商户appid(申请商户号的appid或商户号绑定的appid（企业号corpid即为此appId）)
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
	 * 业务结果(SUCCESS/FAIL)
	 */
	private String result_code;

	/**
	 * 错误代码(错误码信息)
	 */
	private String err_code;

	/**
	 * 错误代码描述(结果信息描述)
	 */
	private String err_code_des;

	/**
	 * 商户订单号，需保持唯一性 (只能是字母或者数字，不能包含有符号)
	 */
	private String partner_trade_no;

	/**
	 * 微信订单号(企业付款成功，返回的微信订单号)
	 */
	private String payment_no;

	/**
	 * 微信支付成功时间(企业付款成功时间)
	 */
	private String payment_time;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

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

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LooseMoneyRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", mch_appid=");
		builder.append(mch_appid);
		builder.append(", mchid=");
		builder.append(mchid);
		builder.append(", device_info=");
		builder.append(device_info);
		builder.append(", nonce_str=");
		builder.append(nonce_str);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_code_des=");
		builder.append(err_code_des);
		builder.append(", partner_trade_no=");
		builder.append(partner_trade_no);
		builder.append(", payment_no=");
		builder.append(payment_no);
		builder.append(", payment_time=");
		builder.append(payment_time);
		builder.append("]");
		return builder.toString();
	}

}
