package com.simba.gaode.model.fence;

/**
 * 
 * 围栏信息
 * 
 * @author caozhejun
 *
 */
public class FenceInfo {

	/**
	 * 
	 * 全局围栏id
	 */
	private String fence_gid;

	/**
	 * 围栏名称
	 */
	private String fence_name;

	public String getFence_gid() {
		return fence_gid;
	}

	public void setFence_gid(String fence_gid) {
		this.fence_gid = fence_gid;
	}

	public String getFence_name() {
		return fence_name;
	}

	public void setFence_name(String fence_name) {
		this.fence_name = fence_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FenceInfo [fence_gid=");
		builder.append(fence_gid);
		builder.append(", fence_name=");
		builder.append(fence_name);
		builder.append("]");
		return builder.toString();
	}

}
