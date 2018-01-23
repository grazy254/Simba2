package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 项目版本
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "项目版本")
public class ProjectVersion {

	private int id;

	/**
	 * 版本号
	 */
	@DescAnnotation(desc = "版本号")
	private String versionNo;

	/**
	 * 文件地址
	 */
	@DescAnnotation(desc = "文件地址")
	private String filePath;

	/**
	 * 发布时间
	 */
	@DescAnnotation(desc = "发布时间")
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectVersion [id=");
		builder.append(id);
		builder.append(", versionNo=");
		builder.append(versionNo);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
