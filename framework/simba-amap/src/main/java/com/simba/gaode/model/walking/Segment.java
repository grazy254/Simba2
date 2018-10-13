package com.simba.gaode.model.walking;

import com.simba.gaode.model.bus.BusSegment;
import com.simba.gaode.model.bus.RailwaySegment;

/**
 * 换乘路段列表
 * 
 * @author caozhejun
 *
 */
public class Segment {

	/**
	 * 此路段公交导航信息
	 */
	private WalkingSegment walking;

	/**
	 * 此路段公交导航信息
	 */
	private BusSegment bus;

	/**
	 * 地铁入口 只在地铁路段有值
	 */
	private String entrance;

	/**
	 * exit 地铁出口
	 */
	private String exit;

	/**
	 * 乘坐火车的信息
	 */
	private RailwaySegment railway;

	public WalkingSegment getWalking() {
		return walking;
	}

	public void setWalking(WalkingSegment walking) {
		this.walking = walking;
	}

	public BusSegment getBus() {
		return bus;
	}

	public void setBus(BusSegment bus) {
		this.bus = bus;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public String getExit() {
		return exit;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}

	public RailwaySegment getRailway() {
		return railway;
	}

	public void setRailway(RailwaySegment railway) {
		this.railway = railway;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Segment [walking=");
		builder.append(walking);
		builder.append(", bus=");
		builder.append(bus);
		builder.append(", entrance=");
		builder.append(entrance);
		builder.append(", exit=");
		builder.append(exit);
		builder.append(", railway=");
		builder.append(railway);
		builder.append("]");
		return builder.toString();
	}

}
