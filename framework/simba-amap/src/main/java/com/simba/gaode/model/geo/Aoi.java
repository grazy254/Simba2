package com.simba.gaode.model.geo;

/**
 * aoi信息
 * 
 * @author caozhejun
 *
 */
public class Aoi {

	/**
	 * 所属 aoi的id
	 */
	private String id;

	/**
	 * 所属 aoi 名称
	 */
	private String name;

	/**
	 * 所属 aoi 所在区域编码
	 */
	private String adcode;

	/**
	 * 所属 aoi 中心点坐标
	 */
	private String location;

	/**
	 * 所属aoi点面积 单位：平方米
	 */
	private String area;

	/**
	 * 输入经纬度是否在aoi面之中 0，代表在aoi内 其余整数代表距离AOI的距离
	 */
	private String distance;

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

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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
		builder.append("Aoi [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", location=");
		builder.append(location);
		builder.append(", area=");
		builder.append(area);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

}
