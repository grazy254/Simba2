package com.simba.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.cache.Redis;
import com.simba.sdk.UserSdk;

/**
 * 用户工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class UserUtil {

	@Autowired
	private UserSdk sdk;

	@Autowired
	private Redis redisUtil;

	/**
	 * 获取用户手机号
	 * 
	 * @param userId
	 * @return
	 */
	public String getMobile(Long userId) {
		String key = "Simba:String:UserMobile:" + userId;
		String mobile = (String) redisUtil.getString(key);
		if (StringUtils.isEmpty(mobile)) {
			mobile = (String) sdk.getMobile(userId).getData();
			redisUtil.setString(key, mobile);
		}
		return mobile;
	}

}
