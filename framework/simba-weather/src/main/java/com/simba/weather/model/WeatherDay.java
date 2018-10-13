package com.simba.weather.model;

import java.io.Serializable;

/**
 * 一天的天气数据对象
 * 
 * @author caozhejun
 *
 */
public class WeatherDay implements Serializable {

	private static final long serialVersionUID = 3691617557420364516L;

	/**
	 * 日期时间(26日星期四)
	 */
	private String date;

	/**
	 * 日出时间(06:26)
	 */
	private String sunrise;

	/**
	 * 当天最高温(高温 27.0℃)
	 */
	private String high;

	/**
	 * 当天最低温(低温 22.0℃)
	 */
	private String low;

	/**
	 * 日落时间(17:53)
	 */
	private String sunset;

	/**
	 * 空气质量(136)
	 */
	private int aqi;

	/**
	 * 风向(无持续风向)
	 */
	private String fx;

	/**
	 * 风力(<3级)
	 */
	private String fl;

	/**
	 * 天气类型(晴)
	 */
	private String type;

	/**
	 * 注意(晴空万里，去沐浴阳光吧)
	 */
	private String notice;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public String getFx() {
		return fx;
	}

	public void setFx(String fx) {
		this.fx = fx;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WetherDay [date=");
		builder.append(date);
		builder.append(", sunrise=");
		builder.append(sunrise);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", sunset=");
		builder.append(sunset);
		builder.append(", aqi=");
		builder.append(aqi);
		builder.append(", fx=");
		builder.append(fx);
		builder.append(", fl=");
		builder.append(fl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", notice=");
		builder.append(notice);
		builder.append("]");
		return builder.toString();
	}

}
