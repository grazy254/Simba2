package com.simba.gaode.model.bike;

import java.util.List;

import com.simba.gaode.model.Step;

/**
 * 骑行方案列表信息
 * 
 * @author caozhejun
 *
 */
public class BikePath {

	/**
	 * 起终点的骑行距离 单位：米
	 */
	private String distance;

	/**
	 * 起终点的骑行时间 单位：秒
	 */
	private String duration;

	/**
	 * 具体骑行结果
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
		builder.append("BikePath [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", steps=");
		builder.append(steps);
		builder.append("]");
		return builder.toString();
	}

}
