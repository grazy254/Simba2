package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 配置模板表
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "配置模板表")
public class PropertyTemplate {

	/**
	 * 自增主键ID
	 */
	private long id;
	
	/**
	 * 模板名
	 */
	@DescAnnotation(desc = "模板名")
	private String name;
	
	/**
	 * 模板描述
	 */
	@DescAnnotation(desc = "模板描述")
	private String description;
	
	/**
	 * 模板
	 */
	@DescAnnotation(desc = "模板")
	private String template;
	
	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Template [id=" + id + ", name=" + name + ", description=" + description + ", template=" + template + ", createTime=" + createTime + "]";
	}

	

	

	
}
