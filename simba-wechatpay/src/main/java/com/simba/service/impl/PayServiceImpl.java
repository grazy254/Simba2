package com.simba.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.interfaces.PayInterface;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.service.PayService;
import com.simba.util.send.WxPayUtil;

/**
 * 微信支付业务实现类
 * 
 * @author caozhejun
 *
 */
@Service
@Transactional
public class PayServiceImpl implements PayService {

	private static final Log logger = LogFactory.getLog(PayServiceImpl.class);

	@Autowired
	private WxPayUtil wxPayUtil;

	@Override
	public void dealResult(PayResult payResult) {
		List<PayInterface> pays = this.getPayImpls();
		if (pays == null || pays.isEmpty()) {
			logger.warn("微信支付业务没有实现类");
			return;
		}
		pays.forEach((PayInterface pay) -> {
			pay.dealResult(payResult);
		});
	}

	@Override
	public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
		List<PayInterface> pays = this.getPayImpls();
		if (pays == null || pays.isEmpty()) {
			logger.warn("微信支付业务没有实现类");
			return;
		}
		pays.forEach((PayInterface pay) -> {
			pay.dealOrder(req, prePayId, codeUrl, mwebUrl);
		});
	}

	private List<PayInterface> getPayImpls() {
		return ApplicationContextUtil.getBeansOfType(PayInterface.class);
	}

	@Override
	public void closeOrder(String outTradeNo) {
		List<PayInterface> pays = this.getPayImpls();
		if (pays != null && !pays.isEmpty()) {
			pays.forEach((PayInterface pay) -> {
				pay.close(outTradeNo);
			});
		}
		wxPayUtil.closeOrder(outTradeNo);
	}

	@Override
	public void refund(RefundReq refundReq) throws ParseException, IOException {
		List<PayInterface> pays = this.getPayImpls();
		if (pays != null && !pays.isEmpty()) {
			pays.forEach((PayInterface pay) -> {
				pay.refund(refundReq);
			});
		}
		wxPayUtil.refund(refundReq);
	}
}
