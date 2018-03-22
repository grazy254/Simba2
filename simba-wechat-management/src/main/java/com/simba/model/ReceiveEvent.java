package com.simba.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 收到事件
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "收到事件")
public class ReceiveEvent {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 微信用户ID
	 */
	@DescAnnotation(desc = "微信用户ID")
	private String openid = StringUtils.EMPTY;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 消息类型
	 */
	@DescAnnotation(desc = "消息类型")
	private String type = StringUtils.EMPTY;

	/**
	 * 事件类型
	 */
	@DescAnnotation(desc = "事件类型")
	private String event = StringUtils.EMPTY;

	/**
	 * 事件KEY值
	 */
	@DescAnnotation(desc = "事件KEY值")
	private String eventKey = StringUtils.EMPTY;

	/**
	 * 菜单ID
	 */
	@DescAnnotation(desc = "菜单ID")
	private String menuId = StringUtils.EMPTY;

	/**
	 * 扫描类型
	 */
	@DescAnnotation(desc = "扫描类型")
	private String scanType = StringUtils.EMPTY;

	/**
	 * 扫描结果
	 */
	@DescAnnotation(desc = "扫描结果")
	private String scanResult = StringUtils.EMPTY;

	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	@DescAnnotation(desc = "ticket")
	private String ticket = StringUtils.EMPTY;

	/**
	 * 地理位置纬度
	 */
	@DescAnnotation(desc = "地理位置纬度")
	private String latitude = StringUtils.EMPTY;

	/**
	 * 地理位置经度
	 */
	@DescAnnotation(desc = "地理位置经度")
	private String longitude = StringUtils.EMPTY;

	/**
	 * 地理位置精度
	 */
	@DescAnnotation(desc = "地理位置精度")
	private String eventPrecision = StringUtils.EMPTY;

	/**
	 * 完整事件XML内容
	 */
	@DescAnnotation(desc = "完整事件XML内容")
	private String xml = StringUtils.EMPTY;

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getScanResult() {
		return scanResult;
	}

	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEventPrecision() {
		return eventPrecision;
	}

	public void setEventPrecision(String eventPrecision) {
		this.eventPrecision = eventPrecision;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveEvent [id=");
		builder.append(id);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", event=");
		builder.append(event);
		builder.append(", eventKey=");
		builder.append(eventKey);
		builder.append(", menuId=");
		builder.append(menuId);
		builder.append(", scanType=");
		builder.append(scanType);
		builder.append(", scanResult=");
		builder.append(scanResult);
		builder.append(", ticket=");
		builder.append(ticket);
		builder.append(", latitude=");
		builder.append(latitude);
		builder.append(", longitude=");
		builder.append(longitude);
		builder.append(", eventPrecision=");
		builder.append(eventPrecision);
		builder.append(", xml=");
		builder.append(xml);
		builder.append("]");
		return builder.toString();
	}

}
