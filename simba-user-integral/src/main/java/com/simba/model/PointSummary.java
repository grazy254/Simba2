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
public class PointSummary  {

    private long id;

    private String userID;

    private int point;

    private Date createTime;

    private Date updateTime;

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
        return "PointSummary [id= "+ id+ " ,userID= "+ userID+ " ,point= "+ point+ " ,createTime= "+ createTime+ " ,updateTime= "+ updateTime+ " ]";
    }
}
