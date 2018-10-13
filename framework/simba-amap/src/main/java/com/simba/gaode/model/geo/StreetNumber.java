package com.simba.gaode.model.geo;

/**
 * 门牌信息
 * 
 * @author caozhejun
 *
 */
public class StreetNumber {

	/**
	 * 街道名称 例如：中关村北二条
	 */
	private String street;

	/**
	 * 门牌号 例如：3号
	 */
	private String number;

	/**
	 * 坐标点 经纬度坐标点：经度，纬度
	 */
	private String location;

	/**
	 * 方向 坐标点所处街道方位
	 */
	private String direction;

	/**
	 * 门牌地址到请求坐标的距离 单位：米
	 */
	private String distance;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StreetNumber [street=");
		builder.append(street);
		builder.append(", number=");
		builder.append(number);
		builder.append(", location=");
		builder.append(location);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

}
