package com.simba.gaode.model.status;

/**
 * 交通态势响应对象
 * 
 * @author caozhejun
 *
 */
public class StatusResult {
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
	 * 交通态势信息
	 */
	private Trafficinfo trafficinfo;

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

	public Trafficinfo getTrafficinfo() {
		return trafficinfo;
	}

	public void setTrafficinfo(Trafficinfo trafficinfo) {
		this.trafficinfo = trafficinfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatusResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", trafficinfo=");
		builder.append(trafficinfo);
		builder.append("]");
		return builder.toString();
	}

}
