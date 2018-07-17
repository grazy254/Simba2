package com.simba.model;
/***********************************************************************
 * Module:  Dictionary.java
 * Author:  caozhejun
 * Purpose: Defines the Class Dictionary
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;


/**
 * 字典
 * */
@DescAnnotation(desc = "字典")
public class Dictionary {
   /** */
   @DescAnnotation(desc = "")
	private long id;

   /**
    * 类型id
    * */
   @DescAnnotation(desc = "类型id")
	private long typeId;

   /**
    * 名称
    * */
   @DescAnnotation(desc = "名称")
	private String name;

   /**
    * 值
    * */
   @DescAnnotation(desc = "值")
	private String value;


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

    @Override
    public String toString() {
        return "Dictionary{" +
		"id=" + id +
		", typeId=" + typeId + 
		", name='" + name + '\'' + 
		", value='" + value + '\'' + 
		'}';
    }

}