package com.simba.alipay.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.math.NumberUtils;
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
	public String callback(AliPayCallbackForm callbackForm, HttpServletRequest request) throws AlipayApiException {
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。
			params.put(name, valueStr);
		}
		logger.info("================================接收到阿里支付的回调:" + callbackForm.toString() + "*********************" + params.toString());
		checkSign(params);
		dealUnit(callbackForm);
		deal(callbackForm);
		return "success";
	}
	
	/**
	 * 价格单位统一成分
	 * 
	 * @param callbackForm
	 */
	private void dealUnit(AliPayCallbackForm callbackForm) {
		String total_amount = callbackForm.getTotal_amount();
		String refund_fee = callbackForm.getRefund_fee();
		callbackForm.setTotal_amount(converter(total_amount));
		callbackForm.setRefund_fee(converter(refund_fee));
	}

	private String converter(String money) {
		double fee = NumberUtils.toDouble(money);
		double fen = fee * 100;
		int zfen = Integer.parseInt(new java.text.DecimalFormat("0").format(fen));
		return zfen + "";
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
	 * @param params
	 * @throws AlipayApiException
	 */
	private void checkSign(Map<String, String> params) throws AlipayApiException {
		aliPayUtil.checkSign(params);
	}
}
