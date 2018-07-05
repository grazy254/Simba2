package com.simba.mobile.message.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.framework.util.applicationcontext.ApplicationContextInit;

/**
 * 初始化手机短信发送工具类通道
 * 
 * @author caozhejun
 *
 */
@Component
public class InitSendMsg implements ApplicationContextInit {

	@Autowired
	private SendMsgUtil sendMsgUtil;

	@Override
	public void init() {
		sendMsgUtil.init();
	}

	@Override
	public int sort() {
		return 0;
	}

}
