package com.simba.model;
/***********************************************************************
 * Module:  ProjectServerRel.java
 * Author:  caozhejun
 * Purpose: Defines the Class ProjectServerRel
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

/**
 * 项目绑定部署的服务器
 */
@DescAnnotation(desc = "项目绑定部署的服务器")
public class ProjectServerRel {

	/** */
	@DescAnnotation(desc = "")
	private int id;

	/**
	 * 项目id
	 */
	@DescAnnotation(desc = "项目id")
	private int projectId;

	/**
	 * 服务器id
	 */
	@DescAnnotation(desc = "服务器id")
	private int serverId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	@Override
	public String toString() {
		return "ProjectServerRel{" + "id=" + id + ", projectId=" + projectId + ", serverId=" + serverId + '}';
	}

}