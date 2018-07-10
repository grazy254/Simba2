package com.simba.gaode.model;

/**
 * 仓位及价格信息
 * 
 * @author caozhejun
 *
 */
public class Space {

	/**
	 * 仓位编码
	 */
	private String code;

	/**
	 * 仓位费用
	 */
	private String cost;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Space [code=");
		builder.append(code);
		builder.append(", cost=");
		builder.append(cost);
		builder.append("]");
		return builder.toString();
	}

}
