package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 上传视频
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "上传视频")
public class UploadVideo {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 标题
	 */
	@DescAnnotation(desc = "标题")
	private String title;

	/**
	 * 描述
	 */
	@DescAnnotation(desc = "描述")
	private String description;

	/**
	 * 素材ID
	 */
	@DescAnnotation(desc = "素材ID")
	private String mediaId;

	/**
	 * 目标素材ID
	 */
	@DescAnnotation(desc = "目标素材ID")
	private String targetMediaId;

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

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getTargetMediaId() {
		return targetMediaId;
	}

	public void setTargetMediaId(String targetMediaId) {
		this.targetMediaId = targetMediaId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UploadVideo [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", targetMediaId=");
		builder.append(targetMediaId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
