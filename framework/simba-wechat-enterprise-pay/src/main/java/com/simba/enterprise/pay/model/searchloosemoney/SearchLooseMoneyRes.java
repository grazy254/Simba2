package com.simba.enterprise.pay.model.searchloosemoney;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 查询转账到零钱的响应对象
 * 
 * @author caozhejun
 *
 */
@XStreamAlias("xml")
public class SearchLooseMoneyRes {

	/**
	 * 返回状态码 (SUCCESS/FAIL
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
	 * 业务结果 (SUCCESS/FAIL)
	 */
	private String result_code;

	/**
	 * 错误代码 (错误码信息 )
	 */
	private String err_code;

	/**
	 * 商户单号 (商户使用查询API填写的单号的原路返回)
	 */
	private String partner_trade_no;

	/**
	 * 商户号(微信支付分配的商户号 )
	 */
	private String mch_id;

	/**
	 * 付款单号 (调用企业付款API时，微信系统内部产生的单号 )
	 */
	private String detail_id;

	/**
	 * 转账状态(SUCCESS:转账成功
	 * 
	 * FAILED:转账失败
	 * 
	 * PROCESSING:处理中 )
	 */
	private String status;

	/**
	 * 失败原因 (如果失败则有失败原因 )
	 */
	private String reason;

	/**
	 * 收款用户openid (转账的openid )
	 */
	private String openid;

	/**
	 * 收款用户姓名
	 */
	private String transfer_name;

	/**
	 * 付款金额单位分
	 */
	private String payment_amount;

	/**
	 * 转账时间 (发起转账的时间 )
	 */
	private String transfer_time;

	/**
	 * 付款描述 (付款时候的描述 )
	 */
	private String desc;

	private String payment_time;

	private String appid;

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

	public String getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTransfer_name() {
		return transfer_name;
	}

	public void setTransfer_name(String transfer_name) {
		this.transfer_name = transfer_name;
	}

	public String getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getTransfer_time() {
		return transfer_time;
	}

	public void setTransfer_time(String transfer_time) {
		this.transfer_time = transfer_time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchLooseMoneyRes [return_code=");
		builder.append(return_code);
		builder.append(", return_msg=");
		builder.append(return_msg);
		builder.append(", result_code=");
		builder.append(result_code);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", partner_trade_no=");
		builder.append(partner_trade_no);
		builder.append(", mch_id=");
		builder.append(mch_id);
		builder.append(", detail_id=");
		builder.append(detail_id);
		builder.append(", status=");
		builder.append(status);
		builder.append(", reason=");
		builder.append(reason);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", transfer_name=");
		builder.append(transfer_name);
		builder.append(", payment_amount=");
		builder.append(payment_amount);
		builder.append(", transfer_time=");
		builder.append(transfer_time);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", payment_time=");
		builder.append(payment_time);
		builder.append(", appid=");
		builder.append(appid);
		builder.append("]");
		return builder.toString();
	}

}
