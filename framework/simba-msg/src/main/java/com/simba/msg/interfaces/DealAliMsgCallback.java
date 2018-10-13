package com.simba.msg.interfaces;

import com.simba.msg.model.SmsReport;
import com.simba.msg.model.SmsUp;

/**
 * 处理阿里云短信服务回调
 * 
 * @author caozhejun
 *
 */
public interface DealAliMsgCallback {

	/**
	 * 处理短信回执消息
	 * 
	 * @param report
	 */
	void dealReport(SmsReport report);

	/**
	 * 处理上行短信消息
	 * 
	 * @param up
	 */
	void dealUp(SmsUp up);
}
