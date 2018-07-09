package com.simba.gaode.model;

/**
 * 公交路线规划结果
 * 
 * @author caozhejun
 *
 */
public class BusResult {

	/**
	 * 返回状态 值为0或1
	 * 
	 * 1：成功；0：失败
	 */
	private String status;

	/**
	 * 返回的状态信息 status为0时，info返回错误原因；否则返回ok
	 */
	private String info;

	/**
	 * 返回结果总数目
	 */
	private String count;

	private String infocode;

}
