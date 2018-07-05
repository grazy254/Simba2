package com.simba.model;

import com.simba.annotation.DescAnnotation;

@DescAnnotation(desc = "自增id")
public class AutoId {

	@DescAnnotation(desc = "Key")
	private String id;

	@DescAnnotation(desc = "数值")
	private long num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoId [id=");
		builder.append(id);
		builder.append(", num=");
		builder.append(num);
		builder.append("]");
		return builder.toString();
	}

}
