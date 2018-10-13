package com.simba.gaode.model.ip;

/**
 * IP定位响应对象
 * 
 * @author caozhejun
 *
 */
public class IPResult {

	/**
	 * 返回状态 值为0或1
	 * 
	 * 1：成功；0：失败
	 */
	private String status;

	/**
	 * 返回的状态信息 status为0时，info返回错误原因；否则返回ok
	 */
	private String info;

	private String infocode;

	/**
	 * 省份名称 若为直辖市则显示直辖市名称； 如果在局域网 IP网段内，则返回“局域网”； 非法IP以及国外IP则返回空
	 */
	private String province;

	/**
	 * 城市名称 若为直辖市则显示直辖市名称； 如果为局域网网段内IP或者非法IP或国外IP，则返回空
	 */
	private String city;

	/**
	 * 城市的adcode编码
	 */
	private String adcode;

	/**
	 * 所在城市矩形区域范围 所在城市范围的左下右上对标对
	 */
	private String rectangle;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
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

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getRectangle() {
		return rectangle;
	}

	public void setRectangle(String rectangle) {
		this.rectangle = rectangle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IPResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append(", rectangle=");
		builder.append(rectangle);
		builder.append("]");
		return builder.toString();
	}

}
