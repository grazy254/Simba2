package com.simba.controller.api;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;
import com.simba.sdk.UserSdk;

/**
 * 用户登录
 * 
 * @author lilei
 * 
 */
@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserSdk userSdk;

	/**
	 * 验证码，从api系统中获取对比
	 * 
	 * @param telNo
	 *            手机号
	 * @param verif
	 *            验证码
	 * @return
	 */
	@Deprecated
	@RequestMapping("/userLogin/verif")
	public JsonResult verif(String telNo, String verif) {
		return verifApi(telNo, verif);
	}

	@RequestMapping("/api/userLogin/toLogin")
	public JsonResult verifApi(String telNo, String verif) {
		return userSdk.verif(telNo, verif);
	}

	@Deprecated
	@RequestMapping("/userLogin/toLogin")
	public JsonResult toLogin(String code, String account, String password, HttpSession session) throws Exception {
		return toLoginApi(code, account, password, session);
	}

	/**
	 * 密码登录
	 * 
	 * @param code
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/userLogin/toLogin")
	public JsonResult toLoginApi(String code, String account, String password, HttpSession session) throws Exception {
		JsonResult json = userSdk.getLogin(account, password);
		if (json.getCode() == 200) {
			session.setAttribute(userSdk.getUserIdSessionKey(), json.getData());
		}
		return json;
	}

	@Deprecated
	@RequestMapping("/userLogin/toLoginVerif")
	public JsonResult toLoginVerif(String mobile, String verif, HttpSession session) throws Exception {
		return toLoginVerifApi(mobile, verif, session);
	}

	/**
	 * 验证码登录
	 * 
	 * @param mobile
	 * @param verif
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/userLogin/toLoginVerif")
	public JsonResult toLoginVerifApi(String mobile, String verif, HttpSession session) throws Exception {
		JsonResult json = userSdk.loginVerif(mobile, verif);
		if (json.getCode() == 200) {
			session.setAttribute(userSdk.getUserIdSessionKey(), json.getData());
		}
		return json;
	}

	@Deprecated
	@RequestMapping("/userLogin/toRegisterApp")
	public JsonResult toRegisterApp(String account, String password, HttpSession session) throws Exception {
		return toRegisterAppApi(account, password, session);
	}

	/**
	 * 注册
	 * 
	 * @param code
	 * @param account
	 * @param password
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/userLogin/toRegisterApp")
	public JsonResult toRegisterAppApi(String account, String password, HttpSession session) throws Exception {
		JsonResult json = userSdk.getRegister(account, password);
		if (json.getCode() == 200) {
			long re = NumberUtils.toLong(json.getData() + StringUtils.EMPTY);
			if (re > 0) {
				// 注册成功后userId写入session
				session.setAttribute(userSdk.getUserIdSessionKey(), re);
			}
		}
		return json;
	}

	@Deprecated
	@RequestMapping("/userLogin/toResetPasswordApp")
	public JsonResult toResetPasswordApp(String account, String oldPassword, String newPassword) throws Exception {
		return toResetPasswordAppApi(account, oldPassword, newPassword);
	}

	/**
	 * 重置密码
	 * 
	 * @param code
	 * @param account
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/userLogin/toResetPasswordApp")
	public JsonResult toResetPasswordAppApi(String account, String oldPassword, String newPassword) throws Exception {
		return userSdk.getResetPassword(account, oldPassword, newPassword);
	}

	@Deprecated
	@RequestMapping("/userLogin/toFindPasswordApp")
	public JsonResult toFindPasswordApp(String code, String account, String newPassword) throws Exception {
		return toFindPasswordAppApi(account, newPassword);
	}

	/**
	 * 找回密码
	 * 
	 * @param code
	 * @param account
	 * @param newPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/api/userLogin/toFindPasswordApp")
	public JsonResult toFindPasswordAppApi(String account, String newPassword) throws Exception {
		return userSdk.getFindPassword(account, newPassword);
	}

	@Deprecated
	@RequestMapping("/userLogin/getMobileByUserId")
	public JsonResult getMobileByUserId(long userId) {
		return getMobileApi(userId);
	}

	/**
	 * 通过userId获取手机号
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/api/userLogin/getMobileByUserId")
	public JsonResult getMobileApi(long userId) {
		return userSdk.getMobile(userId);
	}

	@Deprecated
	@RequestMapping("/userLogin/updateName")
	public JsonResult updateName(String name, long userId) {
		return updateNameApi(name, userId);
	}

	@RequestMapping("/userLogin/getMobileByUserId")
	public JsonResult updateNameApi(String name, long userId) {
		return userSdk.updateName(name, userId);
	}

	@Deprecated
	@RequestMapping("/userLogin/updateHeadPic")
	public JsonResult updateHeadPic(String headPic, long userId) {
		return updateHeadPicApi(headPic, userId);
	}

	@RequestMapping("/userLogin/getMobileByUserId")
	public JsonResult updateHeadPicApi(String headPic, long userId) {
		return userSdk.updateHeadPic(headPic, userId);
	}

}
