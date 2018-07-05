package com.simba.model;
/***********************************************************************
 * Module:  ProjectServer.java
 * Author:  caozhejun
 * Purpose: Defines the Class ProjectServer
 ***********************************************************************/

import com.simba.annotation.DescAnnotation;

/**
 * 服务器
 */
@DescAnnotation(desc = "服务器")
public class ProjectServer {

	/** */
	@DescAnnotation(desc = "")
	private int id;

	/**
	 * 名称
	 */
	@DescAnnotation(desc = "名称")
	private String name;

	/**
	 * IP
	 * 
	 */
	@DescAnnotation(desc = "IP")
	private String ip;

	/**
	 * 端口号
	 */
	@DescAnnotation(desc = "端口号")
	private int port;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "ProjectServer{" + "id=" + id + ", name='" + name + '\'' + ", ip='" + ip + '\'' + ", port=" + port + '}';
	}

}