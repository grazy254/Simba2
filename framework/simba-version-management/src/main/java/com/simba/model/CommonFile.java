package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 通用文件
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "通用文件")
public class CommonFile {

	/**
	 * 自增id
	 */
	private int id;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * 类型
	 */
	@DescAnnotation(desc = "类型")
	private int typeId;

	/**
	 * 文件地址
	 */
	@DescAnnotation(desc = "文件地址")
	private String fileUrl;

	/**
	 * 文件大小
	 */
	@DescAnnotation(desc = "文件大小")
	private double fileSize;

	/**
	 * 描述
	 */
	@DescAnnotation(desc = "描述")
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

	/////// 扩展属性，用于页面显示//////
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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

	public String getExtProps() {
		return extProps;
	}

	public void setExtProps(String extProps) {
		this.extProps = extProps;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonFile [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", typeId=");
		builder.append(typeId);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", extProps=");
		builder.append(extProps);
		builder.append("]");
		return builder.toString();
	}

}
