package com.simba.wallet.pay.alipay;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.interfaces.AliPayInterface;
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.pay.callbacktrade.CallbackTradeContext;
import com.simba.wallet.pay.callbacktrade.impl.AliRechargeTrade;
import com.simba.wallet.pay.callbacktrade.impl.AliRefundTrade;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;

/**
 * 阿里支付的业务实现类
 * 
 * @author caozhejun
 *
 */
@Component
public class TradeByAliPay implements AliPayInterface {

	private static final Log logger = LogFactory.getLog(TradeByAliPay.class);

	@Autowired
	private AliRechargeTrade rechargeTrade;

	@Autowired
	private AliRefundTrade refundTrade;

	@Autowired
	private TradeUserService tradeUserService;

	private CallbackTradeContext rechargeContext = null;
	private CallbackTradeContext refundContext = null;

	@PostConstruct
	public void init() {
		rechargeContext = new CallbackTradeContext(rechargeTrade);
		refundContext = new CallbackTradeContext(refundTrade);
	}

	@Override
	public void dealCallback(AliPayCallbackForm callbackForm) {
		logger.info(String.format("alipay recharge callback trade callbackForm : %s", callbackForm.toString()));
		logger.info("alipay recharge callback trade status: " + callbackForm.getTrade_status());
		if (com.simba.alipay.enums.TradeStatus.SUCCESS.getName().equals(callbackForm.getTrade_status())) {
			TradeUser tradeUser = tradeUserService.getByOrderNO(callbackForm.getOut_trade_no(), TradeType.RECHARGE);
			logger.info("alipay recharge callback trade user account: " + tradeUser.getUserID());
			JsonResult rs = rechargeContext.finishTrade(tradeUser.getUserID(), callbackForm.getOut_trade_no(), callbackForm.getTrade_no(), callbackForm.getBuyer_id(),
					CommonUtil.getGmtDate(callbackForm.getGmt_create()), CommonUtil.getGmtDate(callbackForm.getGmt_payment()), "", "", NumberUtils.toLong(callbackForm.getTotal_amount()),
					TradeStatus.SUCCESS);
			logger.info("alipay recharge callback trade result: " + rs.toJson());
		} else if (com.simba.alipay.enums.TradeStatus.REFUNDSUCCESS.getName().equals(callbackForm.getTrade_status()) || !Strings.isNullOrEmpty(callbackForm.getRefund_fee())) {
			TradeUser tradeUser = tradeUserService.getByOrderNO(callbackForm.getOut_trade_no(), TradeType.REFUND);
			logger.info("alipay refund callback trade user account: " + tradeUser.getUserID());
			JsonResult rs = refundContext.finishTrade(tradeUser.getUserID(), callbackForm.getOut_trade_no(), callbackForm.getTrade_no(), callbackForm.getBuyer_id(),
					CommonUtil.getGmtDate(callbackForm.getGmt_create()), CommonUtil.getGmtDate(callbackForm.getGmt_payment()), "", "", NumberUtils.toLong(callbackForm.getRefund_fee()),
					TradeStatus.SUCCESS);
			logger.info("alipay refund callback trade result: " + rs.toJson());
		}
	}

	@Override
	public void appPay(AppPayForm payForm) {
		logger.info(String.format("alipay recharge start trade AppPayForm: %s", payForm.toString()));
		// TODO:需要考虑用户中心和钱包分离的情况，通过sdk获取用户数据
		SmartUser user = (SmartUser) ThreadDataUtil.get("account");
		JsonResult rs = rechargeContext.startTrade(user.getAccount(), StringUtils.EMPTY, payForm.getOutTradeNo(), NumberUtils.toLong(payForm.getTotalAmount()));
		logger.info("alipay recharge start trade result: " + rs.toJson());

	}

	@Override
	public void close(AliPayCloseForm closeForm) {

	}

	@Override
	public void cancel(AliPayCancelForm cancelForm) {

	}

	@Override
	public void refund(AliPayRefundForm refundForm) {
		logger.info(String.format("alipay refund start trade refundForm: %s", refundForm));
		TradeUser tradeUser = tradeUserService.getByOrderNO(refundForm.getOutTradeNo(), TradeType.RECHARGE);
		logger.info("alipay refund start trade user account: " + tradeUser.getUserID());
		JsonResult rs = refundContext.startTrade(tradeUser.getUserID(), "", refundForm.getOutTradeNo(), NumberUtils.toLong(refundForm.getRefundAmount()));
		logger.info("alipay refund start trade result: " + rs.toJson());
	}

}
