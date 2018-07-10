package com.simba.gaode.model;

import java.util.List;

/**
 * 导航路段
 * 
 * @author caozhejun
 *
 */
public class DriveStep {

	/**
	 * 路段指示
	 */
	private String instruction;

	/**
	 * 道路名称
	 */
	private String road;

	/**
	 * 此路段距离
	 * 
	 * 单位：米
	 */
	private String distance;

	/**
	 * 方向
	 */
	private String orientation;

	/**
	 * 此段收费 单位：元
	 */
	private String tolls;

	/**
	 * 收费路段距离 单位：米
	 */
	private String toll_distance;

	/**
	 * 主要收费道路
	 */
	private String toll_road;

	/**
	 * 此路段坐标点串 格式为坐标串，如：116.481247,39.990704;116.481270,39.990726
	 */
	private String polyline;

	/**
	 * 导航主要动作
	 */
	private String action;

	/**
	 * 导航辅助动作
	 */
	private String assistant_action;

	/**
	 * 驾车导航详细信息
	 */
	private List<TMC> tmcs;

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
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

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DriveStep [instruction=");
		builder.append(instruction);
		builder.append(", road=");
		builder.append(road);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", orientation=");
		builder.append(orientation);
		builder.append(", tolls=");
		builder.append(tolls);
		builder.append(", toll_distance=");
		builder.append(toll_distance);
		builder.append(", toll_road=");
		builder.append(toll_road);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append(", action=");
		builder.append(action);
		builder.append(", assistant_action=");
		builder.append(assistant_action);
		builder.append(", tmcs=");
		builder.append(tmcs);
		builder.append("]");
		return builder.toString();
	}

}
