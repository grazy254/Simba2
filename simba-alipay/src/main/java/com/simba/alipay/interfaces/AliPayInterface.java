package com.simba.alipay.interfaces;

import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AppPayForm;

/**
 * 阿里支付留给业务实现的接口
 * 
 * @author caozhejun
 *
 */
public interface AliPayInterface {

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
	void appPay(AppPayForm payForm);

	/**
	 * 关闭订单
	 * 
	 * @param closeForm
	 */
	void close(AliPayCloseForm closeForm);

	/**
	 * 撤销订单
	 * 
	 * @param cancelForm
	 */
	void cancel(AliPayCancelForm cancelForm);
}
