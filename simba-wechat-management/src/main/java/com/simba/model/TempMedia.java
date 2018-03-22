package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 临时素材
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "临时素材")
public class TempMedia {

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
	 * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 */
	@DescAnnotation(desc = "类型")
	private String type;

	/**
	 * 文件地址
	 */
	@DescAnnotation(desc = "文件地址")
	private String fileUrl;

	/**
	 * 媒体文件上传后，获取标识
	 */
	@DescAnnotation(desc = "素材ID")
	private String mediaId;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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
		builder.append("TempMedia [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
