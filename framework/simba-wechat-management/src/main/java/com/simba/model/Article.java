package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 图文内容
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "图文内容")
public class Article {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 图文消息的标题
	 */
	@DescAnnotation(desc = "标题")
	private String title;

	/**
	 * 图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
	 */
	@DescAnnotation(desc = "缩略图的media_id")
	private String thumbMediaId;

	/**
	 * 图文消息的作者
	 */
	@DescAnnotation(desc = "作者")
	private String author;

	/**
	 * 图文消息的描述
	 */
	@DescAnnotation(desc = "描述")
	private String digest;

	/**
	 * 是否显示封面，1为显示，0为不显示
	 */
	@DescAnnotation(desc = "显示封面")
	private int showCoverPic;

	/**
	 * 图文消息页面的内容，支持HTML标签。具备微信支付权限的公众号，可以使用a标签，其他公众号不能使用，如需插入小程序卡片，可参考下文。
	 */
	@DescAnnotation(desc = "内容")
	private String content;

	/**
	 * 在图文消息页面点击“阅读原文”后的页面，受安全限制，如需跳转Appstore，可以使用itun.es或appsto.re的短链服务，并在短链后增加
	 * #wechat_redirect 后缀。
	 */
	@DescAnnotation(desc = "原文地址")
	private String contentSourceUrl;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 类型
	 */
	@DescAnnotation(desc = "类型")
	private int type;

	/////////////// 扩展属性///////////////////
	/**
	 * 图片地址
	 */
	private String imageUrl;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getShowCoverPic() {
		return showCoverPic;
	}

	public void setShowCoverPic(int showCoverPic) {
		this.showCoverPic = showCoverPic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentSourceUrl() {
		return contentSourceUrl;
	}

	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", thumbMediaId=");
		builder.append(thumbMediaId);
		builder.append(", author=");
		builder.append(author);
		builder.append(", digest=");
		builder.append(digest);
		builder.append(", showCoverPic=");
		builder.append(showCoverPic);
		builder.append(", content=");
		builder.append(content);
		builder.append(", contentSourceUrl=");
		builder.append(contentSourceUrl);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append("]");
		return builder.toString();
	}

}
