package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 上传图文
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "上传图文")
public class UploadNews {

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
	 * 内容
	 */
	@DescAnnotation(desc = "内容")
	private String articles;

	/**
	 * 媒体文件/图文消息上传后获取的唯一标识
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

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
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
		builder.append("UploadNews [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", content=");
		builder.append(articles);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
