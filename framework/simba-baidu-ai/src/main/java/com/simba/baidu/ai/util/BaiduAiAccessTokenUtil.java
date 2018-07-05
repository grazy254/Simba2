package com.simba.baidu.ai.util;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.simba.baidu.ai.model.AiAccessToken;
import com.simba.cache.Redis;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;

/**
 * 获取百度ai的accesstoken的工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class BaiduAiAccessTokenUtil {

	private static final Log logger = LogFactory.getLog(BaiduAiAccessTokenUtil.class);

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	@Resource
	private Redis redisUtil;

	/**
	 * 获取API访问token 该token有一定的有效期，需要自行管理，当失效时需重新获取.
	 * 
	 * @param ak
	 *            - 百度云官网获取的 API Key
	 * @param sk
	 *            - 百度云官网获取的 Securet Key
	 * @return assess_token 示例：
	 *         "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
	 */
	private AiAccessToken getAuth(String ak, String sk) {
		// 获取token地址
		String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
		String getAccessTokenUrl = authHost
				// 1. grant_type为固定参数
				+ "grant_type=client_credentials"
				// 2. 官网获取的 API Key
				+ "&client_id=" + ak
				// 3. 官网获取的 Secret Key
				+ "&client_secret=" + sk;
		String json = HttpClientUtil.post(getAccessTokenUrl);
		logger.info("访问百度AI云AccessToken，返回:" + json);
		return FastJsonUtil.toObject(json, AiAccessToken.class);
	}

	/**
	 * 请求access_token
	 */
	public void requestAccessToken() {
		AiAccessToken accessToken = this.getAuth(key, secret);
		if (StringUtils.isNotEmpty(accessToken.getAccess_token())) {
			logger.info("从百度AI服务器获取access_token:" + accessToken.getAccess_token() + ",过期时间:" + accessToken.getExpires_in());
			saveAccessToken(accessToken.getAccess_token());
		}
	}

	/**
	 * 保存access_token
	 * 
	 * @param accessToken
	 */
	private void saveAccessToken(String accessToken) {
		redisUtil.set("baidu_ai_access_token", accessToken, 30 * 24 * 60 * 60);
	}

	/**
	 * 获取access_token
	 * 
	 * @return
	 */
	public String getAccessToken() {
		String result = (String) redisUtil.get("baidu_ai_access_token");
		if (StringUtils.isEmpty(result)) {
			this.requestAccessToken();
			return this.getAccessToken();
		}
		return result;
	}
}
