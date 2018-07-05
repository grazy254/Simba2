package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 文件版本
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "文件版本管理")
public class FileVersion {

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
	 * 类型ID
	 */
	@DescAnnotation(desc = "类型ID")
	private int typeId;

	/**
	 * 文件大小
	 */
	@DescAnnotation(desc = "文件大小")
	private double fileSize;
	/**
	 * 文件路径
	 */
	@DescAnnotation(desc = "文件路径")
	private String fileUrl;
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
	 * 扩展属性
	 */
	@DescAnnotation(desc = "扩展属性")
	private String extProps;

	/////////////// 扩展///////////////////
	/**
	 * 类型名称
	 */
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	////////////////////////////////////

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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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

	public String getExtProps() {
		return extProps;
	}

	public void setExtProps(String extProps) {
		this.extProps = extProps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileVersion [id=");
		builder.append(id);
		builder.append(", version=");
		builder.append(version);
		builder.append(", typeId=");
		builder.append(typeId);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", extProps=");
		builder.append(extProps);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
