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

	/**
	 * 上车站点所在城市的adcode|下车站点所在城市的adcode
	 */
	private String adcode;

	/**
	 * 上车点发车时间|到站时间，如大于24:00，则表示跨天
	 */
	private String time;

	/**
	 * 是否始发站，1表示为始发站，0表示非始发站
	 */
	private String start;

	/**
	 * 是否为终点站，1表示为终点站，0表示非终点站
	 */
	private String end;

	/**
	 * 途径站点的停靠时间，单位：分钟
	 */
	private String wait;

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

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getWait() {
		return wait;
	}

	public void setWait(String wait) {
		this.wait = wait;
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
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", time=");
		builder.append(time);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append(", wait=");
		builder.append(wait);
		builder.append("]");
		return builder.toString();
	}

}
