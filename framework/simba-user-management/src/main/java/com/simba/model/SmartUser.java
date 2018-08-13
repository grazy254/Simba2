package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 用户
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "用户")
public class SmartUser {

	/**
	 * 自增主键ID
	 */
	private long id;

	/**
	 * 账号
	 */
	@DescAnnotation(desc = "账号")
	private String account;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * 邮箱
	 */
	@DescAnnotation(desc = "邮箱")
	private String email;

	/**
	 * 手机号
	 */
	@DescAnnotation(desc = "手机号")
	private String telNo;

	/**
	 * 密码
	 */
	@DescAnnotation(desc = "密码")
	private String password;

	/**
	 * 注册时间
	 */
	@DescAnnotation(desc = "注册时间")
	private Date createTime;

	/**
	 * 状态
	 */
	@DescAnnotation(desc = "状态")
	private int status;
	
	/**
	 * 分组id
	 */
	@DescAnnotation(desc = "分组id")
	private long groupId;
	
	/**
	 * 性别
	 */
	@DescAnnotation(desc = "性别")
	private int sex;

	/**
	 * 头像
	 */
	@DescAnnotation(desc = "头像")
	private String headPic;
	
	/**
	 * 是否领取红包 0没领1领取
	 */
	@DescAnnotation(desc = "是否领取红包")
	private int isRedPacket;
	
	
	//扩张属性----第三方系统用户ID和第三方系统名称
	
	@DescAnnotation(desc = "第三方系统名称")
	private String thirdSystem;
	
	@DescAnnotation(desc = "分组")
	private  String  group;
	
	@DescAnnotation(desc = "uuid")
	private  String  uuid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getIsRedPacket() {
		return isRedPacket;
	}

	public void setIsRedPacket(int isRedPacket) {
		this.isRedPacket = isRedPacket;
	}

	public String getThirdSystem() {
		return thirdSystem;
	}

	public void setThirdSystem(String thirdSystem) {
		this.thirdSystem = thirdSystem;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "SmartUser [id=" + id + ", account=" + account + ", name=" + name + ", email=" + email + ", telNo=" + telNo + ", password=" + password + ", createTime=" + createTime + ", status="
				+ status + ", groupId=" + groupId + ", sex=" + sex + ", headPic=" + headPic + ", isRedPacket=" + isRedPacket + ", thirdSystem=" + thirdSystem + ", group=" + group + ", uuid=" + uuid
				+ "]";
	}

	
}
