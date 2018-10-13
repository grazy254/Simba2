package com.simba.gaode.model.truck;

/**
 * 货车路径规划返回数据对象
 * 
 * @author caozhejun
 *
 */
public class TruckData {

	/**
	 * 总共返回路线数
	 */
	private String count;

	/**
	 * 里面包含距离路线信息
	 */
	private TruckRoute route;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public TruckRoute getRoute() {
		return route;
	}

	public void setRoute(TruckRoute route) {
		this.route = route;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckData [count=");
		builder.append(count);
		builder.append(", route=");
		builder.append(route);
		builder.append("]");
		return builder.toString();
	}
}
