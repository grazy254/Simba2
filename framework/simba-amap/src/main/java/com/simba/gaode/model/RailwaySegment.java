package com.simba.gaode.model;

import java.util.List;

/**
 * 火车乘坐信息列表
 * 
 * @author caozhejun
 *
 */
public class RailwaySegment {

	/**
	 * 线路id编号
	 */
	private String id;

	/**
	 * 该线路车段耗时
	 */
	private String time;

	/**
	 * 线路名称
	 */
	private String name;

	/**
	 * 线路车次号
	 */
	private String trip;

	/**
	 * 该item换乘段的行车总距离
	 */
	private String distance;

	/**
	 * 线路车次类型
	 */
	private String type;

	/**
	 * 火车始发站信息
	 */
	private Stop departure_stop;

	/**
	 * 火车到站信息
	 */
	private Stop arrival_stop;

	/**
	 * 途径站点信息，extensions=all时返回
	 */
	private Stop via_stop;

	/**
	 * 聚合的备选方案，extensions=all时返回
	 */
	private List<Alter> alters;

	/**
	 * 仓位及价格信息
	 */
	private List<Space> spaces;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public Stop getVia_stop() {
		return via_stop;
	}

	public void setVia_stop(Stop via_stop) {
		this.via_stop = via_stop;
	}

	public List<Alter> getAlters() {
		return alters;
	}

	public void setAlters(List<Alter> alters) {
		this.alters = alters;
	}

	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RailwaySegment [id=");
		builder.append(id);
		builder.append(", time=");
		builder.append(time);
		builder.append(", name=");
		builder.append(name);
		builder.append(", trip=");
		builder.append(trip);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", type=");
		builder.append(type);
		builder.append(", departure_stop=");
		builder.append(departure_stop);
		builder.append(", arrival_stop=");
		builder.append(arrival_stop);
		builder.append(", via_stop=");
		builder.append(via_stop);
		builder.append(", alters=");
		builder.append(alters);
		builder.append(", spaces=");
		builder.append(spaces);
		builder.append("]");
		return builder.toString();
	}

}
