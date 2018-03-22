package com.simba.controller.form;

/**
 * 红包账单查询对象
 */
public class RedPackBillSearchForm {

	/**
	 * 红包类型
	 */
	private String type;

	/**
	 * 商户订单号
	 */
	private String billNo;

	/**
	 * 用户openid
	 */
	private String openid;

	/**
	 * 活动名称
	 */
	private String actName;

	/**
	 * 场景id
	 */
	private String sceneId;

	/**
	 * 状态
	 */
	private String status;

	/**
	 * 微信单号
	 */
	private String sendListId;

	private String startTime;

	private String endTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getSceneId() {
		return sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSendListId() {
		return sendListId;
	}

	public void setSendListId(String sendListId) {
		this.sendListId = sendListId;
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

}