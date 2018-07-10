package com.simba.gaode.model.walking;

import java.util.List;

import com.simba.gaode.model.Step;

/**
 * 路径方案
 * 
 * @author caozhejun
 *
 */
public class WalkingPath {

	/**
	 * 起点和终点的距离
	 * 
	 * 单位：米
	 */
	private String distance;

	/**
	 * 时间预计
	 * 
	 * 单位：秒
	 */
	private String duration;

	/**
	 * 返回结果列表
	 */
	private List<Step> steps;

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
		builder.append("Path [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", steps=");
		builder.append(steps);
		builder.append("]");
		return builder.toString();
	}

}
