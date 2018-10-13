package com.simba.enterprise.pay.model.searchCard;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询企业付款到银行卡的响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SearchCardRes {

	/**
	 * 返回状态码 ( SUCCESS/FAIL
	 * 
	 * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断 )
	 */
	private String return_code;

	/**
	 * 返回信息，如非空，为错误原因
	 * 
	 * 签名失败
	 * 
	 * 参数格式校验错误
	 * 
	 */
	private String return_msg;

	/**
	 * 业务结果 (SUCCESS/FAIL )
	 */
	private String result_code;

	/**
	 * 错误代码 (错误码信息)
	 */
	private String err_code;

	/**
	 * 错误代码描述 (结果信息描述 )
	 */
	private String err_code_des;

	/**
	 * 商户号
	 */
	private String mch_id;

	/**
	 * 商户企业付款单号(商户单号)
	 */
	private String partner_trade_no;

	/**
	 * 微信企业付款单号(即为微信内部业务单号)
	 */
	private String payment_no;

	/**
	 * 收款用户银行卡号(MD5加密)
	 */
	private String bank_no_md5;

	/**
	 * 收款人真实姓名（MD5加密）
	 */
	private String true_name_md5;

	/**
	 * 代付订单金额RMB：分
	 */
	private String amount;

	/**
	 * 代付订单状态： PROCESSING（处理中，如有明确失败，则返回额外失败原因；否则没有错误原因） SUCCESS（付款成功）
	 * FAILED（付款失败,需要替换付款单号重新发起付款）
	 * BANK_FAIL（银行退票，订单状态由付款成功流转至退票,退票时付款金额和手续费会自动退还）
	 */
	private String status;

	/**
	 * 手续费订单金额 RMB：分
	 */
	private String cmms_amt;

	/**
	 * 商户下单时间(微信侧订单创建时间)
	 */
	private String create_time;

	/**
	 * 成功付款时间 -- 微信侧付款成功时间（但无法保证银行不会退票）
	 */
	private String pay_succ_time;

	/**
	 * 订单失败原因（如：余额不足）
	 */
	private String reason;

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

	public String getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}

	public String getBank_no_md5() {
		return bank_no_md5;
	}

	public void setBank_no_md5(String bank_no_md5) {
		this.bank_no_md5 = bank_no_md5;
	}

	public String getTrue_name_md5() {
		return true_name_md5;
	}

	public void setTrue_name_md5(String true_name_md5) {
		this.true_name_md5 = true_name_md5;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCmms_amt() {
		return cmms_amt;
	}

	public void setCmms_amt(String cmms_amt) {
		this.cmms_amt = cmms_amt;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getPay_succ_time() {
		return pay_succ_time;
	}

	public void setPay_succ_time(String pay_succ_time) {
		this.pay_succ_time = pay_succ_time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchCardRes [return_code=");
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
		builder.append(", payment_no=");
		builder.append(payment_no);
		builder.append(", bank_no_md5=");
		builder.append(bank_no_md5);
		builder.append(", true_name_md5=");
		builder.append(true_name_md5);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", cmms_amt=");
		builder.append(cmms_amt);
		builder.append(", create_time=");
		builder.append(create_time);
		builder.append(", pay_succ_time=");
		builder.append(pay_succ_time);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}

}
