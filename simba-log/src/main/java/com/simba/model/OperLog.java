package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 操作日志
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "操作日志")
public class OperLog {

	private long id;

	/**
	 * 账号
	 */
	@DescAnnotation(desc = "账号")
	private String account;

	/**
	 * IP
	 */
	@DescAnnotation(desc = "IP")
	private String ip;

	/**
	 * 地址
	 */
	@DescAnnotation(desc = "地址")
	private String address;

	/**
	 * 内容
	 */
	@DescAnnotation(desc = "内容")
	private String content;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperLog [id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", ip=");
		builder.append(ip);
		builder.append(", address=");
		builder.append(address);
		builder.append(", content=");
		builder.append(content);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
