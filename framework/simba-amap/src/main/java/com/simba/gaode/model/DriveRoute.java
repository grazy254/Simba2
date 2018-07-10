package com.simba.gaode.model;

import java.util.List;

/**
 * 驾车路径规划信息列表
 * 
 * @author caozhejun
 *
 */
public class DriveRoute {

	/**
	 * 起点坐标 规则： lon，lat（经度，纬度）， “,”分割，如117.500244, 40.417801 经纬度小数点不超过6位
	 */
	private String origin;

	/**
	 * 终点坐标 规则： lon，lat（经度，纬度）， “,”分割，如117.500244, 40.417801 经纬度小数点不超过6位
	 */
	private String destination;

	/**
	 * 打车费用 单位：元
	 */
	private String taxi_cost;

	/**
	 * 驾车换乘方案
	 */
	private List<DrivePath> paths;

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

	public String getTaxi_cost() {
		return taxi_cost;
	}

	public void setTaxi_cost(String taxi_cost) {
		this.taxi_cost = taxi_cost;
	}

	public List<DrivePath> getPaths() {
		return paths;
	}

	public void setPaths(List<DrivePath> paths) {
		this.paths = paths;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DriveRoute [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", taxi_cost=");
		builder.append(taxi_cost);
		builder.append(", paths=");
		builder.append(paths);
		builder.append("]");
		return builder.toString();
	}

}
