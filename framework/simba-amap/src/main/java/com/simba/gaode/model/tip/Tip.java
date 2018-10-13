package com.simba.gaode.model.tip;

/**
 * 建议提示
 * 
 * @author caozhejun
 *
 */
public class Tip {

	/**
	 * 返回数据ID 若数据为POI类型，则返回POI ID;若数据为bus类型，则返回bus id;若数据为busline类型，则返回busline id。
	 */
	private String id;

	/**
	 * tip名称
	 */
	private String name;

	/**
	 * 所属区域 省+市+区（直辖市为“市+区”）
	 */
	private String district;

	/**
	 * 区域编码 六位区县编码
	 */
	private String adcode;

	/**
	 * tip中心点坐标 当搜索数据为busline类型时，此字段不返回
	 */
	private String location;

	/**
	 * 详细地址
	 */
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tip [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", district=");
		builder.append(district);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", location=");
		builder.append(location);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
