package com.simba.gaode.model;

/**
 * 地图地址点对象
 * 
 * @author caozhejun
 *
 */
public class MapAddressPoint {

	/**
	 * 经度
	 */
	private String lon;

	/**
	 * 纬度
	 */
	private String lat;

	public MapAddressPoint() {
	}

	public MapAddressPoint(String lon, String lat) {
		this.lon = lon;
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return this.lon + "," + this.lat;
	}

}
