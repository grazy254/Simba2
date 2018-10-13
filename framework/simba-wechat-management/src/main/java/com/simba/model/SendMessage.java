package com.simba.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 发消息
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "发消息")
public class SendMessage {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 微信用户ID
	 */
	@DescAnnotation(desc = "微信用户ID")
	private String openid = StringUtils.EMPTY;

	/**
	 * 文本消息内容
	 */
	@DescAnnotation(desc = "文本消息内容")
	private String content = StringUtils.EMPTY;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
	 */
	@DescAnnotation(desc = "媒体ID")
	private String mediaId = StringUtils.EMPTY;

	/**
	 * 消息类型，文本为text，图片为image，语音为voice，视频消息为video，音乐消息为music，图文消息（点击跳转到外链）为news，图文消息（点击跳转到图文消息页面）为mpnews，卡券为wxcard
	 */
	@DescAnnotation(desc = "消息类型")
	private String type = StringUtils.EMPTY;

	/**
	 * 缩略图的媒体ID
	 */
	@DescAnnotation(desc = "缩略图的媒体ID")
	private String thumbMediaId = StringUtils.EMPTY;

	/**
	 * 图文消息/视频消息/音乐消息的标题
	 */
	@DescAnnotation(desc = "标题")
	private String title = StringUtils.EMPTY;

	/**
	 * 图文消息/视频消息/音乐消息的描述
	 */
	@DescAnnotation(desc = "描述")
	private String descritption = StringUtils.EMPTY;

	/**
	 * 音乐链接
	 */
	@DescAnnotation(desc = "音乐链接")
	private String musicUrl = StringUtils.EMPTY;

	/**
	 * 高品质音乐链接，wifi环境优先使用该链接播放音乐
	 */
	@DescAnnotation(desc = "高品质音乐链接")
	private String hqMusicUrl = StringUtils.EMPTY;

	/**
	 * 图文消息（点击跳转到外链）
	 */
	@DescAnnotation(desc = "图文消息（点击跳转到外链） ")
	private String news = StringUtils.EMPTY;

	/**
	 * 完整的Json内容
	 */
	@DescAnnotation(desc = "完整的Json内容")
	private String json = StringUtils.EMPTY;

	/**
	 * 发送者账号
	 */
	private String account = StringUtils.EMPTY;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescritption() {
		return descritption;
	}

	public void setDescritption(String descritption) {
		this.descritption = descritption;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendMessage [id=");
		builder.append(id);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", content=");
		builder.append(content);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", type=");
		builder.append(type);
		builder.append(", thumbMediaId=");
		builder.append(thumbMediaId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", descritption=");
		builder.append(descritption);
		builder.append(", musicUrl=");
		builder.append(musicUrl);
		builder.append(", hqMusicUrl=");
		builder.append(hqMusicUrl);
		builder.append(", news=");
		builder.append(news);
		builder.append(", json=");
		builder.append(json);
		builder.append(", account=");
		builder.append(account);
		builder.append("]");
		return builder.toString();
	}

}
