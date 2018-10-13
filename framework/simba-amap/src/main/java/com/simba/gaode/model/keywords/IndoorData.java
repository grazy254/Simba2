package com.simba.gaode.model.keywords;

/**
 * 室内地图相关数据
 * 
 * @author caozhejun
 *
 */
public class IndoorData {

	/**
	 * 当前POI的父级POI 如果当前POI为建筑物类POI，则cpid为自身POI ID；如果当前POI为商铺类POI，则cpid为其所在建筑物的POI ID
	 */
	private String cpid;

	/**
	 * 楼层索引 一般会用数字表示，例如8
	 */
	private String floor;

	/**
	 * 所在楼层 一般会带有字母，例如F8
	 */
	private String truefloor;

	public String getCpid() {
		return cpid;
	}

	public void setCpid(String cpid) {
		this.cpid = cpid;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getTruefloor() {
		return truefloor;
	}

	public void setTruefloor(String truefloor) {
		this.truefloor = truefloor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndoorData [cpid=");
		builder.append(cpid);
		builder.append(", floor=");
		builder.append(floor);
		builder.append(", truefloor=");
		builder.append(truefloor);
		builder.append("]");
		return builder.toString();
	}

}
