package com.simba.model;

import com.simba.annotation.DescAnnotation;

/**
 * 标签
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "标签")
public class Tag {

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 标签名
	 */
	@DescAnnotation(desc = "标签名")
	private String name;

	/**
	 * 微信标签ID
	 */
	@DescAnnotation(desc = "微信标签ID")
	private int wxTagId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWxTagId() {
		return wxTagId;
	}

	public void setWxTagId(int wxTagId) {
		this.wxTagId = wxTagId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", wxTagId=");
		builder.append(wxTagId);
		builder.append("]");
		return builder.toString();
	}

}
