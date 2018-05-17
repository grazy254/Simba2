package com.simba.alipay.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.alipay.controller.form.AliPayCallbackForm;

/**
 * 阿里支付异步回调Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/alipay")
public class AliPayCallbackController {

	/**
	 * 回调处理方法
	 * 
	 * @param callbackForm
	 * @return
	 */
	@PostMapping("/callback")
	public String callback(AliPayCallbackForm callbackForm) {

		return "success";
	}
}
