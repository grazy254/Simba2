package com.simba.alipay.service;

import com.alipay.api.AlipayApiException;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AppPayForm;

/**
 * 阿里支付业务接口
 * 
 * @author caozhejun
 *
 */
public interface AliPayService {

	/**
	 * 处理支付宝支付回调的业务逻辑
	 * 
	 * @param callbackForm
	 */
	void dealCallback(AliPayCallbackForm callbackForm);

	/**
	 * 生成APP支付订单
	 * 
	 * @param payForm
	 */
	String appPay(AppPayForm payForm) throws AlipayApiException;

	/**
	 * 关闭订单
	 * 
	 * @param closeForm
	 */
	void close(AliPayCloseForm closeForm) throws AlipayApiException;

	/**
	 * 撤销订单
	 * 
	 * @param cancelForm
	 */
	void cancel(AliPayCancelForm cancelForm) throws AlipayApiException;
}
