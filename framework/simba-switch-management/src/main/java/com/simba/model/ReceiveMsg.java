package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 接收消息
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "接收消息")
public class ReceiveMsg {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 类型
	 */
	@DescAnnotation(desc = "类型")
	private String type;

	/**
	 * 源
	 */
	@DescAnnotation(desc = "源")
	private String source;

	/**
	 * 内容
	 */
	@DescAnnotation(desc = "内容")
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
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
		StringBuilder builder = new StringBuilder();
		builder.append("ReceiveMsg [id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", source=");
		builder.append(source);
		builder.append(", message=");
		builder.append(message);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}

}
