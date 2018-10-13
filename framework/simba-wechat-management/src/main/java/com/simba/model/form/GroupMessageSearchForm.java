package com.simba.model.form;

public class GroupMessageSearchForm {

	private Integer isAll;

	private Integer wxTagId;

	private String type;

	private String startTime;

	private String endTime;

	private String account;

	private Integer status;

	private String mediaId;

	public Integer getIsAll() {
		return isAll;
	}

	public void setIsAll(Integer isAll) {
		this.isAll = isAll;
	}

	public Integer getWxTagId() {
		return wxTagId;
	}

	public void setWxTagId(Integer wxTagId) {
		this.wxTagId = wxTagId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
