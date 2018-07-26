package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 消息记录
 */
@DescAnnotation(desc = "消息记录")
public class PushMessage {
    /**
     * --
     */
    @DescAnnotation(desc = "--")
    private long id;

    /**
     * 接收方Id
     */
    @DescAnnotation(desc = "接收方Id")
    private long toUserId;

    /**
     * 发送方Id
     */
    @DescAnnotation(desc = "发送方Id")
    private long fromUserId;

    /**
     * 推送类型
     */
    @DescAnnotation(desc = "推送类型")
    private String pushType;

    /**
     * 内容
     */
    @DescAnnotation(desc = "内容")
    private String content;

    /**
     * 创建时间
     */
    @DescAnnotation(desc = "创建时间")
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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

    @Override
    public String toString() {
        return "PushMessage{" +
		"id=" + id +
		", toUserId=" + toUserId + 
		", fromUserId=" + fromUserId + 
		", pushType='" + pushType + '\'' + 
		", content='" + content + '\'' + 
		", createTime=" + createTime + 
		'}';
    }

}