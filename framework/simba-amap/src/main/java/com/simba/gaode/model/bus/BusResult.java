package com.simba.gaode.model.bus;

/**
 * 公交路线规划结果
 * 
 * @author caozhejun
 *
 */
public class BusResult {

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

	/**
	 * 返回结果总数目
	 */
	private String count;

	private String infocode;

	/**
	 * 公交换乘信息列表
	 */
	private BusRoute route;

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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getInfocode() {
		return infocode;
	}

	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}

	public BusRoute getRoute() {
		return route;
	}

	public void setRoute(BusRoute route) {
		this.route = route;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusResult [status=");
		builder.append(status);
		builder.append(", info=");
		builder.append(info);
		builder.append(", count=");
		builder.append(count);
		builder.append(", infocode=");
		builder.append(infocode);
		builder.append(", route=");
		builder.append(route);
		builder.append("]");
		return builder.toString();
	}

}
