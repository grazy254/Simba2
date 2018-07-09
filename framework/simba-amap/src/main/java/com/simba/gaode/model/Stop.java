package com.simba.gaode.model;

/**
 * 此段起乘站信息
 * 
 * @author caozhejun
 *
 */
public class Stop {

	/**
	 * 站点名字
	 */
	private String name;

	/**
	 * 站点id
	 */
	private String id;

	/**
	 * 站点经纬度
	 */
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		builder.append("Stop [name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
