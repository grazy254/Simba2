package com.simba.gaode.model.fence;

/**
 * 创建围栏响应结果
 * 
 * @author caozhejun
 *
 */
public class FenceResult {

	/**
	 * 返回数据内容消息体
	 */
	private FenceData data;

	/**
	 * 错误码
	 */
	private String errcode;

	/**
	 * 错误描述信息
	 */
	private String errmsg;

	public FenceData getData() {
		return data;
	}

	public void setData(FenceData data) {
		this.data = data;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateFenceResult [data=");
		builder.append(data);
		builder.append(", errcode=");
		builder.append(errcode);
		builder.append(", errmsg=");
		builder.append(errmsg);
		builder.append("]");
		return builder.toString();
	}

}
