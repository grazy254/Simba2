package com.simba.gaode.model.geo;

/**
 * 地理编码信息
 * 
 * @author caozhejun
 *
 */
public class GeoCode {

	/**
	 * 结构化地址信息 省份＋城市＋区县＋城镇＋乡村＋街道＋门牌号码
	 */
	private String formatted_address;

	/**
	 * 地址所在的省份名 例如：北京市。此处需要注意的是，中国的四大直辖市也算作省级单位。
	 */
	private String province;

	/**
	 * 地址所在的城市名 例如：北京市
	 */
	private String city;

	/**
	 * 城市编码 例如：010
	 */
	private String citycode;

	/**
	 * 地址所在的区 例如：朝阳区
	 */
	private String district;

	/**
	 * 地址所在的乡镇 例如：庞各庄镇
	 */
	private String township;

	/**
	 * 街道 例如：阜通东大街
	 */
	private String street;

	/**
	 * 门牌 例如：6号
	 */
	private String number;

	/**
	 * 区域编码 例如：110101
	 */
	private String adcode;

	/**
	 * 坐标点 经度，纬度
	 */
	private String location;

	/**
	 * 匹配级别 参见下方的地理编码匹配级别列表
	 */
	private String level;

	private Building building;

	private Building neighborhood;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

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

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Building getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Building neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoCode [formatted_address=");
		builder.append(formatted_address);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", citycode=");
		builder.append(citycode);
		builder.append(", district=");
		builder.append(district);
		builder.append(", township=");
		builder.append(township);
		builder.append(", street=");
		builder.append(street);
		builder.append(", number=");
		builder.append(number);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", location=");
		builder.append(location);
		builder.append(", level=");
		builder.append(level);
		builder.append(", building=");
		builder.append(building);
		builder.append(", neighborhood=");
		builder.append(neighborhood);
		builder.append("]");
		return builder.toString();
	}

}
