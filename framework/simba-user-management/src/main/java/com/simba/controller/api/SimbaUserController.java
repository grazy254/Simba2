package com.simba.controller.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.cache.RedisUtil;
import com.simba.exception.BussException;
import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.UserProject;
import com.simba.service.SmartUserService;
import com.simba.service.UserProjectService;

/**
 * 用户登录
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping("/api/simbaUser")
public class SimbaUserController {

	@Autowired
	private SmartUserService smartUserService;

	@Autowired
	private UserProjectService projectService;

	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 检查账号是否重复
	 * 
	 * @param account
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isRepeatAccount")
	public JsonResult isRepeatAccount(String account) {
		if (smartUserService.countBy("account", account) > 0) {
			throw new BussException("账户重复");
		}
		return new JsonResult("账户不重复");
	}

	/**
	 * 检查邮箱是否已经注册过
	 * 
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/isRepeatEmail")
	public JsonResult isRepeatEmail(String email) {
		if (smartUserService.countBy("email", email) > 0) {
			throw new BussException("邮箱已被注册");
		}
		return new JsonResult("邮箱可用");
	}

	/**
	 * 重置密码
	 * 
	 * @param account
	 * @param password
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/toResetPassword")
	public JsonResult toResetPassword(String account, String password, String token) throws Exception {
		String sk = null;
		List<UserProject> projects = projectService.listBy("code", "user");
		if (projects.size() > 0) {
			sk = projects.get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		String a = (String) redisUtil.get(account);
		if (a == null) {
			throw new BussException("redis获取数据失败");
		}
		if (a.equals(token)) {
			// 密码先解密后md5
			String p = DesUtil.decrypt(password, sk);
			p = EncryptUtil.md5(p);
			// 验证通过 重置密码
			if (!smartUserService.updatePassword(account, p)) {
				throw new BussException("修改密码失败");
			}
		} else {
			throw new BussException("邮箱token验证失败");
		}
		return new JsonResult();

	}

	@ResponseBody
	@RequestMapping("/toLogin")
	public JsonResult toLogin(String code, String account, String password, HttpSession session) throws Exception {
		JsonResult json = smartUserService.toLogin(code, account, password);
		if (json.getCode() == 200) {
			session.setAttribute("userId", json.getData());
			return new JsonResult(json.getData(), "登录成功", 200);
		} else {
			return new JsonResult(json.getData(), "登录失败", 400);
		}
	}

	@ResponseBody
	@RequestMapping("/toLoginVerif")
	public JsonResult toLoginVerif(String mobile, String verif, HttpSession session) throws Exception {
		// 验证短信验证码
		if (!verif(mobile, verif)) {
			throw new BussException("短信验证码错误");
		}
		JsonResult json = smartUserService.toLoginVerif(mobile);
		if (json.getCode() == 200) {
			session.setAttribute("userId", json.getData());
			return new JsonResult(json.getData(), "登录成功", 200);
		} else {
			return new JsonResult(json.getData(), "登录失败", 400);
		}
	}

	@ResponseBody
	@RequestMapping("/toRegisterApp")
	public JsonResult toRegisterApp(String code, String account, String password, HttpSession session) throws Exception {
		JsonResult json = smartUserService.toRegisterApp(code, account, password);
		if (json.getCode() == 200) {
			int re = Integer.parseInt(json.getData().toString());
			if (re > 0) {
				// 注册成功后userId写入session
				session.setAttribute("userId", re);
			}
			return new JsonResult(json.getData(), "注册成功", 200);
		} else {
			return json;
		}
	}

	@ResponseBody
	@RequestMapping("/toResetPasswordApp")
	public JsonResult toResetPasswordApp(String code, String account, String oldPassword, String newPassword) throws Exception {
		return smartUserService.toResetPasswordApp(code, account, oldPassword, newPassword);
	}

	@ResponseBody
	@RequestMapping("/toResetPasswordWithUserIdApp")
	public JsonResult toResetPasswordWithUserIdApp(String code, long userId, String oldPassword, String newPassword) throws Exception {
		return smartUserService.toResetPasswordWithUserIdApp(code, userId, oldPassword, newPassword);
	}

	@ResponseBody
	@RequestMapping("/toFindPasswordApp")
	public JsonResult toFindPasswordApp(String code, String account, String newPassword) throws Exception {
		return smartUserService.toFindPasswordApp(code, account, newPassword);
	}

	@ResponseBody
	@RequestMapping("/getMobileByUserId")
	public JsonResult getMobileByUserId(long userId) {
		return smartUserService.getMobileByUserId(userId);
	}

	@ResponseBody
	@RequestMapping("/updateName")
	public JsonResult updateName(String name, long userId) {
		return smartUserService.updateName(name, userId);
	}

	@ResponseBody
	@RequestMapping("/updateHeadPic")
	public JsonResult updateHeadPic(String headPic, long userId) {
		return smartUserService.updateHeadPic(headPic, userId);
	}

	@ResponseBody
	@RequestMapping("/verif")
	public JsonResult verifMobile(String telNo, String verif) {
		if (verif.equals(redisUtil.get(telNo))) {
			return new JsonResult("验证码不正确", 400);
		}
		return new JsonResult();
	}

	private boolean verif(String telNo, String verif) {
		boolean isVerif = false;
		if (verif.equals(redisUtil.get(telNo))) {
			isVerif = true;
		}
		return isVerif;
	}
}
