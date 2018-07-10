package com.simba.gaode.model.bike;

import java.util.List;

/**
 * 骑行路径规划返回数据对象
 * 
 * @author caozhejun
 *
 */
public class BikeData {

	/**
	 * 起点坐标
	 */
	private String origin;

	/**
	 * 终点坐标
	 */
	private String destination;

	/**
	 * 骑行方案列表信息
	 */
	private List<BikePath> paths;

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

	public List<BikePath> getPaths() {
		return paths;
	}

	public void setPaths(List<BikePath> paths) {
		this.paths = paths;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BikeData [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", paths=");
		builder.append(paths);
		builder.append("]");
		return builder.toString();
	}

}
