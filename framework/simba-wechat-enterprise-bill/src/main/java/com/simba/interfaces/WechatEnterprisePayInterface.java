package com.simba.interfaces;

import com.simba.model.CardMoneyBill;
import com.simba.model.LooseMoneyBill;

/**
 * 微信企业支付业务处理接口
 * 
 * @author caozhejun
 *
 */
public interface WechatEnterprisePayInterface {

	/**
	 * 创建微信转账到零钱
	 * 
	 * @param looseMoneyBill
	 */
	void add(LooseMoneyBill looseMoneyBill);

	/**
	 * 更新转账状态
	 * 
	 * @param looseMoneyBill
	 */
	void update(LooseMoneyBill looseMoneyBill);

	/**
	 * 创建微信转账到银行卡
	 * 
	 * @param cardMoneyBill
	 */
	void add(CardMoneyBill cardMoneyBill);

	/**
	 * 更新转账状态
	 * 
	 * @param cardMoneyBill
	 */
	void update(CardMoneyBill cardMoneyBill);
}
