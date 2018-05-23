package com.simba.alipay.controller;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.service.AliPayService;
import com.simba.alipay.util.AliPayUtil;
import com.simba.framework.util.common.BeanUtils;

/**
 * 阿里支付异步回调Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/alipay")
public class AliPayCallbackController {

	private static final Log logger = LogFactory.getLog(AliPayCallbackController.class);

	@Autowired
	private AliPayUtil aliPayUtil;

	@Autowired
	private AliPayService aliPayService;

	/**
	 * 回调处理方法
	 * 
	 * @param callbackForm
	 * @return
	 * @throws AlipayApiException
	 */
	@PostMapping("/callback")
	public String callback(AliPayCallbackForm callbackForm) throws AlipayApiException {
		logger.info("================================接收到阿里支付的回调:" + callbackForm.toString());
		checkSign(callbackForm);
		deal(callbackForm);
		return "success";
	}

	/**
	 * 处理回调数据
	 * 
	 * @param callbackForm
	 */
	private void deal(AliPayCallbackForm callbackForm) {
		aliPayService.dealCallback(callbackForm);
	}

	/**
	 * 检查签名
	 * 
	 * @param callbackForm
	 * @throws AlipayApiException
	 */
	private void checkSign(AliPayCallbackForm callbackForm) throws AlipayApiException {
		Map<String, String> params = BeanUtils.xmlBean2Map(callbackForm);
		aliPayUtil.checkSign(params);
	}
}
