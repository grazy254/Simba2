package com.simba.interfaces;

import org.springframework.stereotype.Component;

import com.simba.framework.util.applicationcontext.ApplicationContextInit;
import com.simba.util.send.WxPayUtil;

/**
 * 服务启动之后，微信支付需要执行的初始化
 * 
 * @author caozhejun
 *
 */
@Component
public class WechatPayStart implements ApplicationContextInit {

	@Override
	public void init() {
		WxPayUtil.getInstance();
	}

	@Override
	public int sort() {
		return 1000;
	}

}
