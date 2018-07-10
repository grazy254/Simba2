package com.simba.gaode.model.truck;

/**
 * 途径地
 * 
 * @author caozhejun
 *
 */
public class District {

	/**
	 * 途径地名字
	 */
	private String name;

	/**
	 * 途径地adcode
	 */
	private String adcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("District [name=");
		builder.append(name);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append("]");
		return builder.toString();
	}

}
