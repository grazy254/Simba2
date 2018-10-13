package com.simba.gaode.model.bus;

import java.util.List;

/**
 * 公交换乘信息列表
 * 
 * @author caozhejun
 *
 */
public class BusRoute {

	/**
	 * 起点坐标
	 */
	private String origin;

	/**
	 * 终点坐标
	 */
	private String destination;

	/**
	 * 起点和终点的步行距离 单位：米
	 */
	private String distance;

	/**
	 * 出租车费用 单位：元
	 */
	private String taxi_cost;

	/**
	 * 公交换乘方案列表
	 */
	private List<Transit> transits;

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

	public String getTaxi_cost() {
		return taxi_cost;
	}

	public void setTaxi_cost(String taxi_cost) {
		this.taxi_cost = taxi_cost;
	}

	public List<Transit> getTransits() {
		return transits;
	}

	public void setTransits(List<Transit> transits) {
		this.transits = transits;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusRoute [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", taxi_cost=");
		builder.append(taxi_cost);
		builder.append(", transits=");
		builder.append(transits);
		builder.append("]");
		return builder.toString();
	}

}
