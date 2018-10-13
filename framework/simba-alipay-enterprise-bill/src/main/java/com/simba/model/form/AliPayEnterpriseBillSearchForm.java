package com.simba.model.form;

import com.simba.annotation.DBFieldAnnotation;

/**
 * 阿里支付账单查询对象
 * 
 * @author caozhejun
 *
 */
public class AliPayEnterpriseBillSearchForm {

	@DBFieldAnnotation(desc = "状态")
	private String status;

	@DBFieldAnnotation(desc = "商户订单号")
	private String outBizNo;

	@DBFieldAnnotation(desc = "账户类型")
	private String payType;

	@DBFieldAnnotation(desc = "收款方账户")
	private String account;

	@DBFieldAnnotation(desc = "收款方真实姓名")
	private String peyeeName;

	@DBFieldAnnotation(desc = "支付宝转账单据号")
	private String orderId;

	@DBFieldAnnotation(desc = "创建者")
	private String createUser;

	@DBFieldAnnotation(desc = "开始时间", oper = ">=", field = "createTime")
	private String startCreateTime;

	@DBFieldAnnotation(desc = "结束时间", oper = "<=", field = "createTime")
	private String endCreateTime;

	public String getOutBizNo() {
		return outBizNo;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPeyeeName() {
		return peyeeName;
	}

	public void setPeyeeName(String peyeeName) {
		this.peyeeName = peyeeName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AliPayEnterpriseBillSearchForm [outBizNo=");
		builder.append(outBizNo);
		builder.append(", payType=");
		builder.append(payType);
		builder.append(", account=");
		builder.append(account);
		builder.append(", peyeeName=");
		builder.append(peyeeName);
		builder.append(", orderId=");
		builder.append(orderId);
		builder.append(", createUser=");
		builder.append(createUser);
		builder.append(", status=");
		builder.append(status);
		builder.append(", startCreateTime=");
		builder.append(startCreateTime);
		builder.append(", endCreateTime=");
		builder.append(endCreateTime);
		builder.append("]");
		return builder.toString();
	}

}
