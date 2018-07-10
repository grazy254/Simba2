package com.simba.gaode.model.bus;

import java.util.List;

/**
 * 公交导航信息列表
 * 
 * @author caozhejun
 *
 */
public class BusSegment {

	/**
	 * 公交导航信息列表
	 */
	private List<BusLine> buslines;

	public List<BusLine> getBuslines() {
		return buslines;
	}

	public void setBuslines(List<BusLine> buslines) {
		this.buslines = buslines;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusSegment [buslines=");
		builder.append(buslines);
		builder.append("]");
		return builder.toString();
	}

}
