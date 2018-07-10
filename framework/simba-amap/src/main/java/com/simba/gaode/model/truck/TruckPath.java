package com.simba.gaode.model.truck;

import java.util.List;

/**
 * 驾车的具体方案
 * 
 * @author caozhejun
 *
 */
public class TruckPath {

	/**
	 * 此方案的行驶距离
	 */
	private String distance;

	/**
	 * 此方案的耗时
	 */
	private String duration;

	/**
	 * 导航策略
	 */
	private String strategy;

	/**
	 * 此导航方案道路收费金额 单位：元
	 */
	private String tolls;

	/**
	 * 此导航方案道路收费距离长度 单位：米
	 */
	private String toll_distance;

	/**
	 * 限行结果 0，未知（未输入完整/正确车牌号信息时候显示） 1，已规避限行 2，起点限行 3，途径点在限行区域内（设置途径点才出现此报错） 4，途径限行区域
	 * 5，终点限行
	 */
	private String restriction;

	/**
	 * 此方案红绿灯总数 单位：个
	 */
	private String traffic_lights;

	private List<TruckStep> steps;

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

	public String getToll_distance() {
		return toll_distance;
	}

	public void setToll_distance(String toll_distance) {
		this.toll_distance = toll_distance;
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

	public List<TruckStep> getSteps() {
		return steps;
	}

	public void setSteps(List<TruckStep> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckPath [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append(", tolls=");
		builder.append(tolls);
		builder.append(", toll_distance=");
		builder.append(toll_distance);
		builder.append(", restriction=");
		builder.append(restriction);
		builder.append(", traffic_lights=");
		builder.append(traffic_lights);
		builder.append(", steps=");
		builder.append(steps);
		builder.append("]");
		return builder.toString();
	}

}
