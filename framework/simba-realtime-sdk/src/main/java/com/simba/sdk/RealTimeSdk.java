package com.simba.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.eureka.client.EurekaClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 实时推送系统sdk
 * 
 * @author caozhejun
 *
 */
@Component
public class RealTimeSdk {

	private static final Log logger = LogFactory.getLog(RealTimeSdk.class);

	private static final String url = "/REALTIMEUSER/server/api/realTimeMessage/send";

	@Autowired
	private EurekaClientUtil client;

	/**
	 * 通过websocket推送消息给用户
	 * 
	 * @param userId
	 *            用户id
	 * @param content
	 *            推送的内容
	 * @param appid
	 *            应用的id
	 * @return
	 */
	public void send(String userId, String content, String appid) {
		logger.info("通过websocket推送消息给用户:userId=" + userId + ",appid=" + appid + ",content=" + content);
		Map<String, String> param = new HashMap<>();
		param.put("userId", userId);
		param.put("appid", appid);
		param.put("content", content);
		String result = client.post(url, param);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("通过websocket推送消息给用户发生异常:userId=" + userId + ",appid=" + appid + ",content=" + content);
	}

}
