package com.simba.model;
/***********************************************************************
 * Module:  Dictionary.java
 * Author:  caozhejun
 * Purpose: Defines the Class Dictionary
 ***********************************************************************/

import java.io.Serializable;

import com.simba.annotation.DescAnnotation;

/**
 * 字典
 */
@DescAnnotation(desc = "字典")
public class Dictionary implements Serializable {

	private static final long serialVersionUID = 170419117261144674L;

	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 类型id
	 */
	@DescAnnotation(desc = "类型id")
	private long typeId;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * 值
	 */
	@DescAnnotation(desc = "值")
	private String value;

	/**
	 * 排序
	 */
	private int orderNo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dictionary [id=");
		builder.append(id);
		builder.append(", typeId=");
		builder.append(typeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", value=");
		builder.append(value);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append("]");
		return builder.toString();
	}

}