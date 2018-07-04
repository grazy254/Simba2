package com.simba.controller;

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
@RequestMapping("/userLogin")
public class UserLoginController {
	private static final Log logger = LogFactory.getLog(UserLoginController.class);

	@Value("${appID}")
	private String appid;

	@Autowired
	private SmartUserService smartUserService;

	@Autowired
	private UserProjectService projectService;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private RedisUtil redisUtil;
	

	@RequestMapping("/login")
	public String login() {
		return "userLogin/login";
	}

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
	@RequestMapping("/toRegister")
	public JsonResult toRegister(String account, String email, String mobilephone, String nickname, String password, HttpSession session) throws Exception {
		SmartUser user = new SmartUser();
		user.setAccount(account);
		user.setEmail(email);
		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(mobilephone);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		user.setTelNo(mobilephone);
		user.setName(nickname);
		// 给密码解密之后再md5。
		String sk = "";
		if (projectService.listBy("code", "user").size() > 0) {
			sk = projectService.listBy("code", "user").get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		String p = "";
		p = DesUtil.decrypt(password, sk);
		p = EncryptUtil.md5(p);
		user.setPassword(p);
		long re = smartUserService.addRegister(user);
		if (re > 0) {
			// 注册成功后userId写入session
			session.setAttribute("userId", re);
		} else {
			throw new BussException("数据插入失败");
		}
		return new JsonResult("", "数据插入成功", 200);
	}

	// 检查账号是否重复
	@ResponseBody
	@RequestMapping("/isRepeatAccount")
	public JsonResult isRepeatAccount(String account) {
		List<SmartUser> ulist = smartUserService.listBy("account", account);
		if (ulist.size() > 0) {
			throw new BussException("账户重复");
		}
		return new JsonResult("", "账户不重复", 200);
	}

	// 检查邮箱是否已经注册过
	@ResponseBody
	@RequestMapping("/isRepeatEmail")
	public JsonResult isRepeatEmail(String email) {
		List<SmartUser> ulist = smartUserService.listBy("email", email);

		if (ulist.size() > 0) {
			throw new BussException("邮箱已被注册");
		}
		return new JsonResult("", "邮箱可用", 200);
	}

	@RequestMapping("/findPassword")
	public String findPassword() {
		return "userLogin/findPassword";
	}

	// 发送找回密码的邮件
	@ResponseBody
	@RequestMapping("/sendEmail")
	public JsonResult sendEmail(String email, HttpServletResponse response) {
		// 通过email找到account
		List<SmartUser> ulist = smartUserService.listBy("email", email);
		if (ulist.size() == 0) {
			throw new BussException("邮箱没有被注册");
		} else {
			String account = ulist.get(0).getAccount();
			String token = "UT" + Long.toString(System.currentTimeMillis() / 999999) + "YANZHEN";
			String text = "亲爱的用户你好，系统为了您方便找回登录密码，发送此邮件给您。您只需要点击邮件中提供的地址即可重置自己的密码。找回密码地址：http://127.0.0.1:8401/login/resetPassword?account= " + account + "&token=" + token;
			emailUtil.send(email, "来自：优特统一用户管理系统发送。密码找回邮件", text);
			redisUtil.set(account, token, 600);
		}
		return new JsonResult("", "发送成功", 200);
	}

	@RequestMapping("/resetPassword")
	public String resetPassword(String account, String token, ModelMap model) {
		model.put("account", account);
		model.put("token", token);
		return "userLogin/resetPassword";
	}

	@ResponseBody
	@RequestMapping("/toResetPassword")
	public JsonResult toResetPassword(String account, String password, String token) throws Exception {
		String a = "";
		a = (String) redisUtil.get(account);
		String sk = "";
		if (projectService.listBy("code", "user").size() > 0) {
			sk = projectService.listBy("code", "user").get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		if (a == null) {
			throw new BussException("redis获取数据失败");
		} else {
			if (a.equals(token)) {
				// 密码先解密后md5
				String p = "";
				p = DesUtil.decrypt(password, sk);
				p = EncryptUtil.md5(p);
				// 验证通过 重置密码
				if (!smartUserService.updatePassword(account, p)) {
					throw new BussException("修改失败");
				}
			} else {
				throw new BussException("邮箱token验证失败");
			}
		}
		return new JsonResult();
	}

	@RequestMapping("/weiboLogin")
	public String weiboLogin() {
		return "weibo.com";
	}

	@RequestMapping("/qqLogin")
	public String qqLogin() {
		return "qq.com";
	}

	@ResponseBody
	@RequestMapping("/weixinLogin")
	public JsonResult weixinLogin() {
		String redirectUri = "www.baidu.com";
		String code = "code";
		String scope = "snsapi_login";
		String state = "";
		String url = "";
		url = "https://open.weixin.qq.com/connect/qrconnect?appid=" + appid + "&redirect_uri=" + redirectUri + "&response_type=" + code + "&scope=" + scope + "&state=" + state + "#wechat_redirect";
		return new JsonResult(url, "返回成功", 200);
	}
	
	
	

	/////////////////////////////////////////////////////// APP相关接口开始/////////////////////////////////////////////////////////////
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

	@RequestMapping("/register")
	public String register() {
		return "userLogin/register";
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

	/////////////////////////////////////////////////////// APP相关接口结束/////////////////////////////////////////////////////////////

	
	
	

}
