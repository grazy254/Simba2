package com.simba.model;

import com.simba.annotation.DescAnnotation;


/**
 *
 * null
 * @author lilei
 *
 */
@DescAnnotation(desc = "null")
public class PointDetail  {

    private long id;

    private String userID;

    @DescAnnotation(desc = "活动id") 
    private long activityID;

    @DescAnnotation(desc = "积分") 
    private int point;

    @DescAnnotation(desc = "时间") 
    private String createTime;

    private String expireTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getActivityID() {
        return activityID;
    }

    public void setActivityID(long activityID) {
        this.activityID = activityID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "PointDetail [id= "+ id+ " ,userID= "+ userID+ " ,activityID= "+ activityID+ " ,point= "+ point+ " ,createTime= "+ createTime+ " ,expireTime= "+ expireTime+ " ]";
    }
}
