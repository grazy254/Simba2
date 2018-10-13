package com.simba.gaode.model.area;

/**
 * 城市
 * 
 * @author caozhejun
 *
 */
public class City {

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 该城市包含此关键字的个数
	 */
	private String num;

	/**
	 * 城市citycode
	 */
	private String citycode;

	/**
	 * 城市adcode
	 */
	private String adcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [name=");
		builder.append(name);
		builder.append(", num=");
		builder.append(num);
		builder.append(", citycode=");
		builder.append(citycode);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append("]");
		return builder.toString();
	}

}
