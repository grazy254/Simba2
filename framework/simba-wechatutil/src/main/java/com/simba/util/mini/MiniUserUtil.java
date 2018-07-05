package com.simba.util.mini;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.mini.MiniUserInfo;
import com.simba.util.common.WxConstantData;

/**
 * 
 * 微信小程序用户信息相关工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class MiniUserUtil {

	private static final Log logger = LogFactory.getLog(MiniUserUtil.class);

	private String appID;

	private String appSecret;

	@Autowired
	private EnvironmentUtil environmentUtil;

	@PostConstruct
	private void init() {
		appID = environmentUtil.get("wechat.mini.appID");
		appSecret = environmentUtil.get("wechat.mini.appSecret");
		if (StringUtils.isEmpty(appID) || StringUtils.isEmpty(appSecret)) {
			logger.warn("微信小程序没有配置appid[wechat.mini.appID]和secret[wechat.mini.appSecret]");
		}
	}

	/**
	 * 根据用户code获取微信小程序哟用户信息
	 * 
	 * @param code
	 * @return
	 */
	public MiniUserInfo getUserInfo(String code) {
		String url = WxConstantData.miniUserUrl + "?appid=" + appID + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=authorization_code";
		String result = HttpClientUtil.get(url);
		logger.info("微信小程序获取用户信息返回结果:" + result);
		return FastJsonUtil.toObject(result, MiniUserInfo.class);
	}
}
