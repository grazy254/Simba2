package com.simba.gaode.model.weather;

import java.util.List;

/**
 * 天气查询响应对象
 * 
 * @author caozhejun
 *
 */
public class WeatherResult {

	/**
	 * 返回状态 值为0或1
	 * 
	 * 1：成功；0：失败
	 */
	private String status;

	/**
	 * 返回的状态信息 status为0时，info返回错误原因；否则返回ok
	 */
	private String info;

	/**
	 * 返回结果总数目
	 */
	private String count;

	private String infocode;

	/**
	 * 实况天气数据信息
	 */
	private List<Live> lives;

	/**
	 * 预报天气信息数据
	 */
	private List<Forecast> forecasts;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public List<Live> getLives() {
		return lives;
	}

	public void setLives(List<Live> lives) {
		this.lives = lives;
	}

	public List<Forecast> getForecasts() {
		return forecasts;
	}

	public void setForecasts(List<Forecast> forecasts) {
		this.forecasts = forecasts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", count=");
		builder.append(count);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", lives=");
		builder.append(lives);
		builder.append(", forecasts=");
		builder.append(forecasts);
		builder.append("]");
		return builder.toString();
	}

}
