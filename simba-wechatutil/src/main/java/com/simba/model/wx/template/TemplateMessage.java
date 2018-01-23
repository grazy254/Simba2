package com.simba.model.wx.template;

import java.util.Map;

public class TemplateMessage {

	/**
	 * 接收者openid
	 */
	private String touser;

	/**
	 * 模板ID
	 */
	private String template_id;

	/**
	 * 模板跳转链接
	 */
	private String url;

	/**
	 * 模板数据
	 */
	private Map<String, TemplateData> data;

	/**
	 * 小程序(跳小程序所需数据，不需跳小程序可不用传该数据)
	 */
	private MiniProgramData miniprogram;

	public MiniProgramData getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(MiniProgramData miniprogram) {
		this.miniprogram = miniprogram;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, TemplateData> getData() {
		return data;
	}

	public void setData(Map<String, TemplateData> data) {
		this.data = data;
	}

}
