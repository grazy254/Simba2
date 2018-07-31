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
 * 转接系统sdk
 * 
 * @author caozhejun
 *
 */
@Component
public class SwitchSdk {

	private static final Log logger = LogFactory.getLog(SwitchSdk.class);

	private static final String url = "/SWITCHUSER/server/api/switch/receive";

	@Autowired
	private EurekaClientUtil client;

	/**
	 * 发送消息给erlang服务器，然后通过erlang服务器解析之后传给硬件设备
	 * 
	 * @param message
	 * @return
	 */
	public String sendToErlang(String message) {
		return send(message, "devicemonitor", "erlangSendMessage");
	}

	/**
	 * 发送消息给转接系统，通过转接系统到配置转发到其他业务系统中
	 * 
	 * @param message
	 * @param source
	 * @param type
	 * @return
	 */
	public String send(String message, String source, String type) {
		logger.info("发送消息给转接系统:message=" + message + ",source=" + source + ",type=" + type);
		String sendUrl = url + "?type=" + type + "&source=" + source;
		Map<String, String> param = new HashMap<>();
		param.put("message", message);
		String result = client.post(sendUrl, param);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("发送消息给转接系统发生异常:message=" + message + ",source=" + source + ",type=" + type);
		return (String) jsonResult.getData();
	}

}
