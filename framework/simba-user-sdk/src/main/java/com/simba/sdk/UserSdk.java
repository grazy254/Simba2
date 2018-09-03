package com.simba.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.eureka.client.EurekaClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 实时推送系统sdk
 * 
 * @author caozhejun
 *
 */
@Component
public class UserSdk {

	private static final Log logger = LogFactory.getLog(UserSdk.class);

	private static final String loginUrl = "/USER/api/simbaUser/toLogin";

	private static final String loginVerifUrl = "/USER/api/simbaUser/toLoginVerif";

	private static final String registerUrl = "/USER/api/simbaUser/toRegisterApp";

	private static final String resetPassswordUrl = "/USER/api/simbaUser/toResetPasswordApp";

	private static final String findPasswordUrl = "/USER/api/simbaUser/toFindPasswordApp";

	private static final String getMobileByUserIdUrl = "/USER/api/simbaUser/getMobileByUserId";

	private static final String isRepeatAccountUrl = "/USER/api/simbaUser/isRepeatAccount";

	private static final String updateNameUrl = "/USER/api/simbaUser/updateName";

	private static final String updateHeadPicUrl = "/USER/api/simbaUser/updateHeadPic";

	private static final String verifUrl = "/USER/api/simbaUser/verif";

	private static final String userIdSessionKey = "userId";

	@Autowired
	private EurekaClientUtil client;

	public String getUserIdSessionKey() {
		return userIdSessionKey;
	}

	/**
	 * 调用user系统的login方法
	 * 
	 * @param account
	 * @param password
	 * @param verif
	 * @return
	 */
	public JsonResult getLogin(String account, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("password", password);
		logger.info("客户端登录结果:-----------------" + account + "--------" + password + "--------" + loginUrl + "-" + map);
		String result = client.post(loginUrl, map);
		logger.info("客户端登录结果:" + result);
		return FastJsonUtil.toObject(result, JsonResult.class);
	}

	/**
	 * 调用user系统的register方法
	 * 
	 * @param account
	 * @param password
	 * @param verif
	 * @return
	 */
	public JsonResult getRegister(String account, String password) {
		// 使用签名sign 去验证访问user系统的接口是否合法,加随机盐
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("password", password);
		String result = client.post(registerUrl, map);
		logger.info("客户端注册结果:" + result);
		return FastJsonUtil.toObject(result, JsonResult.class);
	}

	/**
	 * 调用user系统的findpassword方法
	 * 
	 * @param account
	 * @param password
	 * @param verif
	 * @return
	 */
	public JsonResult getFindPassword(String account, String password) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("newPassword", password);
		String result = client.post(findPasswordUrl, map);
		logger.info("客户端找回密码结果:" + result);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("客户端找回密码结果异常");
		return jsonResult;
	}

	/**
	 * 调用user系统的resetpassword方法
	 * 
	 * @param account
	 * @param password
	 * @param verif
	 * @return
	 */
	public JsonResult getResetPassword(String account, String oldPassword, String newPassword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("account", account);
		map.put("oldPassword", oldPassword);
		map.put("newPassword", newPassword);
		String result = client.post(resetPassswordUrl, map);
		logger.info("客户端重置密码结果:" + result);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("客户端重置密码结果异常");
		return jsonResult;
	}

	/**
	 * 获取用户的手机号
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	public JsonResult getMobile(long userId) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", userId + StringUtils.EMPTY);
		String result = client.post(getMobileByUserIdUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("通过userId找手机号结果异常");
		return jsonResult;
	}

	/**
	 * 验证码登录
	 * 
	 * @param mobile
	 * @param verif
	 * @return
	 */
	public JsonResult loginVerif(String mobile, String verif) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mobile", mobile);
		map.put("verif", verif);
		String result = client.post(loginVerifUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("手机验证码登录结果异常");
		return jsonResult;
	}

	/**
	 * 是否是重复账号
	 * 
	 * @param mobile
	 * @return
	 */
	public JsonResult isRepeatAccount(String mobile) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("mobile", mobile);
		String result = client.post(isRepeatAccountUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("查询账号重复结果异常");
		return jsonResult;
	}

	/**
	 * 更新名称
	 * 
	 * @param name
	 * @param userId
	 * @return
	 */
	public JsonResult updateName(String name, long userId) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("userId", userId + StringUtils.EMPTY);
		String result = client.post(updateNameUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("更新名称结果异常");
		return jsonResult;
	}

	/**
	 * 更新头像
	 * 
	 * @param headPic
	 * @param userId
	 * @return
	 */
	public JsonResult updateHeadPic(String headPic, long userId) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("headPic", headPic);
		map.put("userId", userId + StringUtils.EMPTY);
		String result = client.post(updateHeadPicUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("更新头像结果异常");
		return jsonResult;
	}

	/**
	 * 验证手机验证码
	 * 
	 * @param telNo
	 * @param verif
	 * @return
	 */
	public JsonResult verif(String telNo, String verif) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("telNo", telNo);
		map.put("verif", verif);
		String result = client.post(verifUrl, map);
		JsonResult jsonResult = FastJsonUtil.toObject(result, JsonResult.class);
		jsonResult.check("验证手机验证码结果异常");
		return jsonResult;
	}

}
