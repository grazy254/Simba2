package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 常见问题
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "常见问题管理")
public class FAQ {

	/**
	 * 问题id
	 */
	private int id;

	/**
	 * 问题名称
	 */
	@DescAnnotation(desc = "问题名称")
	private String title;


	/**
	 * 问题内容
	 */
	@DescAnnotation(desc = "问题内容")
	private String text;
	

	/**
	 * 问题类型
	 */
	@DescAnnotation(desc = "问题类型")
	private int type;
	
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FAQ [id=" + id + ", title=" + title + ", text=" + text + ", type=" + type + ", createTime=" + createTime + "]";
	}
}
	
	
	