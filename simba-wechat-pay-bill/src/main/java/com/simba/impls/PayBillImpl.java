package com.simba.impls;

import org.springframework.stereotype.Component;

import com.simba.interfaces.PayInterface;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;

/**
 * 处理微信支付账单
 * 
 * @author caozhejun
 *
 */
@Component
public class PayBillImpl implements PayInterface {

	@Override
	public void dealResult(PayResult payResult) {

	}

	@Override
	public void dealOrder(UnifiedOrderReq req) {

	}

}
