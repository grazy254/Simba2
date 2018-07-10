package com.simba.gaode.model.truck;

import java.util.List;

/**
 * 途径城市
 * 
 * @author caozhejun
 *
 */
public class City {

	/**
	 * 途径城市名字
	 */
	private String name;

	/**
	 * 途径城市citycode
	 */
	private String citycode;

	/**
	 * 途径城市adcode
	 */
	private String adcode;

	/**
	 * 途径地
	 */
	private List<District> districts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [name=");
		builder.append(name);
		builder.append(", citycode=");
		builder.append(citycode);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", districts=");
		builder.append(districts);
		builder.append("]");
		return builder.toString();
	}

}
