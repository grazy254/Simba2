package com.simba.gaode.model.autograsp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 抓路服务请求参数对象
 * 
 * @author caozhejun
 *
 */
public class AutoGraspParam {

	/**
	 * 车辆唯一标识
	 */
	private String carid;

	/**
	 * 经纬度 用于抓路的经纬度坐标，要求每次传入按utc时间排列的三个或三个以上经纬度坐标对， 且相邻经纬度gps时间间隔小于300s，距离小于1km。
	 * 坐标的经纬度之间用","间隔，坐标对之间用"|"间隔
	 */
	private String locations;

	/**
	 * gps时间 gps时间，要求为utc时间，与参数locations指定的坐标点一一对应，gps时间个数与坐标点数量一致
	 */
	private String time;

	/**
	 * 行驶方向 车辆的方位角，与参数locations指定的坐标点一一对应，方位角个数与坐标点数量一致
	 * 以正北方向为0度，沿顺时针方向为正值，取值范围[0,360)，精确到小数点后一位
	 */
	private String direction;

	/**
	 * 行驶速度 车辆行驶速度，与参数locations指定的坐标点一一对应，速度值个数与坐标点数量一致，单位：km/h
	 */
	private String speed;

	/**
	 * 显示内容 可以选base/all all的时候会显示更加详细的信息
	 */
	private String extensions;

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoGrasp [carid=");
		builder.append(carid);
		builder.append(", locations=");
		builder.append(locations);
		builder.append(", time=");
		builder.append(time);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(locations)) {
			builder.append("&locations=" + URLEncoder.encode(locations, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(time)) {
			builder.append("&time=" + time);
		}
		if (StringUtils.isNotEmpty(direction)) {
			builder.append("&direction=" + direction);
		}
		if (StringUtils.isNotEmpty(speed)) {
			builder.append("&speed=" + speed);
		}
		if (StringUtils.isNotEmpty(extensions)) {
			builder.append("&extensions=" + extensions);
		}
		if (StringUtils.isNotEmpty(carid)) {
			builder.append("&carid=" + carid);
		}
		return builder.toString();
	}
}
