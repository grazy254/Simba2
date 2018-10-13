package com.simba.model;

import com.simba.annotation.DescAnnotation;

/**
 * bug反馈
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "常见问题类型管理")
public class FAQType {

	/**
	 * id
	 */
	@DescAnnotation(desc = "类型id")
	private int id;

	/**
	 * 类型名称
	 */
	@DescAnnotation(desc = "类型名称")
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FAQType [id=" + id + ", type=" + type + "]";
	}

}