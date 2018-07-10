package com.simba.gaode.model.bus;

/**
 * 聚合的备选方案
 * 
 * @author caozhejun
 *
 */
public class Alter {

	/**
	 * 备选方案ID
	 */
	private String id;

	/**
	 * 备选线路名称
	 */
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alter [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
