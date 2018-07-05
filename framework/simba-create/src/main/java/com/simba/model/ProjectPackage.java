package com.simba.model;

public class ProjectPackage {

	/**
	 * 项目名称
	 */
	private String versionNo;

	/**
	 * 项目名称
	 */
	private String projectCode;

	/**
	 * 包名
	 */
	private String packageName;

	/**
	 * 超级管理员账号
	 */
	private String account;

	/**
	 * 超级管理员密码
	 */
	private String pwd;

	/**
	 * 普通用户密码
	 */
	private String defaultPwd;

	/**
	 * 加密秘钥
	 */
	private String encryptKey;

	/**
	 * 管理系统端口号
	 */
	private int adminPort;

	/**
	 * 用户系统端口号
	 */
	private int userPort;

	public int getAdminPort() {
		return adminPort;
	}

	public void setAdminPort(int adminPort) {
		this.adminPort = adminPort;
	}

	public int getUserPort() {
		return userPort;
	}

	public void setUserPort(int userPort) {
		this.userPort = userPort;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDefaultPwd() {
		return defaultPwd;
	}

	public void setDefaultPwd(String defaultPwd) {
		this.defaultPwd = defaultPwd;
	}

	public String getEncryptKey() {
		return encryptKey;
	}

	public void setEncryptKey(String encryptKey) {
		this.encryptKey = encryptKey;
	}

}
