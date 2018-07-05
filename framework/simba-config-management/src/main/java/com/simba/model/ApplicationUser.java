package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 用户应用表
 * 
 * @author lilei
 *
 */
@DescAnnotation(desc = "用户应用表")
public class ApplicationUser {

	/**
	 * 自增主键ID
	 */
	private long id;
	
	/**
	 * 应用id
	 */
	@DescAnnotation(desc = "应用id")
	private int applicationId;
	/**
	 * 用户id
	 */
	@DescAnnotation(desc = "用户id")
	private  int userId;
	/**
	 * 用户类型
	 */
	@DescAnnotation(desc = "用户类型")
	private  int userType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "AppliactionUser [id=" + id + ", applicationId=" + applicationId + ", userId=" + userId + ", userType=" + userType + "]";
	}
	
	
}
