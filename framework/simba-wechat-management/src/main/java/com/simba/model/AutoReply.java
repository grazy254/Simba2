package com.simba.model;

import java.io.Serializable;

import com.simba.annotation.DescAnnotation;

/**
 * 自动回复设置
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "自动回复设置")
public class AutoReply implements Serializable {

	private static final long serialVersionUID = -3609112748152852327L;

	/**
	 * 主键自增ID
	 */
	private int id;

	/**
	 * 类型(对应AutoReplyType)
	 */
	@DescAnnotation(desc = "类型")
	private int type;

	/**
	 * 回复内容
	 */
	@DescAnnotation(desc = "回复内容")
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AutoReply [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

}
