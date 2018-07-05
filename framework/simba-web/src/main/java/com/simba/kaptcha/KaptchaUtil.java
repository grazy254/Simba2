package com.simba.kaptcha;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

/**
 * 验证码检查工具类
 * 
 * @author caozhejun
 *
 */
public class KaptchaUtil {

	/**
	 * 校验验证码是否正确
	 * 
	 * @param session
	 * @param kaptcha
	 * @return
	 */
	public static boolean check(HttpSession session, String kaptcha) {
		String storeKaptcha = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		return StringUtils.equals(kaptcha, storeKaptcha);
	}
}
