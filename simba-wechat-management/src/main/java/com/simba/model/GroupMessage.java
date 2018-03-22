package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 群发消息
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "群发消息")
public class GroupMessage {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 群发的消息类型，图文消息为mpnews，文本消息为text，语音为voice，图片为image，视频为video，卡券为wxcard
	 */
	@DescAnnotation(desc = "消息类型")
	private String type;

	/**
	 * 发送者账号
	 */
	@DescAnnotation(desc = "发送者账号 ")
	private String account;

	/**
	 * 发送内容
	 */
	@DescAnnotation(desc = "发送内容 ")
	private String content;

	/**
	 * 素材ID
	 */
	@DescAnnotation(desc = "素材ID")
	private String mediaId;

	/**
	 * 群发到的标签的tag_id，参加用户管理中用户分组接口，若is_to_all值为true，可不填写tag_id
	 */
	@DescAnnotation(desc = "微信标签ID")
	private Integer wxTagId;

	/**
	 * 用于设定是否向全部用户发送，值为true或false，选择true该消息群发给所有用户，选择false可根据tag_id发送给指定群组的用户
	 */
	@DescAnnotation(desc = "是否全发")
	private Integer isAll;

	/**
	 * 微信用户ID列表
	 */
	@DescAnnotation(desc = "微信用户ID列表")
	private String openids;

	/**
	 * 发送状态，对应SendStatus
	 */
	@DescAnnotation(desc = "状态")
	private int status;

	/**
	 * 任务ID
	 */
	@DescAnnotation(desc = "任务ID")
	private String msgId;

	/**
	 * 数据ID
	 */
	@DescAnnotation(desc = "数据ID")
	private String msgDataId;

	/**
	 * 完整Json内容
	 */
	@DescAnnotation(desc = "完整Json内容")
	private String json;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Integer getWxTagId() {
		return wxTagId;
	}

	public void setWxTagId(Integer wxTagId) {
		this.wxTagId = wxTagId;
	}

	public Integer getIsAll() {
		return isAll;
	}

	public void setIsAll(Integer isAll) {
		this.isAll = isAll;
	}

	public String getOpenids() {
		return openids;
	}

	public void setOpenids(String openids) {
		this.openids = openids;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgDataId() {
		return msgDataId;
	}

	public void setMsgDataId(String msgDataId) {
		this.msgDataId = msgDataId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GroupMessage [id=");
		builder.append(id);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", account=");
		builder.append(account);
		builder.append(", content=");
		builder.append(content);
		builder.append(", mediaId=");
		builder.append(mediaId);
		builder.append(", wxTagId=");
		builder.append(wxTagId);
		builder.append(", isAll=");
		builder.append(isAll);
		builder.append(", openids=");
		builder.append(openids);
		builder.append(", status=");
		builder.append(status);
		builder.append(", msgId=");
		builder.append(msgId);
		builder.append(", msgDataId=");
		builder.append(msgDataId);
		builder.append(", json=");
		builder.append(json);
		builder.append("]");
		return builder.toString();
	}

}
