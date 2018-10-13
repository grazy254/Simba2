package com.simba.service.message.impls;

import org.apache.commons.httpclient.HttpClient;
import org.springframework.stereotype.Service;

import com.simba.framework.util.http.HttpClientUtil;
import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;

/**
 * 将接收到的消息以http body的方式转发
 * 
 * @author caozhejun
 *
 */
@Service
public class HttpBodyMessage implements ReceiveDealInterface {

	@Override
	public Object deal(ReceiveMsg msg, ReceiveDealType type) {
		String message = msg.getMessage();
		String url = type.getExt();
		HttpClient httpClient = HttpClientUtil.getHttpClient();
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(50000);
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(50000);
		String result = HttpClientUtil.postJson(url, message, httpClient);
		return result;
	}

}
