package com.simba.gaode.model.geo;

import java.util.List;

/**
 * 地址元素
 * 
 * @author caozhejun
 *
 */
public class AddressComponent {

	/**
	 * 坐标点所在省名称 例如：北京市
	 */
	private String province;

	/**
	 * 坐标点所在城市名称 当所在城市为北京、上海、天津、重庆四个直辖市时，该字段返回为空 当所在城市属于县级市的时候，此字段为空
	 */
	private String city;

	/**
	 * 城市编码 例如：010
	 */
	private String citycode;

	/**
	 * 坐标点所在区 例如：海淀区
	 */
	private String district;

	/**
	 * 行政区编码 例如：110108
	 */
	private String adcode;

	/**
	 * 坐标点所在乡镇/街道（此街道为社区街道，不是道路信息） 例如：燕园街道
	 */
	private String township;

	/**
	 * 镇街道编码 例如：110101001000
	 */
	private String towncode;

	/**
	 * 社区信息列表
	 */
	private Building neighborhood;

	/**
	 * 楼信息列表
	 */
	private Building building;

	/**
	 * 门牌信息列表
	 */
	private StreetNumber streetNumber;

	/**
	 * 所属海域信息 例如：渤海
	 */
	private String seaArea;

	/**
	 * 经纬度所属商圈列表
	 */
	private List<BusinessAreas> businessAreas;

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

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getTowncode() {
		return towncode;
	}

	public void setTowncode(String towncode) {
		this.towncode = towncode;
	}

	public Building getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Building neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public StreetNumber getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(StreetNumber streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getSeaArea() {
		return seaArea;
	}

	public void setSeaArea(String seaArea) {
		this.seaArea = seaArea;
	}

	public List<BusinessAreas> getBusinessAreas() {
		return businessAreas;
	}

	public void setBusinessAreas(List<BusinessAreas> businessAreas) {
		this.businessAreas = businessAreas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressComponent [province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", citycode=");
		builder.append(citycode);
		builder.append(", district=");
		builder.append(district);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", township=");
		builder.append(township);
		builder.append(", towncode=");
		builder.append(towncode);
		builder.append(", neighborhood=");
		builder.append(neighborhood);
		builder.append(", building=");
		builder.append(building);
		builder.append(", streetNumber=");
		builder.append(streetNumber);
		builder.append(", seaArea=");
		builder.append(seaArea);
		builder.append(", businessAreas=");
		builder.append(businessAreas);
		builder.append("]");
		return builder.toString();
	}

}
