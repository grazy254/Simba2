package com.simba.service;

import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;

/**
 * 微信支付业务接口
 * 
 * @author caozhejun
 *
 */
public interface PayService {

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
	 */
	void dealOrder(UnifiedOrderReq req);
}
