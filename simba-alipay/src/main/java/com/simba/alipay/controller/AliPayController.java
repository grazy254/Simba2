package com.simba.alipay.controller;

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
	@RequestMapping("close")
	public JsonResult close(AliPayCloseForm closeForm) throws AlipayApiException {
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
	@RequestMapping("cancel")
	public JsonResult cancel(AliPayCancelForm cancelForm) throws AlipayApiException {
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
		aliPayService.refund(refundForm);
		return new JsonResult();
	}

}
