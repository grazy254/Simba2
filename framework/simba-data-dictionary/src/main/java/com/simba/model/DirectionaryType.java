package com.simba.model;
/***********************************************************************
 * Module:  DirectionaryType.java
 * Author:  caozhejun
 * Purpose: Defines the Class DirectionaryType
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;


/**
 * 字典类型
 * */
@DescAnnotation(desc = "字典类型")
public class DirectionaryType {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 编码
    * */
   @DescAnnotation(desc = "编码")
	private String code;

   /**
    * 描述
    * */
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
        return "DirectionaryType{" +
		"id=" + id +
		", code='" + code + '\'' + 
		", description='" + description + '\'' + 
		'}';
    }

}