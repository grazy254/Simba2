package com.simba.model;

import com.simba.annotation.DescAnnotation;


/**
 *
 * 活动
 * @author lilei
 *
 */
@DescAnnotation(desc = "活动")
public class Activity  {

    private long id;

    @DescAnnotation(desc = "活动id") 
    private String activityID;

    @DescAnnotation(desc = "活动名称") 
    private String name;

    @DescAnnotation(desc = "活动描述") 
    private String description;

    @DescAnnotation(desc = "活动发起人id") 
    private String ownerID;

    @DescAnnotation(desc = "积分") 
    private int point;

    @DescAnnotation(desc = "开始时间") 
    private String startTime;
    
    @DescAnnotation(desc = "结束时间") 
    private String endTime;

    @DescAnnotation(desc = "活动创建时间") 
    private String createTime;

    private String updateTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Activity [id= "+ id+ " ,activityID= "+ activityID+ " ,name= "+ name+ " ,description= "+ description+ " ,ownerID= "+ ownerID+ " ,point= "+ point+ " ,startTime= "+ startTime+ " ,endTime= "+ endTime+ " ,createTime= "+ createTime+ " ,updateTime= "+ updateTime+ " ]";
    }
}
