package com.simba.wallet.pay.trade.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.framework.util.json.JsonResult;
import com.simba.registry.util.RegistryUtil;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeBalanceDetail;
import com.simba.wallet.pay.trade.BaseInnerTrade;
import com.simba.wallet.service.TradeBalanceDetailService;
import com.simba.wallet.util.Constants.BalanceType;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.ErrConfig;

/**
 * 购买交易
 * 
 * @author zhangfenghua
 *
 */
@Service
@Transactional
public class ConsumeTrade extends BaseInnerTrade {
	
	@Autowired
	private TradeBalanceDetailService tradeBalanceDetailService;
	
	public ConsumeTrade() {
	}

	@Override
	public void checkUserAccount(TradeAccount tradeAccount, Long amount) {
		if (tradeAccount.getFrozenBalance() != 0) {
			throw ErrConfig.EXISTING_INVALID_PAYMENT;
		}
		if (tradeAccount.getAccountBalance() < amount) {
			throw ErrConfig.NO_ENOUGH_BALANCE;
		}
	}

	@Override
	public void updateBalance(TradeAccount smartUserTradeAccount, TradeAccount departmentTradeAccount, long paymentAmount) {

		smartUserTradeAccount.setAccountBalance(smartUserTradeAccount.getAccountBalance() - paymentAmount);
		long availableBalancePart = 0; 
		long virtualBalancePart = 0;
		if (smartUserTradeAccount.getAvailableBalance() >= paymentAmount) {
			availableBalancePart = paymentAmount;
			smartUserTradeAccount.setAvailableBalance(smartUserTradeAccount.getAvailableBalance() - paymentAmount);
		} else {
			availableBalancePart = smartUserTradeAccount.getAvailableBalance();
			virtualBalancePart = paymentAmount - smartUserTradeAccount.getAvailableBalance();
			smartUserTradeAccount.setAvailableBalance(0);
			smartUserTradeAccount.setVirtualBalance(smartUserTradeAccount.getVirtualBalance() - virtualBalancePart);
		}

		departmentTradeAccount.setAccountBalance(departmentTradeAccount.getAccountBalance() + paymentAmount);
		departmentTradeAccount.setAvailableBalance(departmentTradeAccount.getAvailableBalance() + availableBalancePart);
		departmentTradeAccount.setVirtualBalance(departmentTradeAccount.getVirtualBalance() + virtualBalancePart);
	}

	@Override
	public void addTradeBalanceDetail(TradeAccount smartUserTradeAccount, long tradeNo, long paymentAmount) {
		TradeBalanceDetail tradeBalanceDetail = new TradeBalanceDetail();
		long availableBalancePart = 0; 
		long virtualBalancePart = 0;
		if (smartUserTradeAccount.getAvailableBalance() >= paymentAmount) {
			availableBalancePart = paymentAmount;
		} else {
			availableBalancePart = smartUserTradeAccount.getAvailableBalance();
			virtualBalancePart = paymentAmount - smartUserTradeAccount.getAvailableBalance();
			smartUserTradeAccount.setAvailableBalance(0);
		}

		tradeBalanceDetail.setTradeNo(tradeNo);
		if(availableBalancePart>0) {
			tradeBalanceDetail.setBalanceType(BalanceType.REALBALANCE.getValue());
			tradeBalanceDetail.setBalanceAmount(availableBalancePart);
			tradeBalanceDetailService.add(tradeBalanceDetail);
		}
		if(virtualBalancePart>0) {
			tradeBalanceDetail.setBalanceType(BalanceType.VIRTUALBALANCE.getValue());
			tradeBalanceDetail.setBalanceAmount(virtualBalancePart);
			tradeBalanceDetailService.add(tradeBalanceDetail);
		}
		
	}
	@Override
	public JsonResult trade(String userID, String ip, String location, String orderNO, String orderName, String orderDesc, String orderAddress, long originalAmount, long paymentAmount) {
		return trade(userID, ip, location, orderNO, orderName, orderDesc, orderAddress, paymentAmount, paymentAmount, new Date(), RegistryUtil.get("trade.department.consume"), TradeType.CONSUME);
	}

}
