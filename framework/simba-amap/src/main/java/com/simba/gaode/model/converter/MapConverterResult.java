package com.simba.gaode.model.converter;

/**
 * 坐标转换响应对象
 * 
 * @author caozhejun
 *
 */
public class MapConverterResult {

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
	 * 转换之后的坐标。若有多个坐标，则用 “;”进行区分和间隔
	 */
	private String locations;

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

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MapConverterResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", locations=");
		builder.append(locations);
		builder.append("]");
		return builder.toString();
	}

}
