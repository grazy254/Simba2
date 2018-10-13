package com.simba.gaode.model.geo;

import java.util.List;

/**
 * 逆地理编码
 * 
 * @author caozhejun
 *
 */
public class Regeocodes {

	/**
	 * 结构化地址信息 结构化地址信息包括：省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码 如果坐标点处于海域范围内，则结构化地址信息为：省份＋城市＋区县＋海域信息
	 */
	private String formatted_address;

	/**
	 * 地址元素列表
	 */
	private AddressComponent addressComponent;

	/**
	 * poi信息列表
	 */
	private List<Poi> pois;

	/**
	 * 道路信息列表
	 */
	private List<Road> roads;

	/**
	 * 道路交叉口列表
	 */
	private List<Roadinter> roadinters;

	/**
	 * aoi信息列表
	 */
	private List<Aoi> aois;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public AddressComponent getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressComponent addressComponent) {
		this.addressComponent = addressComponent;
	}

	public List<Poi> getPois() {
		return pois;
	}

	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}

	public List<Road> getRoads() {
		return roads;
	}

	public void setRoads(List<Road> roads) {
		this.roads = roads;
	}

	public List<Roadinter> getRoadinters() {
		return roadinters;
	}

	public void setRoadinters(List<Roadinter> roadinters) {
		this.roadinters = roadinters;
	}

	public List<Aoi> getAois() {
		return aois;
	}

	public void setAois(List<Aoi> aois) {
		this.aois = aois;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regeocodes [formatted_address=");
		builder.append(formatted_address);
		builder.append(", addressComponent=");
		builder.append(addressComponent);
		builder.append(", pois=");
		builder.append(pois);
		builder.append(", roads=");
		builder.append(roads);
		builder.append(", roadinters=");
		builder.append(roadinters);
		builder.append(", aois=");
		builder.append(aois);
		builder.append("]");
		return builder.toString();
	}

}
