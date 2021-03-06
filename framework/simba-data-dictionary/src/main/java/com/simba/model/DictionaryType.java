package com.simba.model;
/***********************************************************************
 * Module:  DictionaryType.java
 * Author:  caozhejun
 * Purpose: Defines the Class DictionaryType
 ***********************************************************************/

import java.io.Serializable;

import com.simba.annotation.DescAnnotation;

/**
 * 字典类型
 */
@DescAnnotation(desc = "字典类型")
public class DictionaryType implements Serializable {

	private static final long serialVersionUID = -1302788062725245636L;

	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 编码
	 */
	@DescAnnotation(desc = "编码")
	private String code;

	/**
	 * 描述
	 */
	@DescAnnotation(desc = "描述")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DictionaryType{" + "id=" + id + ", code='" + code + '\'' + ", description='" + description + '\'' + '}';
	}

}