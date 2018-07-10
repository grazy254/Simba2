package com.simba.gaode.model.truck;

import java.util.List;

import com.simba.gaode.model.TMC;

/**
 * 具体方案
 * 
 * @author caozhejun
 *
 */
public class TruckStep {

	/**
	 * 行驶指示 例如：沿火器营路向南行驶112米左转
	 */
	private String instruction;

	/**
	 * 方向
	 */
	private String orientation;

	/**
	 * 道路名
	 */
	private String road;

	/**
	 * 此路段距离 单位：米
	 */
	private String distance;

	/**
	 * 此段收费金额 单位：元
	 */
	private String tolls;

	/**
	 * 
	 * 收费路段距离 单位：米
	 */
	private String toll_distance;

	/**
	 * 主要收费道路
	 */
	private String toll_road;

	/**
	 * 此路段预计时间
	 */
	private String duration;

	/**
	 * 此路段的坐标点
	 */
	private String polyline;

	/**
	 * 导航主要动作 例如：左转
	 */
	private String action;

	/**
	 * 导航辅助动作 例如：左转
	 */
	private String assistant_action;

	/**
	 * 驾车导航详细信息
	 */
	private List<TMC> tmcs;

	/**
	 * 途径城市列表（此节点及子节点目前还在开发，会在日后实现）
	 */
	private List<City> cities;

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getTolls() {
		return tolls;
	}

	public void setTolls(String tolls) {
		this.tolls = tolls;
	}

	public String getToll_distance() {
		return toll_distance;
	}

	public void setToll_distance(String toll_distance) {
		this.toll_distance = toll_distance;
	}

	public String getToll_road() {
		return toll_road;
	}

	public void setToll_road(String toll_road) {
		this.toll_road = toll_road;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAssistant_action() {
		return assistant_action;
	}

	public void setAssistant_action(String assistant_action) {
		this.assistant_action = assistant_action;
	}

	public List<TMC> getTmcs() {
		return tmcs;
	}

	public void setTmcs(List<TMC> tmcs) {
		this.tmcs = tmcs;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckStep [instruction=");
		builder.append(instruction);
		builder.append(", orientation=");
		builder.append(orientation);
		builder.append(", road=");
		builder.append(road);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", tolls=");
		builder.append(tolls);
		builder.append(", toll_distance=");
		builder.append(toll_distance);
		builder.append(", toll_road=");
		builder.append(toll_road);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append(", action=");
		builder.append(action);
		builder.append(", assistant_action=");
		builder.append(assistant_action);
		builder.append(", tmcs=");
		builder.append(tmcs);
		builder.append(", cities=");
		builder.append(cities);
		builder.append("]");
		return builder.toString();
	}

}
