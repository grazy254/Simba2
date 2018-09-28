package com.simba.arg;

/**
 * Created by shuoGG on 2018/9/26
 */
public class EmailArgs {
	/**
	 * 应用ID
	 */
	private String appid;

	/**
	 * 接收方邮箱
	 */
	private String toEmail;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 类型
	 */
	private String type;

	public EmailArgs(String appid, String toEmail, String title, String content, String type) {
		this.appid = appid;
		this.toEmail = toEmail;
		this.title = title;
		this.content = content;
		this.type = type;
	}

	public EmailArgs() {
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

	@Override
	public String toString() {
		return "EmailArgs{" + "appid='" + appid + '\'' + ", toEmail='" + toEmail + '\'' + ", title='" + title + '\'' + ", content='" + content + '\'' + ", type='" + type + '\'' + '}';
	}
}
