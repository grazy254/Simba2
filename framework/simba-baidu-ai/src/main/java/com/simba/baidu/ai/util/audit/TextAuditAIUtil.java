package com.simba.baidu.ai.util.audit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.baidu.ai.model.audit.TextAuditResponse;
import com.simba.baidu.ai.util.BaiduAiAccessTokenUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;

/**
 * 百度AI文本审核工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class TextAuditAIUtil {

	private static final String textAuditUrl = "https://aip.baidubce.com/rest/2.0/antispam/v1/spam";

	@Autowired
	private BaiduAiAccessTokenUtil baiduAiAccessTokenUtil;

	/**
	 * 文本审核
	 * 
	 * @param code
	 *            策略定制标识，可支持渠道定制，通用默认值为500071
	 * @param text
	 *            待审核的文本内容，不可为空，长度不超过20000字节
	 * @return
	 */
	public TextAuditResponse audit(int code, String text) {
		String accessToken = baiduAiAccessTokenUtil.getAccessToken();
		String url = textAuditUrl + "?access_token=" + accessToken;
		Map<String, String> params = new HashMap<>(2);
		params.put("command_no", code + "");
		params.put("content", text);
		String result = HttpClientUtil.post(url, params);
		TextAuditResponse res = FastJsonUtil.toObject(result, TextAuditResponse.class);
		return res;
	}

	/**
	 * 文本审核
	 * 
	 * @param text
	 * @return
	 */
	public TextAuditResponse audit(String text) {
		return audit(500071, text);
	}
}
