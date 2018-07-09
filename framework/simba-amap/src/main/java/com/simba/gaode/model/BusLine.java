package com.simba.gaode.model;

import java.util.List;

/**
 * 步行路段
 * 
 * @author caozhejun
 *
 */
public class BusLine {

	/**
	 * 此段起乘站信息
	 */
	private Stop departure_stop;

	/**
	 * 此段下车站
	 */
	private Stop arrival_stop;

	/**
	 * 公交路线名称 格式如：445路(南十里居--地铁望京西站)
	 */
	private String name;

	/**
	 * 公交路线id
	 */
	private String id;

	/**
	 * 公交类型 格式如：地铁线路
	 */
	private String type;

	/**
	 * 公交行驶距离 单位：米
	 */
	private String distance;

	/**
	 * 公交预计行驶时间 单位：秒
	 */
	private String duration;

	/**
	 * 此路段坐标集 格式为坐标串，如：116.481247,39.990704;116.481270,39.990726
	 */
	private String polyline;

	/**
	 * 首班车时间 格式如：0600，代表06：00
	 */
	private String start_time;

	/**
	 * 末班车时间 格式如：2300，代表23：00
	 */
	private String end_time;

	/**
	 * 此段途经公交站数
	 */
	private String via_num;

	/**
	 * 此段途经公交站点列表
	 */
	private List<Stop> via_stops;

	public Stop getDeparture_stop() {
		return departure_stop;
	}

	public void setDeparture_stop(Stop departure_stop) {
		this.departure_stop = departure_stop;
	}

	public Stop getArrival_stop() {
		return arrival_stop;
	}

	public void setArrival_stop(Stop arrival_stop) {
		this.arrival_stop = arrival_stop;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPolyline() {
		return polyline;
	}

	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getVia_num() {
		return via_num;
	}

	public void setVia_num(String via_num) {
		this.via_num = via_num;
	}

	public List<Stop> getVia_stops() {
		return via_stops;
	}

	public void setVia_stops(List<Stop> via_stops) {
		this.via_stops = via_stops;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusLine [departure_stop=");
		builder.append(departure_stop);
		builder.append(", arrival_stop=");
		builder.append(arrival_stop);
		builder.append(", name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append(", start_time=");
		builder.append(start_time);
		builder.append(", end_time=");
		builder.append(end_time);
		builder.append(", via_num=");
		builder.append(via_num);
		builder.append(", via_stops=");
		builder.append(via_stops);
		builder.append("]");
		return builder.toString();
	}

}
