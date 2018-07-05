package com.simba.weather.model;

import java.io.Serializable;

/**
 * 天气预报对象
 * 
 * @author caozhejun
 *
 */
public class Weather implements Serializable {

	private static final long serialVersionUID = -6818381559360019364L;

	/**
	 * 当前查询日期(20171027)
	 */
	private String date;

	/**
	 * 查询结果(Success !)
	 */
	private String message;

	/**
	 * 查询状态(200)
	 */
	private int status;

	/**
	 * 城市(珠海)
	 */
	private String city;

	/**
	 * 调用次数(1)
	 */
	private int count;

	/**
	 * 天气数据
	 */
	private WeatherData data;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public WeatherData getData() {
		return data;
	}

	public void setData(WeatherData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wether [date=");
		builder.append(date);
		builder.append(", message=");
		builder.append(message);
		builder.append(", status=");
		builder.append(status);
		builder.append(", city=");
		builder.append(city);
		builder.append(", count=");
		builder.append(count);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
