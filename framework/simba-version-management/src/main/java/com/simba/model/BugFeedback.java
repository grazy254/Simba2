package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * bug反馈
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "bug反馈管理")
public class BugFeedback {

	/**
	 * bugid
	 */
	private int id;
	
	/**
	 * userId
	 */
	@DescAnnotation(desc = "反馈bug的用户id")
	private int userId;
	
	/**
	 * bug名称
	 */
	@DescAnnotation(desc = "bug名称")
	private String title;


	/**
	 * bug内容
	 */
	@DescAnnotation(desc = "bug内容")
	private String text;
	

	/**
	 * bug截图
	 */
	@DescAnnotation(desc = "bug截图")
	private String img;
	
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "BugFeedback [id=" + id + ", userId=" + userId + ", title=" + title + ", text=" + text + ", img=" + img + ", createTime=" + createTime + "]";
	}

}	