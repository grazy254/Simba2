package com.simba.gaode.model.area;

import java.util.List;

/**
 * 行政区
 * 
 * @author caozhejun
 *
 */
public class District {

	/**
	 * 城市编码
	 */
	private String citycode;

	/**
	 * 区域编码 街道没有独有的adcode，均继承父类（区县）的adcode
	 */
	private String adcode;

	/**
	 * 行政区名称
	 */
	private String name;

	/**
	 * 行政区边界坐标点 当一个行政区范围，由完全分隔两块或者多块的地块组 成，每块地的 polyline 坐标串以 | 分隔 。 如北京 的 朝阳区
	 */
	private String polyline;

	/**
	 * 城市中心点 必须说明 在区县级别，有28个区县不能返回中心点 在乡镇/街道界别，有9262个乡镇/街道不能返回中心点
	 */
	private String center;

	/**
	 * 行政区划级别 country:国家 province:省份（直辖市会在province和city显示）
	 * city:市（直辖市会在province和city显示） district:区县 street:街道
	 */
	private String level;

	/**
	 * 下级行政区列表，包含district元素
	 */
	private List<District> districts;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolyline() {
		return polyline;
	}

	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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
		builder.append("District [citycode=");
		builder.append(citycode);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", name=");
		builder.append(name);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append(", center=");
		builder.append(center);
		builder.append(", level=");
		builder.append(level);
		builder.append(", districts=");
		builder.append(districts);
		builder.append("]");
		return builder.toString();
	}

}
