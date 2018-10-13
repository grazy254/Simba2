package com.simba.ip.model;

import java.io.Serializable;

/**
 * 调用阿里云接口获取ip地址信息返回的对象
 * 
 * @author caozhejun
 *
 */
public class IpResult implements Serializable {

	private static final long serialVersionUID = 1015207348547975070L;

	/**
	 * 0：成功，1：失败
	 */
	private int code;

	/**
	 * ip地址信息
	 */
	private IpInfo data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public IpInfo getData() {
		return data;
	}

	public void setData(IpInfo data) {
		this.data = data;
	}

}
