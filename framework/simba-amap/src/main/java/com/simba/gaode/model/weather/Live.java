package com.simba.gaode.model.weather;

/**
 * 实况天气数据信息
 * 
 * @author caozhejun
 *
 */
public class Live {

	/**
	 * 省份名
	 */
	private String province;

	/**
	 * 城市名
	 */
	private String city;

	/**
	 * 区域编码
	 */
	private String adcode;

	/**
	 * 天气现象（汉字描述）
	 */
	private String weather;

	/**
	 * 实时气温，单位：摄氏度
	 */
	private String temperature;

	/**
	 * 风向，风向编码对应描述
	 */
	private String winddirection;

	/**
	 * 风力，此处返回的是风力编码，风力编码对应风力级别，单位：级
	 */
	private String windpower;

	/**
	 * 空气湿度
	 */
	private String humidity;

	/**
	 * 数据发布的时间
	 */
	private String reporttime;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWinddirection() {
		return winddirection;
	}

	public void setWinddirection(String winddirection) {
		this.winddirection = winddirection;
	}

	public String getWindpower() {
		return windpower;
	}

	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getReporttime() {
		return reporttime;
	}

	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Live [province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", weather=");
		builder.append(weather);
		builder.append(", temperature=");
		builder.append(temperature);
		builder.append(", winddirection=");
		builder.append(winddirection);
		builder.append(", windpower=");
		builder.append(windpower);
		builder.append(", humidity=");
		builder.append(humidity);
		builder.append(", reporttime=");
		builder.append(reporttime);
		builder.append("]");
		return builder.toString();
	}

}
