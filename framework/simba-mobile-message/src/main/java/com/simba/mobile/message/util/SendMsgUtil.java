package com.simba.mobile.message.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.simba.exception.SimbaException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.mobile.message.interfaces.SendMsgInterface;
import com.simba.mobile.message.model.MsgType;

/**
 * 发送手机短信工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class SendMsgUtil {

	private Map<String, SendMsgInterface> sendMsg = null;

	/**
	 * 初始化
	 */
	public void init() {
		sendMsg = new HashMap<>(MsgType.values().length);
		List<SendMsgInterface> sendList = ApplicationContextUtil.getBeansOfType(SendMsgInterface.class);
		sendList.forEach((SendMsgInterface send) -> {
			if (send.isEnabled()) {
				sendMsg.put(send.getMsgType().getType(), send);
			}
		});
	}

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
	public String send(String mobileNo, String code, Map<String, String> params, MsgType type) {
		SendMsgInterface send = sendMsg.get(type.getType());
		if (send == null) {
			throw new SimbaException("没有实现" + type.getDescription());
		}
		return send.send(mobileNo, code, params);
	}

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
	public String send(List<String> mobileNoList, String code, Map<String, String> params, MsgType type) {
		SendMsgInterface send = sendMsg.get(type.getType());
		if (send == null) {
			throw new SimbaException("没有实现" + type.getDescription());
		}
		return send.send(mobileNoList, code, params);
	}

}
