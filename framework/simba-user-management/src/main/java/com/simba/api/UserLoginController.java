package com.simba.api;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.cache.RedisUtil;
import com.simba.exception.BussException;
import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.service.SmartUserService;
import com.simba.service.UserProjectService;
import com.simba.util.EmailUtil;

/**
 * 用户登录
 * 
 * @author lilei
 * 
 */
@Controller
@RequestMapping("/api/userLogin")
public class UserLoginController {
	private static final Log logger = LogFactory.getLog(UserLoginController.class);

	@Value("${appID}")
	private String appid;

	@Autowired
	private SmartUserService smartUserService;

	@Autowired
	private RedisUtil redisUtil;
	

	@RequestMapping("/verif")
	public boolean verif(String telNo, String verif) {
		boolean isVerif = false;
		if (redisUtil.get(telNo) == verif) {
			isVerif = true;
		} else {
			isVerif = false;
		}
		return isVerif;
	}

	@ResponseBody
	@RequestMapping("/toLogin")
	public JsonResult toLogin(String code, String account, String password, HttpSession session) throws Exception {
		JsonResult json=smartUserService.toLogin(code, account, password);
		if(json.getCode()==200){
			session.setAttribute("userId",json.getData());
			return new JsonResult("登录成功",200);
		}else{
			return new JsonResult("登录失败",400);
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/toLoginVerif")
	public JsonResult toLoginVerif(String mobile, String verif, HttpSession session) throws Exception {
		//验证短信验证码
		if(!verif(mobile,verif)){
			throw new BussException("短信验证码错误");
		}
		JsonResult json=smartUserService.toLoginVerif(mobile);
		if(json.getCode()==200){
			session.setAttribute("userId",json.getData());
			return new JsonResult("登录成功",200);
		}else{
			return new JsonResult("登录失败",400);
		}
	}

	@ResponseBody
	@RequestMapping("/toRegisterApp")
	public JsonResult toRegisterApp(String code, String account, String password, HttpSession session) throws Exception {
		JsonResult json =new JsonResult();
		json = smartUserService.toRegisterApp(code, account, password);
		if(json.getCode()==200){
			int re =Integer.parseInt(json.getData().toString());
			if (re > 0) {
				// 注册成功后userId写入session
				session.setAttribute("userId", re);
			}
			return new JsonResult("注册成功",200);
		}else{
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
}
