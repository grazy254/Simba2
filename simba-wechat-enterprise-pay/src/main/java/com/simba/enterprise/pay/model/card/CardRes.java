package com.simba.enterprise.pay.model.card;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 微信企业转账到银行卡的响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class CardRes {

	/**
	 * 返回状态码(SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断)
	 */
	private String return_code;

	/**
	 * 返回信息-如非空，为错误原因 签名失败 参数格式校验错误
	 */
	private String return_msg;

	/**
	 * 业务结果(SUCCESS/FAIL)
	 */
	private String result_code;

	/**
	 * 错误代码(错误码信息)
	 */
	private String err_code;

	/**
	 * 错误代码描述(错误信息描述)
	 */
	private String err_code_des;

	/**
	 * 商户号(微信支付分配的商户号)
	 */
	private String mch_id;

	/**
	 * 商户企业付款单号(商户订单号，需要保持唯一)
	 */
	private String partner_trade_no;

	/**
	 * 代付金额RMB:分
	 */
	private String amount;

	/**
	 * 随机字符串-长度小于32位
	 */
	private String nonce_str;

	/**
	 * 签名-返回包携带签名给商户
	 */
	private String sign;

	/**
	 * 微信企业付款单号--代付成功后，返回的内部业务单号
	 */
	private String payment_no;

	/**
	 * 手续费金额 RMB：分
	 */
	private int cmms_amt;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public int getCmms_amt() {
		return cmms_amt;
	}

	public void setCmms_amt(int cmms_amt) {
		this.cmms_amt = cmms_amt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_code_des=");
		builder.append(err_code_des);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", partner_trade_no=");
		builder.append(partner_trade_no);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", nonce_str=");
		builder.append(nonce_str);
		builder.append(", sign=");
		builder.append(sign);
		builder.append(", payment_no=");
		builder.append(payment_no);
		builder.append(", cmms_amt=");
		builder.append(cmms_amt);
		builder.append("]");
		return builder.toString();
	}

}
