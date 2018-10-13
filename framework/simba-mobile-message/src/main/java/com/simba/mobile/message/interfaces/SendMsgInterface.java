package com.simba.mobile.message.interfaces;

import java.util.List;
import java.util.Map;

import com.simba.mobile.message.model.MsgType;

/**
 * 发送手机短信接口
 * 
 * @author caozhejun
 *
 */
public interface SendMsgInterface {
	
	/**
	 * 是否启用
	 * @return
	 */
	boolean isEnabled();

	/**
	 * 实现发送手机短信的类型
	 * 
	 * @return
	 */
	MsgType getMsgType();

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNo
	 *            接收短信的手机号
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 */
	String send(String mobileNo, String code, Map<String, String> params);

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNoList
	 *            接收短信的手机号列表
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 */
	String send(List<String> mobileNoList, String code, Map<String, String> params);
}
