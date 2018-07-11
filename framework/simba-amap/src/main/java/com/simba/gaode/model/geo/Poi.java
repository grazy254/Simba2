package com.simba.gaode.model.geo;

/**
 * poi信息
 * 
 * @author caozhejun
 *
 */
public class Poi {

	/**
	 * poi的id
	 */
	private String id;

	/**
	 * poi点名称
	 */
	private String name;

	/**
	 * poi类型
	 */
	private String type;

	/**
	 * 电话
	 */
	private String tel;

	/**
	 * 该POI到请求坐标的距离 单位：米
	 */
	private String distance;

	/**
	 * 方向 为输入点相对建筑物的方位
	 */
	private String direction;

	/**
	 * poi地址信息
	 */
	private String address;

	/**
	 * 坐标点
	 */
	private String location;

	/**
	 * poi所在商圈名称
	 */
	private String businessarea;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBusinessarea() {
		return businessarea;
	}

	public void setBusinessarea(String businessarea) {
		this.businessarea = businessarea;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Poi [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", tel=");
		builder.append(tel);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", address=");
		builder.append(address);
		builder.append(", location=");
		builder.append(location);
		builder.append(", businessarea=");
		builder.append(businessarea);
		builder.append("]");
		return builder.toString();
	}

}
