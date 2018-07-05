package com.simba.mobile.message.impls;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.exception.SimbaException;
import com.simba.mobile.message.interfaces.SendMsgInterface;
import com.simba.mobile.message.model.MsgType;
import com.simba.msg.util.AliMsgService;

/**
 * 阿里云短信服务发送手机短信
 * 
 * @author caozhejun
 *
 */
@Component
public class AliSendMsg implements SendMsgInterface {

	private static final Log logger = LogFactory.getLog(AliSendMsg.class);

	@Autowired
	private AliMsgService aliMsgService;

	@Override
	public MsgType getMsgType() {
		return MsgType.ALI;
	}

	@Override
	public String send(String mobileNo, String code, Map<String, String> params) {
		try {
			return aliMsgService.send(mobileNo, code, params);
		} catch (Exception e) {
			logger.error("使用阿里云短信服务发送手机短信失败", e);
			throw new SimbaException("使用阿里云短信服务发送手机短信失败" + mobileNo);
		}
	}

	@Override
	public String send(List<String> mobileNoList, String code, Map<String, String> params) {
		try {
			return aliMsgService.send(mobileNoList, code, params);
		} catch (Exception e) {
			logger.error("使用阿里云短信服务发送手机短信失败", e);
			throw new SimbaException("使用阿里云短信服务发送手机短信失败" + mobileNoList.toString());
		}
	}

	@Override
	public boolean isEnabled() {
		return aliMsgService.isEnabled();
	}

}
