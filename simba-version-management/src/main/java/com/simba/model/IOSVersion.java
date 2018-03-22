package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * IOS安装包版本管理
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "IOS安装包版本管理")
public class IOSVersion {

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 版本号
	 */
	@DescAnnotation(desc = "版本号")
	private String version;

	/**
	 * 文件大小
	 */
	@DescAnnotation(desc = "文件大小")
	private double fileSize;

	/**
	 * 文件描述
	 */
	@DescAnnotation(desc = "文件描述")
	private String description;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * ISO版本Identifer属性
	 */
	@DescAnnotation(desc = "ISO版本Identifer属性")
	private String identifer;

	/**
	 * 标题
	 */
	@DescAnnotation(desc = "标题")
	private String title;

	/**
	 * IPA文件地址
	 */
	@DescAnnotation(desc = "IPA文件地址")
	private String ipaFileUrl;

	/**
	 * 大图片文件地址
	 */
	@DescAnnotation(desc = "大图片文件地址")
	private String fullImageFileUrl;

	/**
	 * logo文件地址
	 */
	@DescAnnotation(desc = "logo文件地址")
	private String logFileUrl;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIdentifer() {
		return identifer;
	}

	public void setIdentifer(String identifer) {
		this.identifer = identifer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIpaFileUrl() {
		return ipaFileUrl;
	}

	public void setIpaFileUrl(String ipaFileUrl) {
		this.ipaFileUrl = ipaFileUrl;
	}

	public String getFullImageFileUrl() {
		return fullImageFileUrl;
	}

	public void setFullImageFileUrl(String fullImageFileUrl) {
		this.fullImageFileUrl = fullImageFileUrl;
	}

	public String getLogFileUrl() {
		return logFileUrl;
	}

	public void setLogFileUrl(String logFileUrl) {
		this.logFileUrl = logFileUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VersionIOS [id=");
		builder.append(id);
		builder.append(", version=");
		builder.append(version);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", identifer=");
		builder.append(identifer);
		builder.append(", title=");
		builder.append(title);
		builder.append(", ipaFileUrl=");
		builder.append(ipaFileUrl);
		builder.append(", fullImageFileUrl=");
		builder.append(fullImageFileUrl);
		builder.append(", logFileUrl=");
		builder.append(logFileUrl);
		builder.append("]");
		return builder.toString();
	}

}
