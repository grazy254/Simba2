package com.simba.msg.model;

/**
 * 短信回执消息SmsReport消息体格式
 * 
 * @author caozhejun
 *
 */
public class SmsReport {

	/**
	 * 短信接收号码
	 */
	private String phone_number;

	/**
	 * 发送是否成功
	 */
	private boolean success;

	/**
	 * 发送回执ID
	 */
	private String biz_id;

	/**
	 * 调用发送短信接口时传的outId
	 */
	private String out_id;

	/**
	 * 转发给运营商的时间
	 */
	private String send_time;

	/**
	 * 收到运营商回执的时间
	 */
	private String report_time;

	/**
	 * 错误码
	 */
	private String err_code;

	/**
	 * 错误信息
	 */
	private String err_msg;

	/**
	 * 140字节算一条短信，短信长度超过140字节时会拆分成多条短信发送
	 */
	private String sms_size;

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getBiz_id() {
		return biz_id;
	}

	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}

	public String getOut_id() {
		return out_id;
	}

	public void setOut_id(String out_id) {
		this.out_id = out_id;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getReport_time() {
		return report_time;
	}

	public void setReport_time(String report_time) {
		this.report_time = report_time;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_msg() {
		return err_msg;
	}

	public void setErr_msg(String err_msg) {
		this.err_msg = err_msg;
	}

	public String getSms_size() {
		return sms_size;
	}

	public void setSms_size(String sms_size) {
		this.sms_size = sms_size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsReport [phone_number=");
		builder.append(phone_number);
		builder.append(", success=");
		builder.append(success);
		builder.append(", biz_id=");
		builder.append(biz_id);
		builder.append(", out_id=");
		builder.append(out_id);
		builder.append(", send_time=");
		builder.append(send_time);
		builder.append(", report_time=");
		builder.append(report_time);
		builder.append(", err_code=");
		builder.append(err_code);
		builder.append(", err_msg=");
		builder.append(err_msg);
		builder.append(", sms_size=");
		builder.append(sms_size);
		builder.append("]");
		return builder.toString();
	}

}
