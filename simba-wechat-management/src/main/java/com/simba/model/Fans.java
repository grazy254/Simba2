package com.simba.model;

import java.io.Serializable;
import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 粉丝
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "粉丝")
public class Fans implements Serializable {

	private static final long serialVersionUID = -6261363695411219508L;

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 用户的标识，对当前公众号唯一
	 */
	@DescAnnotation(desc = "微信用户ID")
	private String openid;

	/**
	 * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
	 */
	@DescAnnotation(desc = "备注")
	private String remark;

	/**
	 * 用户的昵称
	 */
	@DescAnnotation(desc = "昵称")
	private String nickname;

	/**
	 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	 */
	@DescAnnotation(desc = "性别")
	private int sex;

	/**
	 * 用户所在城市
	 */
	@DescAnnotation(desc = "城市")
	private String city;

	/**
	 * 用户所在省份
	 */
	@DescAnnotation(desc = "省份")
	private String province;

	/**
	 * 用户所在国家
	 */
	@DescAnnotation(desc = "国家")
	private String country;

	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	@DescAnnotation(desc = "头像")
	private String headimgurl;

	/**
	 * 用户关注时间
	 */
	@DescAnnotation(desc = "关注时间")
	private Date subscribeTime;

	///////// 扩展属性，用于页面显示//////////////////
	/**
	 * 标签名
	 */
	private String tagName;

	/**
	 * 是否黑名单
	 */
	private boolean black;

	public boolean isBlack() {
		return black;
	}

	public void setBlack(boolean isBlack) {
		this.black = isBlack;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fans [id=");
		builder.append(id);
		builder.append(", openid=");
		builder.append(openid);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", nickname=");
		builder.append(nickname);
		builder.append(", sex=");
		builder.append(sex);
		builder.append(", city=");
		builder.append(city);
		builder.append(", province=");
		builder.append(province);
		builder.append(", country=");
		builder.append(country);
		builder.append(", headimgurl=");
		builder.append(headimgurl);
		builder.append(", subscribeTime=");
		builder.append(subscribeTime);
		builder.append("]");
		return builder.toString();
	}

}
