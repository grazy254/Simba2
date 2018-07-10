package com.simba.gaode.model.distance;

/**
 * 距离信息
 * 
 * @author caozhejun
 *
 */
public class Result {

	/**
	 * 起点坐标，起点坐标序列号（从１开始）
	 */
	private String origin_id;

	/**
	 * 终点坐标，终点坐标序列号（从１开始）
	 */
	private String dest_id;

	/**
	 * 路径距离，单位：米
	 */
	private String distance;

	/**
	 * 预计行驶时间，单位：秒
	 */
	private String duration;

	/**
	 * 仅在出错的时候显示该字段。大部分显示“未知错误” 由于此接口支持批量请求，建议不论批量与否用此字段判断请求是否成功
	 */
	private String info;

	/**
	 * 仅在出错的时候显示此字段。 在驾车模式下： 1，指定地点之间没有可以行车的道路 2，起点/终点 距离所有道路均距离过远（例如在海洋/矿业）
	 * 3，起点/终点不在中国境内
	 */
	private String code;

	public String getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}

	public String getDest_id() {
		return dest_id;
	}

	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [origin_id=");
		builder.append(origin_id);
		builder.append(", dest_id=");
		builder.append(dest_id);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", info=");
		builder.append(info);
		builder.append(", code=");
		builder.append(code);
		builder.append("]");
		return builder.toString();
	}

}
