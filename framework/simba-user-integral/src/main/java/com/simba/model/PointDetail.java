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
public class PointDetail  {

    private long id;

    private String userID;

    private String activityID;

    private int point;

    private Date createTime;

    private Date expireTime;
    
    //用于显示
    private String activityName;

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

	public String getActivityID() {
		return activityID;
	}

	public void setActivityID(String activityID) {
		this.activityID = activityID;
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

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public String toString() {
		return "PointDetail [id=" + id + ", userID=" + userID + ", activityID=" + activityID + ", point=" + point + ", createTime=" + createTime + ", expireTime=" + expireTime + ", activityName="
				+ activityName + "]";
	}
    
    

   
   
}
