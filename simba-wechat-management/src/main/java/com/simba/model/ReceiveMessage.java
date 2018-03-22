package com.simba.model;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.simba.annotation.DescAnnotation;

/**
 * 收到消息
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "收到消息")
public class ReceiveMessage {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 用户微信ID
	 */
	@DescAnnotation(desc = "用户微信ID")
	private String openid = StringUtils.EMPTY;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 消息类型
	 */
	@DescAnnotation(desc = "类型")
	private String type = StringUtils.EMPTY;

	/**
	 * 消息id，64位整型
	 */
	@DescAnnotation(desc = "消息id")
	private String msgId = StringUtils.EMPTY;

	/**
	 * 文本消息内容
	 */
	@DescAnnotation(desc = "文本消息内容")
	private String content = StringUtils.EMPTY;

	/**
	 * 图片链接（由系统生成）
	 */
	@DescAnnotation(desc = "图片链接")
	private String picUrl = StringUtils.EMPTY;

	/**
	 * 消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@DescAnnotation(desc = "消息媒体id")
	private String mediaId = StringUtils.EMPTY;

	/**
	 * 媒体文件地址
	 */
	@DescAnnotation(desc = "媒体文件地址")
	private String fileUrl = StringUtils.EMPTY;

	/**
	 * 语音格式，如amr，speex等
	 */
	@DescAnnotation(desc = "语音格式")
	private String format = StringUtils.EMPTY;

	/**
	 * 语音识别结果，UTF8编码
	 */
	@DescAnnotation(desc = "语音识别结果")
	private String recognition = StringUtils.EMPTY;

	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	@DescAnnotation(desc = "视频消息缩略图的媒体id")
	private String thumbMediaId = StringUtils.EMPTY;

	/**
	 * 视频消息缩略图的媒体文件地址
	 */
	@DescAnnotation(desc = "视频消息缩略图的媒体文件地址")
	private String thumbFileUrl = StringUtils.EMPTY;

	/**
	 * 地理位置维度
	 */
	@DescAnnotation(desc = "地理位置维度")
	private String locationX = StringUtils.EMPTY;

	/**
	 * 地理位置经度
	 */
	@DescAnnotation(desc = "地理位置经度")
	private String locationY = StringUtils.EMPTY;

	/**
	 * 地图缩放大小
	 */
	@DescAnnotation(desc = "地图缩放大小")
	private String scale = StringUtils.EMPTY;

	/**
	 * 地理位置信息
	 */
	@DescAnnotation(desc = "地理位置信息")
	private String messageLabel = StringUtils.EMPTY;

	/**
	 * 消息标题
	 */
	@DescAnnotation(desc = "消息标题")
	private String title = StringUtils.EMPTY;

	/**
	 * 消息描述
	 */
	@DescAnnotation(desc = "消息描述")
	private String description = StringUtils.EMPTY;

	/**
	 * 消息链接
	 */
	@DescAnnotation(desc = "消息链接")
	private String url = StringUtils.EMPTY;

	/**
	 * 完整XML内容
	 */
	@DescAnnotation(desc = "完整XML内容")
	private String xml = StringUtils.EMPTY;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getThumbFileUrl() {
		return thumbFileUrl;
	}

	public void setThumbFileUrl(String thumbFileUrl) {
		this.thumbFileUrl = thumbFileUrl;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(String messageLabel) {
		this.messageLabel = messageLabel;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveMessage [id=");
		builder.append(id);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", msgId=");
		builder.append(msgId);
		builder.append(", content=");
		builder.append(content);
		builder.append(", picUrl=");
		builder.append(picUrl);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", fileUrl=");
		builder.append(fileUrl);
		builder.append(", format=");
		builder.append(format);
		builder.append(", recognition=");
		builder.append(recognition);
		builder.append(", thumbMediaId=");
		builder.append(thumbMediaId);
		builder.append(", thumbFileUrl=");
		builder.append(thumbFileUrl);
		builder.append(", locationX=");
		builder.append(locationX);
		builder.append(", locationY=");
		builder.append(locationY);
		builder.append(", scale=");
		builder.append(scale);
		builder.append(", messageLabel=");
		builder.append(messageLabel);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", url=");
		builder.append(url);
		builder.append(", xml=");
		builder.append(xml);
		builder.append("]");
		return builder.toString();
	}

}
