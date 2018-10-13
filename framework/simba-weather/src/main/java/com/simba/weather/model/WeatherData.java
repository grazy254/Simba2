package com.simba.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * 天气查询返回数据对象
 * 
 * @author caozhejun
 *
 */
public class WeatherData implements Serializable {

	private static final long serialVersionUID = -5937052054544579761L;

	/**
	 * 湿度(44%)
	 */
	private String shidu;

	private String pm25;

	private String pm10;

	/**
	 * 空气质量(良)
	 */
	private String quality;

	/**
	 * 温度(26)
	 */
	private String wendu;

	/**
	 * 感冒(极少数敏感人群应减少户外活动)
	 */
	private String ganmao;

	/**
	 * 昨天天气情况
	 */
	private WeatherDay yesterday;

	/**
	 * 天气情况预报数据(列表中总共5个对象,从今天开始)
	 */
	private List<WeatherDay> forecast;

	public String getShidu() {
		return shidu;
	}

	public void setShidu(String shidu) {
		this.shidu = shidu;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getPm10() {
		return pm10;
	}

	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getWendu() {
		return wendu;
	}

	public void setWendu(String wendu) {
		this.wendu = wendu;
	}

	public String getGanmao() {
		return ganmao;
	}

	public void setGanmao(String ganmao) {
		this.ganmao = ganmao;
	}

	public WeatherDay getYesterday() {
		return yesterday;
	}

	public void setYesterday(WeatherDay yesterday) {
		this.yesterday = yesterday;
	}

	public List<WeatherDay> getForecast() {
		return forecast;
	}

	public void setForecast(List<WeatherDay> forecast) {
		this.forecast = forecast;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WetherData [shidu=");
		builder.append(shidu);
		builder.append(", pm25=");
		builder.append(pm25);
		builder.append(", pm10=");
		builder.append(pm10);
		builder.append(", quality=");
		builder.append(quality);
		builder.append(", wendu=");
		builder.append(wendu);
		builder.append(", ganmao=");
		builder.append(ganmao);
		builder.append(", yesterday=");
		builder.append(yesterday);
		builder.append(", forecast=");
		builder.append(forecast);
		builder.append("]");
		return builder.toString();
	}

}
