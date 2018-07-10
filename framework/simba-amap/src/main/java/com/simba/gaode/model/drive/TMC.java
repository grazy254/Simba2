package com.simba.gaode.model.drive;

/**
 * 驾车导航详细信息
 * 
 * @author caozhejun
 *
 */
public class TMC {

	/**
	 * 此段路的长度 单位：米
	 */
	private String distance;

	/**
	 * 此段路的交通情况 未知、畅通、缓行、拥堵
	 */
	private String status;

	/**
	 * 此段路的轨迹 规格：x1,y1;x2,y2
	 */
	private String polyline;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPolyline() {
		return polyline;
	}

	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TMC [distance=");
		builder.append(distance);
		builder.append(", status=");
		builder.append(status);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append("]");
		return builder.toString();
	}

}
