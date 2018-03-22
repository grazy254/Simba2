package com.simba.model.form;

/**
 * 粉丝查询对象
 * 
 * @author caozhejun
 *
 */
public class FansSearchForm {

	private String openid;

	private String remark;

	private String nickname;

	private String startTime;

	private String endTime;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FansSearchForm [openid=");
		builder.append(openid);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}

}
