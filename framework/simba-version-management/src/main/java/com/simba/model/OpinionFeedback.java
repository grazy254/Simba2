package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 意见反馈
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "意见反馈管理")
public class OpinionFeedback {

	/**
	 * 意见id
	 */
	private int id;
	
	/**
	 * userId
	 */
	@DescAnnotation(desc = "反馈意见的用户id")
	private int userId;
	
	/**
	 * 意见名称
	 */
	@DescAnnotation(desc = "意见名称")
	private String title;


	/**
	 * 意见内容
	 */
	@DescAnnotation(desc = "意见内容")
	private String text;
	

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	public String toString() {
		return "OpinionFeedback [id=" + id + ", userId=" + userId + ", title=" + title + ", text=" + text + ", createTime=" + createTime + "]";
	}
}	
