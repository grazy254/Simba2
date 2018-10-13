package com.simba.gaode.model.truck;

import java.util.List;

/**
 * 里面包含距离路线信息
 * 
 * @author caozhejun
 *
 */
public class TruckRoute {

	/**
	 * 起点坐标
	 */
	private String origin;

	/**
	 * 终点坐标
	 */
	private String destination;

	/**
	 * 驾车的具体方案
	 */
	private List<TruckPath> paths;

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

	public List<TruckPath> getPaths() {
		return paths;
	}

	public void setPaths(List<TruckPath> paths) {
		this.paths = paths;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckRoute [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", paths=");
		builder.append(paths);
		builder.append("]");
		return builder.toString();
	}

}
