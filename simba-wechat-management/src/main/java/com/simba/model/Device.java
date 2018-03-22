package com.simba.model;

import java.io.Serializable;

import com.simba.annotation.DescAnnotation;

/**
 * 设备
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "设备")
public class Device implements Serializable {

	private static final long serialVersionUID = -3739616828090971498L;

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 微信设备ID
	 */
	@DescAnnotation(desc = "微信设备ID")
	private String wxDeviceId;

	/**
	 * 二维码
	 */
	@DescAnnotation(desc = "二维码")
	private String qrcode;

	/**
	 * 微信产品ID
	 */
	@DescAnnotation(desc = "微信产品ID")
	private String wxProductId;

	/**
	 * 状态(0:空闲,1:已用)
	 */
	@DescAnnotation(desc = "状态")
	private int status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [id=");
		builder.append(id);
		builder.append(", wxDeviceId=");
		builder.append(wxDeviceId);
		builder.append(", qrcode=");
		builder.append(qrcode);
		builder.append(", wxProductId=");
		builder.append(wxProductId);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
