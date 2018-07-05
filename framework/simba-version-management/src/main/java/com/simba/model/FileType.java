package com.simba.model;


import com.simba.annotation.DescAnnotation;

/**
 * 版本管理文件类型
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "文件类型")
public class FileType {

	/**
	 * 自增主键ID
	 */
	private int id;


	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VersionList [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	

	
}
