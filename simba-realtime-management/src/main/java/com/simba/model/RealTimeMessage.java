package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 设备功能表
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "设备功能表")
public class RealTimeMessage {

	/**
	 * 自增主键ID
	 */
	private long id;
	
	/**
	 * 用户ID
	 */
	@DescAnnotation(desc = "接收方ID")
	private int userId;
	/**
	 * 消息
	 */
	@DescAnnotation(desc = "消息")
	private String message;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "RealTimeMessage [id=" + id + ", userId=" + userId + ", message=" + message + ", createTime=" + createTime + "]";
	}
	
	
	
	

}