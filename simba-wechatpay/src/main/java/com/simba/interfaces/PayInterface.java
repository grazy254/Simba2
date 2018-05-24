package com.simba.interfaces;

import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;

/**
 * 微信支付需要实现的接口
 * 
 * @author caozhejun
 *
 */
public interface PayInterface {

	/**
	 * 处理支付通知结果
	 * 
	 * @param payResult
	 */
	void dealResult(PayResult payResult);

	/**
	 * 处理订单
	 * 
	 * @param req
	 * @param prePayId
	 * @param codeUrl
	 * @param mwebUrl
	 */
	void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl);

	/**
	 * 关闭订单
	 * 
	 * @param outTradeNo
	 */
	void close(String outTradeNo);

	/**
	 * 申请退款
	 * 
	 * @param refundReq
	 */
	void refund(RefundReq refundReq);

	/**
	 * 处理退款结果通知
	 * 
	 * @param refundResult
	 * @param callbackInfo
	 */
	void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo);
}
