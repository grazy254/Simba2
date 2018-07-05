package com.simba.model.other;

/**
 * Created by linshuo on 2017/12/4.
 */
public class MsgPostArgs {

	/**
	 * 手机列表
	 */
	private String mobile;
	/**
	 * 时间戳+projectKey加密后的密文
	 */
	private String cipherText;
	/**
	 * 项目挨低
	 */
	private String projectId;
	/**
	 * 时间戳
	 */
	private long timeStamp;
	/**
	 * 模板挨低
	 */
	private String templateSelfId;
	/**
	 * 插入模板中的值
	 */
	private String values;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCipherText() {
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTemplateSelfId() {
		return templateSelfId;
	}

	public void setTemplateSelfId(String templateSelfId) {
		this.templateSelfId = templateSelfId;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "MsgPostArgs{" + "mobile=" + mobile + ", cipherText='" + cipherText + '\'' + ", projectId='" + projectId + '\'' + ", timeStamp='" + timeStamp + '\'' + ", templateId='"
				+ templateSelfId + '\'' + ", values=" + values + '}';
	}
}
