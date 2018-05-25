package com.simba.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.model.AliPayBill;
import com.simba.service.AliPayBillService;

/**
 * 阿里支付账单的实现类
 * 
 * @author caozhejun
 *
 */
@Component
public class AliPayBillImpl implements AliPayInterface {

	@Autowired
	private AliPayBillService aliPayBillService;

	@Override
	public void dealCallback(AliPayCallbackForm callbackForm) {

	}

	@Override
	public void appPay(AppPayForm payForm) {
		AliPayBill bill = new AliPayBill();

		aliPayBillService.add(bill);
	}

	@Override
	public void close(AliPayCloseForm closeForm) {

	}

	@Override
	public void cancel(AliPayCancelForm cancelForm) {

	}

	@Override
	public void refund(AliPayRefundForm refundForm) {

	}

}
