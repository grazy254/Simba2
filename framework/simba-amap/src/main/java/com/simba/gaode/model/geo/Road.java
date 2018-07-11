package com.simba.gaode.model.geo;

/**
 * 道路信息
 * 
 * @author caozhejun
 *
 */
public class Road {

	/**
	 * 道路id
	 */
	private String id;

	/**
	 * 道路名称
	 */
	private String name;

	/**
	 * 道路到请求坐标的距离 单位：米
	 */
	private String distance;

	/**
	 * 方位 输入点和此路的相对方位
	 */
	private String direction;

	/**
	 * 坐标点
	 */
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Road [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
