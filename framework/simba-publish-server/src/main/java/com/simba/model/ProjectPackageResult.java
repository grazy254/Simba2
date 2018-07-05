package com.simba.model;
/***********************************************************************
 * Module:  ProjectPackage.java
 * Author:  caozhejun
 * Purpose: Defines the Class ProjectPackage
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

/**
 * 项目打包结果
 */
@DescAnnotation(desc = "项目打包结果")
public class ProjectPackageResult {

	/** */
	@DescAnnotation(desc = "")
	private int id;

	/**
	 * 项目id
	 */
	@DescAnnotation(desc = "项目id")
	private int projectId;

	/**
	 * 打包结果文件路径
	 * 
	 */
	@DescAnnotation(desc = "打包结果文件路径")
	private String filePath;

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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectPackage [id=");
		builder.append(id);
		builder.append(", projectId=");
		builder.append(projectId);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append("]");
		return builder.toString();
	}

}