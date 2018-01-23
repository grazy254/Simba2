package com.simba.model;

import java.util.Date;

import com.simba.annotation.DescAnnotation;

/**
 * 异常信息
 * 
 * @author caozhejun
 *
 */
@DescAnnotation(desc = "异常信息")
public class ExceptionInfo {

	private long id;

	/**
	 * ip地址
	 */
	@DescAnnotation(desc = "IP")
	private String ip;

	/**
	 * 地址
	 */
	@DescAnnotation(desc = "地址")
	private String ipInfo;

	/**
	 * 信息内容
	 */
	@DescAnnotation(desc = "内容")
	private String exceptionInfo;

	/**
	 * 时间
	 */
	@DescAnnotation(desc = "时间")
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpInfo() {
		return ipInfo;
	}

	public void setIpInfo(String ipInfo) {
		this.ipInfo = ipInfo;
	}

	public String getExceptionInfo() {
		return exceptionInfo;
	}

	public void setExceptionInfo(String exceptionInfo) {
		this.exceptionInfo = exceptionInfo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
