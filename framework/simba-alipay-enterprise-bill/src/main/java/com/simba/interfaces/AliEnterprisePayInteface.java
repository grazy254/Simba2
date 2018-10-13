package com.simba.interfaces;

import com.simba.model.AliPayEnterpriseBill;

/**
 * 阿里企业支付处理接口
 * 
 * @author caozhejun
 *
 */
public interface AliEnterprisePayInteface {

	/**
	 * 开始转账
	 * 
	 * @param aliPayEnterpriseBill
	 */
	void add(AliPayEnterpriseBill aliPayEnterpriseBill);

	/**
	 * 转账结果更新
	 * 
	 * @param aliPayEnterpriseBill
	 */
	void update(AliPayEnterpriseBill aliPayEnterpriseBill);

}
