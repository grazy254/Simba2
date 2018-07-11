package com.simba.gaode.model.geo;

/**
 * 经纬度所属商圈
 * 
 * @author caozhejun
 *
 */
public class BusinessAreas {

	/**
	 * 商圈中心点经纬度
	 */
	private String location;

	/**
	 * 商圈名称 例如：颐和园
	 */
	private String name;

	/**
	 * 商圈所在区域的adcode 例如：朝阳区/海淀区
	 */
	private String id;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusinessAreas [location=");
		builder.append(location);
		builder.append(", name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
