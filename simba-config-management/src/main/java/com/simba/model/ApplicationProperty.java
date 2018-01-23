package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 应用配置表
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "应用配置表")
public class ApplicationProperty {

	/**
	 * 自增主键ID
	 */
	private long id;
	
	/**
	 * 应用名
	 */
	@DescAnnotation(desc = "应用名")
	private String name;
	/**
	 * 模板id
	 */
	@DescAnnotation(desc = "模板")
	private  int templateId;
	/**
	 * 开发版配置
	 */
	@DescAnnotation(desc = "开发版配置")
	private String dev;
	
	/**
	 * 生产环境配置
	 */
	@DescAnnotation(desc = "生产环境配置")
	private String prod;
	
	/**
	 * test配置
	 */
	@DescAnnotation(desc = "测试版配置")
	private String test;
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
	public int getTemplateId() {
		return templateId;
	}
	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}
	public String getDev() {
		return dev;
	}
	public void setDev(String dev) {
		this.dev = dev;
	}
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Config [id=" + id + ", name=" + name + ", templateId=" + templateId + ", dev=" + dev + ", prod=" + prod + ", test=" + test + ", createTime=" + createTime + "]";
	}

	
}
