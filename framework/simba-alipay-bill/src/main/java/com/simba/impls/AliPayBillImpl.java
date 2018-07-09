package com.simba.impls;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.simba.alipay.controller.form.AliPayCallbackForm;
import com.simba.alipay.controller.form.AliPayCancelForm;
import com.simba.alipay.controller.form.AliPayCloseForm;
import com.simba.alipay.controller.form.AliPayRefundForm;
import com.simba.alipay.controller.form.AppPayForm;
import com.simba.alipay.enums.TradeStatus;
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

	@Value("${alipay.appid}")
	private String appId;

	@Override
	public void dealCallback(AliPayCallbackForm callbackForm) {
		String outTradeNo = callbackForm.getOut_trade_no();
		AliPayBill bill = aliPayBillService.getBy("outTradeNo", outTradeNo);
		bill.setStatus(callbackForm.getTrade_status());
		bill.setTradeNo(callbackForm.getTrade_no());
		bill.setSellId(callbackForm.getSeller_id());
		aliPayBillService.update(bill);
	}

	@Override
	public void appPay(AppPayForm payForm) {
		AliPayBill bill = new AliPayBill();
		bill.setAppid(appId);
		bill.setBody(payForm.getBody());
		bill.setTotalAmount(payForm.getTotalAmount());
		bill.setSubject(payForm.getSubject());
		bill.setOutTradeNo(payForm.getOutTradeNo());
		bill.setProductCode(payForm.getProductCode());
		bill.setGoodType(StringUtils.EMPTY);
		bill.setTradeNo(StringUtils.EMPTY);
		bill.setSellId(StringUtils.EMPTY);
		bill.setTimeoutExpress(StringUtils.defaultString(payForm.getTimeoutExpress()));
		bill.setCreateTime(new Date());
		bill.setStatus(TradeStatus.PAY.getName());
		bill.setStoreId(StringUtils.EMPTY);
		aliPayBillService.add(bill);
	}

	@Override
	public void close(AliPayCloseForm closeForm) {
		String outTradeNo = closeForm.getOutTradeNo();
		AliPayBill bill = aliPayBillService.getBy("outTradeNo", outTradeNo);
		bill.setStatus(TradeStatus.CLOSED.getName());
		aliPayBillService.update(bill);
	}

	@Override
	public void cancel(AliPayCancelForm cancelForm) {
		String outTradeNo = cancelForm.getOutTradeNo();
		AliPayBill bill = aliPayBillService.getBy("outTradeNo", outTradeNo);
		bill.setStatus(TradeStatus.CLOSED.getName());
		aliPayBillService.update(bill);
	}

	@Override
	public void refund(AliPayRefundForm refundForm) {
		String outTradeNo = refundForm.getOutTradeNo();
		AliPayBill bill = aliPayBillService.getBy("outTradeNo", outTradeNo);
		bill.setStatus(TradeStatus.REFUND.getName());
		aliPayBillService.update(bill);
	}

}