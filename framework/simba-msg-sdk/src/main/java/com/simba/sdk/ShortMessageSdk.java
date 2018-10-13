package com.simba.sdk;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 短信系统sdk
 *
 * @author linshuo
 */
@Component
public class ShortMessageSdk {

	private static final Log logger = LogFactory.getLog(ShortMessageSdk.class);

	private static final String url = "http://SHORTMSGUSER/server/api/sendMsg/send";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 发送手机短信
	 *
	 * @param mobile
	 *            手机号
	 * @param code
	 *            模板Id
	 * @param params
	 *            插入模板的值
	 */
	public JsonResult send(String mobile, String code, Map<String, String> params, String projectId, String projectKey) {
		long timestamp = System.currentTimeMillis();
		MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
		param.add("templateSelfId", code);
		param.add("projectId", projectId);
		param.add("cipherText", EncryptUtil.md5(projectKey + timestamp));
		param.add("values", params);
		param.add("mobile", mobile);
		param.add("timeStamp", timestamp);
		String result = restTemplate.postForObject(url, param, String.class);
		logger.info("发送请求到短信服务器返回结果:" + result);
		return FastJsonUtil.toObject(result, JsonResult.class);
	}

}
