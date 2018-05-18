package com.simba.interfaces;

import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;

/**
 * 微信支付需要实现的接口
 * 
 * @author caozhejun
 *
 */
public abstract class PayInterface {

	/**
	 * 处理支付通知结果
	 * 
	 * @param payResult
	 */
	protected abstract void dealResult(PayResult payResult);

	/**
	 * 处理订单
	 * 
	 * @param req
	 */
	protected abstract void dealOrder(UnifiedOrderReq req);

	/**
	 * 更新订单支付结果
	 * 
	 * @param payResult
	 */
	public void updateResult(PayResult payResult) {
		// 更新订单信息
		dealResult(payResult);
	}

	/**
	 * 创建订单
	 * 
	 * @param req
	 */
	public void create(UnifiedOrderReq req) {
		// 插入订单信息
		dealOrder(req);
	}
}
