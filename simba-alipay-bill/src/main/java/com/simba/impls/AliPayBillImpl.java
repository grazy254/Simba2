package com.simba.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.alipay.service.AliPayService;

/**
 * 阿里支付账单的实现类
 * 
 * @author caozhejun
 *
 */
@Component
public class AliPayBillImpl implements AliPayInterface {

	@Autowired
	private AliPayService aliPayService;

	@Override
	public void dealCallback(AliPayCallbackForm callbackForm) {

	}

	@Override
	public void appPay(AppPayForm payForm) {

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
