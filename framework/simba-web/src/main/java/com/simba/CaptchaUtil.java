package com.simba;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

/**
 * 验证码工具类
 * 
 * @author caozhejun
 *
 */
public class CaptchaUtil {

	// 存在session里的验证码的标志
	public static final String captchaKey = "sessCaptcha";

	/**
	 * 设置验证码
	 * 
	 * @param session
	 * @param captcha
	 */
	public static void setCaptcha(HttpSession session, String captcha) {
		session.setAttribute(captchaKey, captcha);
	}

	/**
	 * 检查验证码是否正确
	 * 
	 * @param session
	 * @param captcha
	 * @return
	 */
	public static boolean checkCaptcha(HttpSession session, String captcha) {
		String sCaptcha = (String) session.getAttribute(captchaKey);
		return StringUtils.equalsIgnoreCase(sCaptcha, captcha);
	}
}
