package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 邮件记录
 */
@DescAnnotation(desc = "邮件记录")
public class Email {

	private long id;

	/**
	 * 应用ID
	 */
	@DescAnnotation(desc = "应用ID")
	private String appid;

	/**
	 * 接收方邮箱
	 */
	@DescAnnotation(desc = "接收方邮箱")
	private String toEmail;

	/**
	 * 标题
	 */
	@DescAnnotation(desc = "标题")
	private String title;

	/**
	 * 内容
	 */
	@DescAnnotation(desc = "内容")
	private String content;

	/**
	 * 类型
	 */
	@DescAnnotation(desc = "类型")
	private String type;

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

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getToEmail() {
		return toEmail;
	}

	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Email{" + "id=" + id + ", appid='" + appid + '\'' + ", toEmail='" + toEmail + '\'' + ", title='" + title + '\'' + ", content='" + content + '\'' + ", type='" + type + '\''
				+ ", createTime=" + createTime + '}';
	}

}