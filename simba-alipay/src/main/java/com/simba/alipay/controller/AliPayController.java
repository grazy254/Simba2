package com.simba.alipay.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alipay.api.AlipayApiException;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.service.AliPayService;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 阿里支付Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/aliPay")
public class AliPayController {

	private static final Log logger = LogFactory.getLog(AliPayController.class);

	@Autowired
	private AliPayService aliPayService;

	/**
	 * 生成APP支付订单
	 * 
	 * @param payForm
	 * @return
	 * @throws AlipayApiException
	 */
	@RequestMapping("/appPay")
	public JsonResult appPay(AppPayForm payForm) throws AlipayApiException {
		logger.info("收到[支付订单]信息:" + payForm.toString());
		String totalAmount = payForm.getTotalAmount();
		int amountFen = NumberUtils.toInt(totalAmount);
		double amountYuan = amountFen * 1.0 / 100;
		payForm.setTotalAmount(amountYuan + "");
		payForm.setOutTradeNo(RandomUtil.random32Chars());
		String result = aliPayService.appPay(payForm);
		return new JsonResult(result);
	}

	/**
	 * 关闭订单
	 * 
	 * @param closeForm
	 * @return
	 */
	@RequestMapping("/close")
	public JsonResult close(AliPayCloseForm closeForm) throws AlipayApiException {
		logger.info("收到[关闭订单]信息:" + closeForm.toString());
		aliPayService.close(closeForm);
		return new JsonResult();
	}

	/**
	 * 撤销订单
	 * 
	 * @param cancelForm
	 * @return
	 * @throws AlipayApiException
	 */
	@RequestMapping("/cancel")
	public JsonResult cancel(AliPayCancelForm cancelForm) throws AlipayApiException {
		logger.info("收到[撤销订单]信息:" + cancelForm.toString());
		aliPayService.cancel(cancelForm);
		return new JsonResult();
	}

	/**
	 * 退款
	 * 
	 * @param refundForm
	 * @return
	 * @throws AlipayApiException
	 */
	@RequestMapping("/refund")
	public JsonResult refund(AliPayRefundForm refundForm) throws AlipayApiException {
		logger.info("收到[退款]信息:" + refundForm.toString());
		aliPayService.refund(refundForm);
		return new JsonResult();
	}

}
