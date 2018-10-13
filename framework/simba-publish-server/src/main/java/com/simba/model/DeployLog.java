package com.simba.model;
/***********************************************************************
 * Module:  DeployLog.java
 * Author:  caozhejun
 * Purpose: Defines the Class DeployLog
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 部署日志
 */
@DescAnnotation(desc = "部署日志")
public class DeployLog {

	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 项目id
	 * 
	 */
	@DescAnnotation(desc = "项目id")
	private int projectId;

	/**
	 * 项目名称
	 * 
	 */
	@DescAnnotation(desc = "项目名称")
	private String name;

	/**
	 * 时间
	 * 
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DeployLog{" + "id=" + id + ", projectId=" + projectId + ", name='" + name + '\'' + ", createTime=" + createTime + '}';
	}

}