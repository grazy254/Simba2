package com.simba.service.message.impls;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simba.eureka.client.EurekaClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;

/**
 * 将接收到的消息以spring cloud的方式转发
 * 
 * @author caozhejun
 *
 */
@Service
public class SpringCloudPostMessage implements ReceiveDealInterface {

	private static final Log logger = LogFactory.getLog(SpringCloudPostMessage.class);

	@Autowired
	private EurekaClientUtil client;

	@Override
	public Object deal(ReceiveMsg msg, ReceiveDealType type) {
		logger.info("***************处理转发消息*********************************" + msg.toString() + type.toString());
		String message = msg.getMessage();
		String url = type.getExt();
		int index = url.indexOf("?");
		String postUrl = url.substring(0, index);
		String paramName = url.substring(index + 1, url.length() - 1);
		Map<String, String> param = new HashMap<>();
		param.put(paramName, message);
		String response = client.post(postUrl, param);
		JsonResult result = FastJsonUtil.toObject(response, JsonResult.class);
		result.check("使用spring cloud转发消息发生异常");
		return result.getData();
	}

}
