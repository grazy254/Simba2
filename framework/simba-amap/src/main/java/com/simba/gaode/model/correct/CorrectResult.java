package com.simba.gaode.model.correct;

/**
 * 轨迹纠偏响应对象
 * 
 * @author caozhejun
 *
 */
public class CorrectResult {

	private String errcode;

	private String errdetail;

	private String errmsg;

	private CorrectResultData data;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrdetail() {
		return errdetail;
	}

	public void setErrdetail(String errdetail) {
		this.errdetail = errdetail;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public CorrectResultData getData() {
		return data;
	}

	public void setData(CorrectResultData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CorrectResult [errcode=");
		builder.append(errcode);
		builder.append(", errdetail=");
		builder.append(errdetail);
		builder.append(", errmsg=");
		builder.append(errmsg);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
