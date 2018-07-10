package com.simba.gaode.model.distance;

import java.util.List;

/**
 * 距离测量返回结果
 * 
 * @author caozhejun
 *
 */
public class DistanceResult {

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
	 * 距离信息列表
	 */
	private List<Result> results;

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

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DistanceResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", results=");
		builder.append(results);
		builder.append("]");
		return builder.toString();
	}

}
