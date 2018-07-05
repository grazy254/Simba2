package com.simba.model;

import java.io.Serializable;
import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 项目
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "项目")
public class UserProject implements Serializable {

	private static final long serialVersionUID = 1795113597260024061L;

	/**
	 * 自增主键ID
	 */
	private int id;

	/**
	 * 编码
	 */
	@DescAnnotation(desc = "编码")
	private String code;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * 加密密钥
	 */
	@DescAnnotation(desc = "加密密钥")
	private String projectKey;

	/**
	 * 登录成功后的回调地址
	 */
	@DescAnnotation(desc = "登录成功后的回调地址")
	private String loginSuccessUrl;

	/**
	 * 忘记密码后的回调url地址
	 */
	@DescAnnotation(desc = "忘记密码后的回调url地址")
	private String forgetBackUrl;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	/**
	 * 创建者账号
	 */
	@DescAnnotation(desc = "创建者账号")
	private String createUserAccount;

	//////////// 扩展属性，用于页面显示/////////////
	private boolean canOper;

	public boolean isCanOper() {
		return canOper;
	}

	public void setCanOper(boolean canOper) {
		this.canOper = canOper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectKey() {
		return projectKey;
	}

	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}

	public String getLoginSuccessUrl() {
		return loginSuccessUrl;
	}

	public void setLoginSuccessUrl(String loginSuccessUrl) {
		this.loginSuccessUrl = loginSuccessUrl;
	}

	public String getForgetBackUrl() {
		return forgetBackUrl;
	}

	public void setForgetBackUrl(String forgetBackUrl) {
		this.forgetBackUrl = forgetBackUrl;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserAccount() {
		return createUserAccount;
	}

	public void setCreateUserAccount(String createUserAccount) {
		this.createUserAccount = createUserAccount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [id=");
		builder.append(id);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", projectKey=");
		builder.append(projectKey);
		builder.append(", loginSuccessUrl=");
		builder.append(loginSuccessUrl);
		builder.append(", forgetBackUrl=");
		builder.append(forgetBackUrl);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", createUserAccount=");
		builder.append(createUserAccount);
		builder.append("]");
		return builder.toString();
	}

}
