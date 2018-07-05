package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 上传图片
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "上传图片")
public class UploadImage {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * 原文件地址
	 */
	@DescAnnotation(desc = "原文件地址")
	private String sourceUrl;

	/**
	 * 微信端地址
	 */
	@DescAnnotation(desc = "微信端地址")
	private String wxUrl;

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

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getWxUrl() {
		return wxUrl;
	}

	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadImage [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sourceUrl=");
		builder.append(sourceUrl);
		builder.append(", wxUrl=");
		builder.append(wxUrl);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
