package com.simba.model;
/***********************************************************************
 * Module:  RedPackBill.java
 * Author:  caozhejun
 * Purpose: Defines the Class RedPackBill
 ***********************************************************************/

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 红包账单
 */
@DescAnnotation(desc = "红包账单")
public class RedPackBill {
	/** */
	@DescAnnotation(desc = "")
	private long id;

	/**
	 * 红包类型
	 */
	@DescAnnotation(desc = "红包类型")
	private String type;

	/**
	 * 商户订单号
	 */
	@DescAnnotation(desc = "商户订单号")
	private String billNo;

	/**
	 * 商户号
	 */
	@DescAnnotation(desc = "商户号")
	private String mchId;

	/**
	 * 公众账号appid
	 */
	@DescAnnotation(desc = "公众账号appid")
	private String appid;

	/**
	 * 商户名称
	 */
	@DescAnnotation(desc = "商户名称")
	private String sendName;

	/**
	 * 用户openid
	 */
	@DescAnnotation(desc = "用户openid")
	private String openid;

	/**
	 * 付款金额
	 */
	@DescAnnotation(desc = "付款金额")
	private int amount;

	/**
	 * 红包发放总人数
	 */
	@DescAnnotation(desc = "红包发放总人数")
	private int num;

	/**
	 * 红包祝福语
	 */
	@DescAnnotation(desc = "红包祝福语")
	private String wishing;

	/**
	 * Ip地址
	 */
	@DescAnnotation(desc = "Ip地址")
	private String clientIp;

	/**
	 * 活动名称
	 */
	@DescAnnotation(desc = "活动名称")
	private String actName;

	/**
	 * 备注
	 */
	@DescAnnotation(desc = "备注")
	private String remark;

	/**
	 * 场景id
	 */
	@DescAnnotation(desc = "场景id")
	private String sceneId;

	/**
	 * 活动信息
	 */
	@DescAnnotation(desc = "活动信息")
	private String riskInfo;

	/**
	 * 资金授权商户号
	 */
	@DescAnnotation(desc = "资金授权商户号")
	private String consumeMchId;

	/**
	 * 状态
	 */
	@DescAnnotation(desc = "状态")
	private String status;

	/**
	 * 错误信息
	 */
	@DescAnnotation(desc = "错误信息")
	private String errMsg;

	/**
	 * 微信单号
	 */
	@DescAnnotation(desc = "微信单号")
	private String sendListId;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 付款者
	 */
	@DescAnnotation(desc = "付款者")
	private String createUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSceneId() {
		return sceneId;
	}

	public void setSceneId(String sceneId) {
		this.sceneId = sceneId;
	}

	public String getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getConsumeMchId() {
		return consumeMchId;
	}

	public void setConsumeMchId(String consumeMchId) {
		this.consumeMchId = consumeMchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getSendListId() {
		return sendListId;
	}

	public void setSendListId(String sendListId) {
		this.sendListId = sendListId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Override
	public String toString() {
		return "RedPackBill{" + "id=" + id + ", type='" + type + '\'' + ", billNo='" + billNo + '\'' + ", mchId='" + mchId + '\'' + ", appid='" + appid + '\'' + ", sendName='" + sendName + '\''
				+ ", openid='" + openid + '\'' + ", amount=" + amount + ", num=" + num + ", wishing='" + wishing + '\'' + ", clientIp='" + clientIp + '\'' + ", actName='" + actName + '\''
				+ ", remark='" + remark + '\'' + ", sceneId='" + sceneId + '\'' + ", riskInfo='" + riskInfo + '\'' + ", consumeMchId='" + consumeMchId + '\'' + ", status='" + status + '\''
				+ ", errMsg='" + errMsg + '\'' + ", sendListId='" + sendListId + '\'' + ", createTime=" + createTime + ", createUser='" + createUser + '\'' + '}';
	}

}