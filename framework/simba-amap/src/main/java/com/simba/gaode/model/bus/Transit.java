package com.simba.gaode.model.bus;

import java.util.List;

import com.simba.gaode.model.walking.Segment;

/**
 * 公交换乘方案
 * 
 * @author caozhejun
 *
 */
public class Transit {

	/**
	 * 此换乘方案价格 单位：元
	 */
	private String cost;

	/**
	 * 此换乘方案预期时间 单位：秒
	 */
	private String duration;

	/**
	 * 是否是夜班车 0：非夜班车；1：夜班车
	 */
	private String nightflag;

	/**
	 * 此方案总步行距离 单位：米
	 */
	private String walking_distance;

	/**
	 * 换乘路段列表
	 */
	private List<Segment> segments;

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getNightflag() {
		return nightflag;
	}

	public void setNightflag(String nightflag) {
		this.nightflag = nightflag;
	}

	public String getWalking_distance() {
		return walking_distance;
	}

	public void setWalking_distance(String walking_distance) {
		this.walking_distance = walking_distance;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transit [cost=");
		builder.append(cost);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", nightflag=");
		builder.append(nightflag);
		builder.append(", walking_distance=");
		builder.append(walking_distance);
		builder.append(", segments=");
		builder.append(segments);
		builder.append("]");
		return builder.toString();
	}

}
