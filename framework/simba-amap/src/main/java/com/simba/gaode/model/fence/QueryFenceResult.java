package com.simba.gaode.model.fence;

/**
 * 查询围栏响应对象
 * 
 * @author caozhejun
 *
 */
public class QueryFenceResult {

	/**
	 * 返回内容消息体
	 */
	private QueryFenceData data;

	/**
	 * 错误码
	 */
	private String errcode;

	/**
	 * 错误信息
	 */
	private String errmsg;

	public QueryFenceData getData() {
		return data;
	}

	public void setData(QueryFenceData data) {
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
		builder.append("QueryFenceResult [data=");
		builder.append(data);
		builder.append(", errcode=");
		builder.append(errcode);
		builder.append(", errmsg=");
		builder.append(errmsg);
		builder.append("]");
		return builder.toString();
	}

}
