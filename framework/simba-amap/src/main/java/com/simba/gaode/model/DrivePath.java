package com.simba.gaode.model;

import java.util.List;

/**
 * 驾车换乘方案
 * 
 * @author caozhejun
 *
 */
public class DrivePath {

	/**
	 * 行驶距离 单位：米
	 */
	private String distance;

	/**
	 * 预计行驶时间 单位：秒
	 */
	private String duration;

	/**
	 * 导航策略
	 */
	private String strategy;

	/**
	 * 此导航方案道路收费 单位：元
	 */
	private String tolls;

	/**
	 * 限行结果 0 代表限行已规避或未限行，即该路线没有限行路段 1 代表限行无法规避，即该线路有限行路段
	 */
	private String restriction;

	/**
	 * 红绿灯个数
	 */
	private String traffic_lights;

	/**
	 * 收费路段距离
	 */
	private String toll_distance;

	/**
	 * 导航路段
	 */
	private List<DriveStep> steps;

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

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getTolls() {
		return tolls;
	}

	public void setTolls(String tolls) {
		this.tolls = tolls;
	}

	public String getRestriction() {
		return restriction;
	}

	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	public String getTraffic_lights() {
		return traffic_lights;
	}

	public void setTraffic_lights(String traffic_lights) {
		this.traffic_lights = traffic_lights;
	}

	public String getToll_distance() {
		return toll_distance;
	}

	public void setToll_distance(String toll_distance) {
		this.toll_distance = toll_distance;
	}

	public List<DriveStep> getSteps() {
		return steps;
	}

	public void setSteps(List<DriveStep> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DrivePath [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append(", tolls=");
		builder.append(tolls);
		builder.append(", restriction=");
		builder.append(restriction);
		builder.append(", traffic_lights=");
		builder.append(traffic_lights);
		builder.append(", toll_distance=");
		builder.append(toll_distance);
		builder.append(", steps=");
		builder.append(steps);
		builder.append("]");
		return builder.toString();
	}

}
