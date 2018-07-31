package com.simba.service.message.impls;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.simba.exception.BussException;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;
import com.simba.okhttp.util.OkHttpClientUtil;

/**
 * 将接收到的消息以http post的方式转发
 * 
 * @author caozhejun
 *
 */
@Service
public class HttpPostMessage implements ReceiveDealInterface {

	private static final Log logger = LogFactory.getLog(HttpPostMessage.class);

	@Override
	public Object deal(ReceiveMsg msg, ReceiveDealType type) {
		try {
			String message = msg.getMessage();
			String url = type.getExt();
			int index = url.indexOf("?");
			String postUrl = url.substring(0, index);
			String paramName = url.substring(index + 1, url.length() - 1);
			Map<String, String> param = new HashMap<>();
			param.put(paramName, message);
			String response = OkHttpClientUtil.getInstance().post(postUrl, param);
			JsonResult result = FastJsonUtil.toObject(response, JsonResult.class);
			result.check("使用http转发消息发生异常");
			return result.getData();
		} catch (IOException e) {
			logger.error("使用http转发消息发生异常", e);
			throw new BussException("使用http转发消息发生异常");
		}
	}

}
