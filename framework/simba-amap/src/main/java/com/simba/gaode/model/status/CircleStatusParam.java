package com.simba.gaode.model.status;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

/**
 * 圆形区域交通态势
 * 
 * @author caozhejun
 *
 */
public class CircleStatusParam {

	public CircleStatusParam() {

	}

	public CircleStatusParam(String location) {
		this.location = location;
	}

	/**
	 * 道路等级 指定道路等级，下面各值代表的含义： 1：高速（京藏高速） 2：城市快速路、国道(西三环、103国道) 3：高速辅路（G6辅路）
	 * 4：主要道路（长安街、三环辅路路） 5：一般道路（彩和坊路） 6：无名道路
	 */
	private String level;

	/**
	 * 返回结果控制 可选值：base,all
	 */
	private String extensions;

	/**
	 * 中心点坐标 经度在前，纬度在后。经度和纬度用","分割。 经纬度小数点后不得超过6位
	 */
	private String location;

	/**
	 * 半径 单位：米，最大取值5000米。
	 */
	private String radius;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CircleStatusParam [level=");
		builder.append(level);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append(", location=");
		builder.append(location);
		builder.append(", radius=");
		builder.append(radius);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(location)) {
			builder.append("&location=" + location);
		}
		if (StringUtils.isNotEmpty(radius)) {
			builder.append("&radius=" + radius);
		}
		if (StringUtils.isNotEmpty(level)) {
			builder.append("&level=" + level);
		}
		if (StringUtils.isNotEmpty(extensions)) {
			builder.append("&extensions=" + extensions);
		}
		return builder.toString();
	}

}
