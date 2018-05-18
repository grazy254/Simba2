package com.simba.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.interfaces.PayInterface;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.service.PayService;

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
}
