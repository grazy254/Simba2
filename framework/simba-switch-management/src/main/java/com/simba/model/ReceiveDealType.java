package com.simba.model;

import java.io.Serializable;

import com.simba.annotation.DescAnnotation;

/**
 * 处理接收消息类型
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "处理接收消息类型")
public class ReceiveDealType implements Serializable {

	private static final long serialVersionUID = 7484039243098215067L;

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * Bean ID
	 */
	@DescAnnotation(desc = "Bean ID")
	private String beanId;

	/**
	 * 同步
	 */
	@DescAnnotation(desc = "同步")
	private int sync;

	/**
	 * 描述
	 */
	@DescAnnotation(desc = "描述")
	private String description;

	/**
	 * 扩展属性
	 */
	@DescAnnotation(desc = "扩展属性")
	private String ext;

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

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public int getSync() {
		return sync;
	}

	public void setSync(int sync) {
		this.sync = sync;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveDealType [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", beanId=");
		builder.append(beanId);
		builder.append(", sync=");
		builder.append(sync);
		builder.append(", description=");
		builder.append(description);
		builder.append(", ext=");
		builder.append(ext);
		builder.append("]");
		return builder.toString();
	}

}
