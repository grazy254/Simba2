package com.simba.gaode.model.geo;

import java.util.List;

/**
 * 逆地理编码响应对象
 * 
 * @author caozhejun
 *
 */
public class RegeoResult {

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
	 * batch 字段设置为 true 时为批量请求，此时 regeocodes 标签返回，标签下为 regeocode 对象列表；batch 为false
	 * 时为单个请求，会返回 regeocode 对象；
	 */
	private Regeocodes regeocode;

	private List<Regeocodes> regeocodes;

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

	public Regeocodes getRegeocode() {
		return regeocode;
	}

	public void setRegeocode(Regeocodes regeocode) {
		this.regeocode = regeocode;
	}

	public List<Regeocodes> getRegeocodes() {
		return regeocodes;
	}

	public void setRegeocodes(List<Regeocodes> regeocodes) {
		this.regeocodes = regeocodes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegeoResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", regeocode=");
		builder.append(regeocode);
		builder.append(", regeocodes=");
		builder.append(regeocodes);
		builder.append("]");
		return builder.toString();
	}

}
