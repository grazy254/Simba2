package com.simba.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.interfaces.PayInterface;
import com.simba.model.PayBill;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.service.PayBillService;

/**
 * 处理微信支付账单
 * 
 * @author caozhejun
 *
 */
@Component
public class PayBillImpl implements PayInterface {

	@Autowired
	private PayBillService payBillService;

	@Override
	public void dealResult(PayResult payResult) {

	}

	@Override
	public void dealOrder(UnifiedOrderReq req) {
		PayBill bill = new PayBill();

		payBillService.add(bill);
	}

}
