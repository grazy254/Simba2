package com.simba.model;

import com.simba.annotation.DescAnnotation;

import java.util.Date;
/**
 *
 * 用户分组
 * @author lilei
 *
 */
@DescAnnotation(desc = "用户分组")
public class UserGroup  {

    private long id;

    /**
    * 分组名称
    *
    */
    @DescAnnotation(desc = "分组名称") 
    private String name;

    /**
    * 分组描述
    *
    */
    @DescAnnotation(desc = "分组描述") 
    private String description;

    /**
    * 分组状态
    *
    */
    @DescAnnotation(desc = "分组状态") 
    private int status;

    /**
    * 分组类型
    *
    */
    @DescAnnotation(desc = "分组类型") 
    private int type;

    /**
    * 分组创建者Id
    *
    */
    @DescAnnotation(desc = "分组创建者") 
    private String creater;

    private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", type=" + type + ", creater=" + creater + ", createTime=" + createTime + "]";
	}

    
}
