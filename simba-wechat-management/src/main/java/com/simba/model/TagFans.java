package com.simba.model;

/**
 * 标签和粉丝关系对象
 * 
 * @author caozhejun
 *
 */
public class TagFans {

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 标签ID
	 */
	private int tagId;

	/**
	 * 粉丝ID
	 */
	private int fansId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public int getFansId() {
		return fansId;
	}

	public void setFansId(int fansId) {
		this.fansId = fansId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TagFans [id=");
		builder.append(id);
		builder.append(", tagId=");
		builder.append(tagId);
		builder.append(", fansId=");
		builder.append(fansId);
		builder.append("]");
		return builder.toString();
	}

}
