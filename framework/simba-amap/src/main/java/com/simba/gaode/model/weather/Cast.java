package com.simba.gaode.model.weather;

/**
 * 预报数据
 * 
 * @author caozhejun
 *
 */
public class Cast {

	/**
	 * 日期
	 */
	private String date;

	/**
	 * 星期几
	 */
	private String week;

	/**
	 * 白天天气现象
	 */
	private String dayweather;

	/**
	 * 晚上天气现象
	 */
	private String nightweather;

	/**
	 * 白天温度
	 */
	private String daytemp;

	/**
	 * 晚上温度
	 */
	private String nighttemp;

	/**
	 * 白天风向
	 */
	private String daywind;

	/**
	 * 晚上风向
	 */
	private String nightwind;

	/**
	 * 白天风力
	 */
	private String daypower;

	/**
	 * 晚上风力
	 */
	private String nightpower;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDayweather() {
		return dayweather;
	}

	public void setDayweather(String dayweather) {
		this.dayweather = dayweather;
	}

	public String getNightweather() {
		return nightweather;
	}

	public void setNightweather(String nightweather) {
		this.nightweather = nightweather;
	}

	public String getDaytemp() {
		return daytemp;
	}

	public void setDaytemp(String daytemp) {
		this.daytemp = daytemp;
	}

	public String getNighttemp() {
		return nighttemp;
	}

	public void setNighttemp(String nighttemp) {
		this.nighttemp = nighttemp;
	}

	public String getDaywind() {
		return daywind;
	}

	public void setDaywind(String daywind) {
		this.daywind = daywind;
	}

	public String getNightwind() {
		return nightwind;
	}

	public void setNightwind(String nightwind) {
		this.nightwind = nightwind;
	}

	public String getDaypower() {
		return daypower;
	}

	public void setDaypower(String daypower) {
		this.daypower = daypower;
	}

	public String getNightpower() {
		return nightpower;
	}

	public void setNightpower(String nightpower) {
		this.nightpower = nightpower;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cast [date=");
		builder.append(date);
		builder.append(", week=");
		builder.append(week);
		builder.append(", dayweather=");
		builder.append(dayweather);
		builder.append(", nightweather=");
		builder.append(nightweather);
		builder.append(", daytemp=");
		builder.append(daytemp);
		builder.append(", nighttemp=");
		builder.append(nighttemp);
		builder.append(", daywind=");
		builder.append(daywind);
		builder.append(", nightwind=");
		builder.append(nightwind);
		builder.append(", daypower=");
		builder.append(daypower);
		builder.append(", nightpower=");
		builder.append(nightpower);
		builder.append("]");
		return builder.toString();
	}

}
