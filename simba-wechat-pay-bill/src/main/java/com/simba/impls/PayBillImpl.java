package com.simba.impls;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.interfaces.PayInterface;
import com.simba.model.PayBill;
import com.simba.model.pay.refund.RefundReq;
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
		PayBill bill = payBillService.getBy("outTradeNo", payResult.getOut_trade_no());
		bill.setCreateTime(new Date());
		if (payResult.getResult_code().equals("SUCCESS") && payResult.getReturn_code().equals("SUCCESS")) {
			bill.setStatus("SUCCESS");
		} else {
			bill.setStatus("PAYERROR");
			bill.setErrMsg(payResult.getErr_code_des());
		}
		payBillService.update(bill);
	}

	@Override
	public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
		PayBill bill = new PayBill();
		bill.setAppid(req.getAppid());
		bill.setMchId(req.getMch_id());
		bill.setDeviceInfo(req.getDevice_info());
		bill.setProductDesc(req.getBody());
		bill.setDetail(req.getDetail());
		bill.setAttach(req.getAttach());
		bill.setOutTradeNo(req.getOut_trade_no());
		bill.setFee(req.getTotal_fee());
		bill.setClientIp(req.getSpbill_create_ip());
		bill.setStartTime(req.getTime_start());
		bill.setEndTime(req.getTime_expire());
		bill.setGoodsTag(req.getGoods_tag());
		bill.setNotifyUrl(req.getNotify_url());
		bill.setTradeType(req.getTrade_type());
		bill.setProductId(req.getProduct_id());
		bill.setOpenid(req.getOpenid());
		bill.setStatus("NOTPAY");
		bill.setCreateTime(new Date());
		bill.setPrepayId(prePayId);
		bill.setCodeUrl(StringUtils.defaultString(codeUrl));
		bill.setMwebUrl(StringUtils.defaultString(mwebUrl));
		payBillService.add(bill);
	}

	@Override
	public void close(String outTradeNo) {
		PayBill bill = payBillService.getBy("outTradeNo", outTradeNo);
		bill.setCreateTime(new Date());
		bill.setStatus("CLOSED");
		payBillService.update(bill);
	}

	@Override
	public void refund(RefundReq refundReq) {
		PayBill bill = payBillService.getBy("outTradeNo", refundReq.getOut_trade_no());
		bill.setCreateTime(new Date());
		bill.setStatus("REFUND");
		bill.setAttach(bill.getAttach() + "(退款金额:" + refundReq.getRefund_fee() + "分)");
		payBillService.update(bill);
	}

}
