package com.simba.kaptcha;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.framework.util.json.JsonResult;

/**
 * 验证码校验Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/kaptcha")
public class KaptchaController {

	@RequestMapping("/check")
	public JsonResult check(String kaptcha, HttpSession session) {
		return new JsonResult(KaptchaUtil.check(session, kaptcha));
	}

}
