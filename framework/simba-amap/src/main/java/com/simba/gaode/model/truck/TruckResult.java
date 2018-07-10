package com.simba.gaode.model.truck;

/**
 * 货车路径规划返回对象
 * 
 * @author caozhejun
 *
 */
public class TruckResult {

	/**
	 * 返回结果码 0，表示成功
	 */
	private int errcode;

	/**
	 * 具体错误原因 此字段会详细说明错误原因
	 */
	private String errdetail;

	/**
	 * 返回状态说明 OK代表成功
	 */
	private String errmsg;

	private TruckData data;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
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

	public TruckData getData() {
		return data;
	}

	public void setData(TruckData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckResult [errcode=");
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
