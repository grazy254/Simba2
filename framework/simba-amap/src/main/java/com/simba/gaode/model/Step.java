package com.simba.gaode.model;

/**
 * 每段方案
 * 
 * @author caozhejun
 *
 */
public class Step {

	/**
	 * 路段指示
	 */
	private String instruction;

	/**
	 * 道路名称
	 */
	private String road;

	/**
	 * 此路段距离
	 * 
	 * 单位：米
	 */
	private String distance;

	/**
	 * 方向
	 */
	private String orientation;

	/**
	 * 此路段预计时间
	 */
	private String duration;

	/**
	 * 此路段坐标点
	 */
	private String polyline;

	/**
	 * 主要动作
	 */
	private String action;

	/**
	 * 步行辅助动作
	 */
	private String assistant_action;

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPolyline() {
		return polyline;
	}

	public void setPolyline(String polyline) {
		this.polyline = polyline;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAssistant_action() {
		return assistant_action;
	}

	public void setAssistant_action(String assistant_action) {
		this.assistant_action = assistant_action;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Step [instruction=");
		builder.append(instruction);
		builder.append(", road=");
		builder.append(road);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", orientation=");
		builder.append(orientation);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", polyline=");
		builder.append(polyline);
		builder.append(", action=");
		builder.append(action);
		builder.append(", assistant_action=");
		builder.append(assistant_action);
		builder.append("]");
		return builder.toString();
	}

}
