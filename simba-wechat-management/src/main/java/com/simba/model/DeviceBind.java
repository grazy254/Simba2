package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 设备绑定
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "设备绑定")
public class DeviceBind {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 微信用户ID
	 */
	@DescAnnotation(desc = "微信用户ID")
	private String openid;

	/**
	 * 微信设备ID
	 */
	@DescAnnotation(desc = "微信设备ID")
	private String wxDeviceId;

	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getWxDeviceId() {
		return wxDeviceId;
	}

	public void setWxDeviceId(String wxDeviceId) {
		this.wxDeviceId = wxDeviceId;
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
		builder.append("DeviceBind [id=");
		builder.append(id);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", wxDeviceId=");
		builder.append(wxDeviceId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
