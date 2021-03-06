package com.simba.impls;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.interfaces.PayInterface;
import com.simba.model.PayBill;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
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
		PayBill bill = payBillService.getBy("outTradeNo", payResult.getOut_trade_no());
		if (payResult.getResult_code().equals("SUCCESS") && payResult.getReturn_code().equals("SUCCESS")) {
			bill.setStatus("SUCCESS");
		} else {
			bill.setStatus("PAYERROR");
			bill.setErrMsg(payResult.getErr_code_des());
		}
		bill.setOpenid(payResult.getOpenid());
		payBillService.update(bill);
	}

	@Override
	public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
		PayBill bill = new PayBill();
		bill.setAppid(req.getAppid());
		bill.setMchId(req.getMch_id());
		bill.setDeviceInfo(StringUtils.defaultString(req.getDevice_info()));
		bill.setProductDesc(req.getBody());
		bill.setDetail(StringUtils.defaultString(req.getDetail()));
		bill.setAttach(StringUtils.defaultString(req.getAttach()));
		bill.setOutTradeNo(req.getOut_trade_no());
		bill.setFee(req.getTotal_fee());
		bill.setClientIp(req.getSpbill_create_ip());
		bill.setStartTime(StringUtils.defaultString(req.getTime_start()));
		bill.setEndTime(StringUtils.defaultString(req.getTime_expire()));
		bill.setGoodsTag(StringUtils.defaultString(req.getGoods_tag()));
		bill.setNotifyUrl(req.getNotify_url());
		bill.setTradeType(req.getTrade_type());
		bill.setProductId(req.getProduct_id());
		bill.setOpenid(StringUtils.defaultString(req.getOpenid()));
		bill.setStatus("NOTPAY");
		bill.setCreateTime(new Date());
		bill.setPrepayId(StringUtils.defaultString(prePayId));
		bill.setCodeUrl(StringUtils.defaultString(codeUrl));
		bill.setMwebUrl(StringUtils.defaultString(mwebUrl));
		payBillService.add(bill);
	}

	@Override
	public void close(String outTradeNo) {
		PayBill bill = payBillService.getBy("outTradeNo", outTradeNo);
		bill.setStatus("CLOSED");
		payBillService.update(bill);
	}

	@Override
	public void refund(RefundReq refundReq) {
		PayBill bill = payBillService.getBy("outTradeNo", refundReq.getOut_trade_no());
		bill.setStatus("REFUND");
		bill.setAttach(bill.getAttach() + "(退款金额:" + refundReq.getRefund_fee() + "分)");
		payBillService.update(bill);
	}

	@Override
	public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
		PayBill bill = payBillService.getBy("outTradeNo", callbackInfo.getOut_trade_no());
		String status = callbackInfo.getRefund_status();
		if ("SUCCESS".equals(status)) {
			bill.setStatus("REVOKED");
		} else {
			bill.setStatus("SUCCESS");
		}
		payBillService.update(bill);
	}

}
