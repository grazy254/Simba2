package com.simba.model;

import com.simba.annotation.DescAnnotation;


/**
 *
 * null
 * @author lilei
 *
 */
@DescAnnotation(desc = "null")
public class PointSummary  {

    private long id;

    @DescAnnotation(desc = "用户id") 
    private String userID;

    @DescAnnotation(desc = "用户积分") 
    private int point;

    @DescAnnotation(desc = "时间") 
    private String createTime;

    private String updateTime;

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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "PointSummary [id= "+ id+ " ,userID= "+ userID+ " ,point= "+ point+ " ,createTime= "+ createTime+ " ,updateTime= "+ updateTime+ " ]";
    }
}
