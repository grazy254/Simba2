package com.simba.gaode.model.fence;

/**
 * 围栏事件
 * 
 * @author caozhejun
 *
 */
public class FenceEvent {

	/**
	 * 设备行为。对应3种与围栏的动态交互关系，进/出/停留： enter|leave|stay
	 */
	private String client_action;

	/**
	 * 设备状态。当前与围栏的静态关系状态。是否在围栏里： in|out
	 */
	private String client_status;

	/**
	 * 用户进入围栏时间。格式： yyyy-MM-dd HH:mm:ss
	 */
	private String enter_time;

	/**
	 * 围栏信息
	 */
	private FenceInfo fence_info;

	public String getClient_action() {
		return client_action;
	}

	public void setClient_action(String client_action) {
		this.client_action = client_action;
	}

	public String getClient_status() {
		return client_status;
	}

	public void setClient_status(String client_status) {
		this.client_status = client_status;
	}

	public String getEnter_time() {
		return enter_time;
	}

	public void setEnter_time(String enter_time) {
		this.enter_time = enter_time;
	}

	public FenceInfo getFence_info() {
		return fence_info;
	}

	public void setFence_info(FenceInfo fence_info) {
		this.fence_info = fence_info;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FenceEvent [client_action=");
		builder.append(client_action);
		builder.append(", client_status=");
		builder.append(client_status);
		builder.append(", enter_time=");
		builder.append(enter_time);
		builder.append(", fence_info=");
		builder.append(fence_info);
		builder.append("]");
		return builder.toString();
	}

}
