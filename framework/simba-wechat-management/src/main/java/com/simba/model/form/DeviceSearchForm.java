package com.simba.model.form;

public class DeviceSearchForm {

	/**
	 * 微信设备ID
	 */
	private String wxDeviceId;

	/**
	 * 二维码
	 */
	private String qrcode;

	/**
	 * 微信产品ID
	 */
	private String wxProductId;

	/**
	 * 状态(0:空闲,1:已用)
	 */
	private Integer status;

	public String getWxDeviceId() {
		return wxDeviceId;
	}

	public void setWxDeviceId(String wxDeviceId) {
		this.wxDeviceId = wxDeviceId;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(String wxProductId) {
		this.wxProductId = wxProductId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
