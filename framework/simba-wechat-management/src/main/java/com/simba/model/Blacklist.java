package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 黑名单
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "黑名单")
public class Blacklist {

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 粉丝ID
	 */
	private int fansId;

	/**
	 * 拉黑时间
	 */
	@DescAnnotation(desc = "拉黑时间")
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFansId() {
		return fansId;
	}

	public void setFansId(int fansId) {
		this.fansId = fansId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Blacklist [id=");
		builder.append(id);
		builder.append(", fansId=");
		builder.append(fansId);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
