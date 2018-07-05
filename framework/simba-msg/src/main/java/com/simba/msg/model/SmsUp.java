package com.simba.msg.model;

/**
 * 上行短信消息
 * 
 * @author caozhejun
 *
 */
public class SmsUp {

	/**
	 * 短信接收号码
	 */
	private String phone_number;

	/**
	 * 短信内容
	 */
	private String content;

	/**
	 * 时间
	 */
	private String send_time;

	/**
	 * 扩展码
	 */
	private String dest_code;

	/**
	 * 消息序列ID
	 */
	private double sequence_id;

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getDest_code() {
		return dest_code;
	}

	public void setDest_code(String dest_code) {
		this.dest_code = dest_code;
	}

	public double getSequence_id() {
		return sequence_id;
	}

	public void setSequence_id(double sequence_id) {
		this.sequence_id = sequence_id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsUp [phone_number=");
		builder.append(phone_number);
		builder.append(", content=");
		builder.append(content);
		builder.append(", send_time=");
		builder.append(send_time);
		builder.append(", dest_code=");
		builder.append(dest_code);
		builder.append(", sequence_id=");
		builder.append(sequence_id);
		builder.append("]");
		return builder.toString();
	}

}
