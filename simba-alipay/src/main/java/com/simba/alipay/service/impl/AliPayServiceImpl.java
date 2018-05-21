package com.simba.alipay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alipay.api.AlipayApiException;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.alipay.service.AliPayService;
import com.simba.alipay.util.AliPayUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;

/**
 * 阿里支付业务实现类
 * 
 * @author caozhejun
 *
 */
@Service
@Transactional
public class AliPayServiceImpl implements AliPayService {

	@Autowired
	private AliPayUtil aliPayUtil;

	@Override
	public void dealCallback(AliPayCallbackForm callbackForm) {
		List<AliPayInterface> impls = getImpls();
		if (impls != null && !impls.isEmpty()) {
			impls.forEach((AliPayInterface imp) -> {
				imp.dealCallback(callbackForm);
			});
		}
	}

	@Override
	public String appPay(AppPayForm payForm) throws AlipayApiException {
		List<AliPayInterface> impls = getImpls();
		if (impls != null && !impls.isEmpty()) {
			impls.forEach((AliPayInterface imp) -> {
				imp.appPay(payForm);
			});
		}
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody(payForm.getBody());
		model.setSubject(payForm.getSubject());
		model.setOutTradeNo(payForm.getOutTradeNo());
		model.setTimeoutExpress(payForm.getTimeoutExpress());
		model.setTotalAmount(payForm.getTotalAmount());
		model.setProductCode(payForm.getProductCode());
		return aliPayUtil.appPay(model).getBody();
	}

	private List<AliPayInterface> getImpls() {
		return ApplicationContextUtil.getBeansOfType(AliPayInterface.class);
	}

	@Override
	public void close(AliPayCloseForm closeForm) throws AlipayApiException {
		List<AliPayInterface> impls = getImpls();
		if (impls != null && !impls.isEmpty()) {
			impls.forEach((AliPayInterface imp) -> {
				imp.close(closeForm);
			});
		}
		aliPayUtil.close(closeForm.getOutTradeNo(), closeForm.getTradeNo(), closeForm.getOperatorId());
	}
}
