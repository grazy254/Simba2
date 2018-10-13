package com.simba.interfaces;

import com.simba.model.RedPackBill;

/**
 * 微信发红包到业务处理类
 * 
 * @author caozhejun
 *
 */
public interface WechatRedPackInterface {

	/**
	 * 发红包
	 * 
	 * @param redPackBill
	 */
	void add(RedPackBill redPackBill);

	/**
	 * 红包发送更新
	 * 
	 * @param redPackBill
	 */
	void update(RedPackBill redPackBill);

}
