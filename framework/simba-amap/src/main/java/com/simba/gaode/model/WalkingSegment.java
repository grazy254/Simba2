package com.simba.gaode.model;

import java.util.List;

/**
 * 步行导航信息列表
 * 
 * @author caozhejun
 *
 */
public class WalkingSegment {

	/**
	 * 起点坐标
	 */
	private String origin;

	/**
	 * 终点坐标
	 */
	private String destination;

	/**
	 * 每段线路步行距离 单位：米
	 */
	private String distance;

	/**
	 * 步行预计时间 单位：秒
	 */
	private String duration;

	/**
	 * 步行路段列表
	 */
	private List<Step> steps;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WalkingSegment [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", steps=");
		builder.append(steps);
		builder.append("]");
		return builder.toString();
	}

}
