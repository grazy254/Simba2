package com.simba.model;

import com.simba.annotation.DescAnnotation;

import java.util.Date;
/**
 *
 * null
 * @author lilei
 *
 */
@DescAnnotation(desc = "null")
public class Activity  {

    private long id;

    private String activityID;

    private String name;

    private String description;

    private String ownerID;

    private int point;

    private Date startTime;

    private Date endTime;

    private Date createTime;

    private Date updateTime;
    
    //暂时转化用
    private String start;

    private String end;

    
    public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivityID() {
        return activityID;
    }

    public void setActivityID(String activityID) {
        this.activityID = activityID;
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

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityID=" + activityID + ", name=" + name + ", description=" + description + ", ownerID=" + ownerID + ", point=" + point + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + ", updateTime=" + updateTime + ", start=" + start + ", end=" + end + "]";
	}

   
}
