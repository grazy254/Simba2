package com.simba.wallet.pay.trade;

import org.apache.commons.lang.StringUtils;

import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.util.CommonUtil;

/**
 * 支付调用接口
 * 
 * @author zhangfenghua
 *
 */
public class InnerTradeContext {

	private InnerTradeInterface trade;

	public InnerTradeContext(InnerTradeInterface trade) {
		this.trade = trade;
	}

	/**
	 * 执行交易
	 * 
	 * @param userID
	 *            smart用户的account
	 * @param orderNO
	 *            订单号
	 * @param paymentAmount
	 *            金额
	 * @return
	 */
	public JsonResult trade(String userID, String orderNO, long paymentAmount) {
		return trade.trade(userID, StringUtils.EMPTY, StringUtils.EMPTY, orderNO, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, paymentAmount, paymentAmount);
	}

	/**
	 * 执行交易 自动生成orderNO
	 * 
	 * @param userID
	 * @param paymentAmount
	 * @return
	 */
	public JsonResult trade(String userID, long paymentAmount) {
		return trade.trade(userID, StringUtils.EMPTY, StringUtils.EMPTY, CommonUtil.generateOrderNO(), StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, paymentAmount, paymentAmount);
	}

	public JsonResult trade(String userID, String ip, String location, String orderNO, String orderName, String orderDesc, String orderAddress, long originalAmount, long paymentAmount) {
		return trade.trade(userID, ip, location, orderNO, orderName, orderDesc, orderAddress, originalAmount, paymentAmount);
	}

}
