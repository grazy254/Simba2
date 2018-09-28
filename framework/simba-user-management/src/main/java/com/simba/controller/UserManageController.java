package com.simba.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.ThirdSystemUser;
import com.simba.model.constant.SimbaRedisKey;
import com.simba.model.enums.ThirdSystemType;
import com.simba.service.SmartUserService;
import com.simba.service.ThirdSystemUserService;

/**
 * 用户相关接口Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/userApi")
public class UserManageController {

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private SmartUserService smartUserService;

	@Autowired
	private ThirdSystemUserService thirdSystemUserService;

	/**
	 * 根据第三方用户id获取用户的userId
	 * 
	 * @param thirdUserId
	 * @param thirdSystemType
	 * @return
	 */
	@RequestMapping("/getUserId")
	public JsonResult getUserId(String thirdUserId, String thirdSystemType) {
		return new JsonResult(smartUserService.getUserId(thirdUserId, thirdSystemType));
	}

	/**
	 * 根据微信小程序用户的openid获取用户的userId
	 * 
	 * @param openid
	 * @return
	 */
	@RequestMapping("/getUserIdByMiniOpenid")
	public JsonResult getUserIdByMiniOpenid(String openid) {
		return new JsonResult(smartUserService.getUserId(openid, ThirdSystemType.WXMINI.getName()));
	}

	/**
	 * 根据微信用户的openid获取用户的userId
	 * 
	 * @param openid
	 * @return
	 */
	@RequestMapping("/getUserIdByOpenid")
	public JsonResult getUserIdByOpenid(String openid) {
		return new JsonResult(smartUserService.getUserId(openid, ThirdSystemType.WX.getName()));
	}

	/**
	 * 根据用户userId获取微信用户openid
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getOpenidByUserId")
	public JsonResult getOpenidByUserId(long userId) {
		String key = SimbaRedisKey.userIdOpenIdKey + userId;
		String openid = (String) redisUtil.get(key);
		if (StringUtils.isNotEmpty(openid)) {
			return new JsonResult(openid);
		}
		List<ThirdSystemUser> list = thirdSystemUserService.listByAnd("thirdSystem", ThirdSystemType.WX.getName(), "userId", userId);
		if (list.size() == 0) {
			return new JsonResult(StringUtils.EMPTY);
		}
		openid = list.get(0).getThirdSystemUserId();
		redisUtil.set(key, openid);
		return new JsonResult(openid);
	}

}
