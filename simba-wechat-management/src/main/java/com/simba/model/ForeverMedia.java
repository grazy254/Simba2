package com.simba.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 永久素材
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "永久素材")
public class ForeverMedia {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 素材ID
	 */
	@DescAnnotation(desc = "素材ID")
	private String mediaId;

	/**
	 * 图文内容
	 */
	@DescAnnotation(desc = "图文内容")
	private String articles;

	/**
	 * 名称
	 */
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
	private String fileUrl = StringUtils.EMPTY;

	/**
	 * 视频素材的标题
	 */
	@DescAnnotation(desc = "标题")
	private String title;

	/**
	 * 视频素材的描述
	 */
	@DescAnnotation(desc = "描述")
	private String introduction;

	/**
	 * 新增的图片素材的图片URL
	 */
	@DescAnnotation(desc = "图片URL")
	private String imageUrl = StringUtils.EMPTY;

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

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
		builder.append("ForeverMedia [id=");
		builder.append(id);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", articles=");
		builder.append(articles);
		builder.append(", name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", title=");
		builder.append(title);
		builder.append(", introduction=");
		builder.append(introduction);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
