package com.simba.wallet.pay.wechatpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simba.interfaces.PayInterface;
import com.simba.model.PayBill;
import com.simba.model.pay.result.PayResult;
import com.simba.model.pay.unifiedorder.UnifiedOrderReq;
import com.simba.service.PayBillService;

public class WechatPay implements PayInterface{

	@Autowired
	private PayBillService payBillService;
	
	@Override
	public void dealResult(PayResult payResult) {
		PayBill payBill = new PayBill();
		payBillService.update(payBill);
		
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
	@Transactional
	public void dealOrder(UnifiedOrderReq req) {
		PayBill payBill = new PayBill();
		payBillService.add(payBill);
		
	
		
	}

}
