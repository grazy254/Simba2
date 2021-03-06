package com.simba.gaode.model.walking;

import java.util.List;

/**
 * 路线信息
 * 
 * @author caozhejun
 *
 */
public class WalkingRoute {

	/**
	 * 起点坐标
	 */
	private String origin;

	/**
	 * 终点坐标
	 */
	private String destination;

	/**
	 * 路线方案
	 */
	private List<WalkingPath> paths;

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

	public List<WalkingPath> getPaths() {
		return paths;
	}

	public void setPaths(List<WalkingPath> paths) {
		this.paths = paths;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Route [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", paths=");
		builder.append(paths);
		builder.append("]");
		return builder.toString();
	}

}
