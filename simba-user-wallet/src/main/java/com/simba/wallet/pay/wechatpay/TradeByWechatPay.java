package com.simba.wallet.pay.wechatpay;

import com.simba.interfaces.PayInterface;
import com.simba.model.pay.refund.RefundReq;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.result.RefundCallbackInfo;
import com.simba.model.pay.result.RefundResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;

public class TradeByWechatPay implements PayInterface {

	@Override
	public void dealResult(PayResult payResult) {
		//======修改的数据(针对充值操作)======
		//普通用户的TradeAccount
			//AccountBalance = AccountBalance
			//FrozonBalance  = ${changedAmount}
			//AvaliableBalance = AvaliableBalance

		//收费部门的TradeAccount
			//AccountBalance = AccountBalance
			//FrozonBalance  = ${changedAmount}
			//AvaliableBalance = AvaliableBalance
		//渠道的TradeAccount
	}

	

	@Override
	public void dealOrder(UnifiedOrderReq req, String prePayId, String codeUrl, String mwebUrl) {
		
	}

	@Override
	public void close(String outTradeNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refund(RefundReq refundReq) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dealRefundCallback(RefundResult refundResult, RefundCallbackInfo callbackInfo) {
		// TODO Auto-generated method stub

	}

}
