package com.simba.gaode.model.fence;

import java.util.List;

/**
 * 返回数据内容消息体
 * 
 * @author caozhejun
 *
 */
public class MonitorFenceData {

	/**
	 * 返回状态码
	 */
	private String status;

	/**
	 * 围栏距离设备的距离，没有命中围栏时返回。单位：米
	 */
	private String nearest_fence_distance;

	/**
	 * 最近的围栏id
	 */
	private String nearest_fence_gid;

	/**
	 * 围栏事件列表
	 */
	private List<FenceEvent> fencing_event_list;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNearest_fence_distance() {
		return nearest_fence_distance;
	}

	public void setNearest_fence_distance(String nearest_fence_distance) {
		this.nearest_fence_distance = nearest_fence_distance;
	}

	public String getNearest_fence_gid() {
		return nearest_fence_gid;
	}

	public void setNearest_fence_gid(String nearest_fence_gid) {
		this.nearest_fence_gid = nearest_fence_gid;
	}

	public List<FenceEvent> getFencing_event_list() {
		return fencing_event_list;
	}

	public void setFencing_event_list(List<FenceEvent> fencing_event_list) {
		this.fencing_event_list = fencing_event_list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MonitorFenceData [status=");
		builder.append(status);
		builder.append(", nearest_fence_distance=");
		builder.append(nearest_fence_distance);
		builder.append(", nearest_fence_gid=");
		builder.append(nearest_fence_gid);
		builder.append(", fencing_event_list=");
		builder.append(fencing_event_list);
		builder.append("]");
		return builder.toString();
	}

}
