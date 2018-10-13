package com.simba.enterprise.pay.util.common;

/**
 * 微信企业付款常量类
 * 
 * @author caozhejun
 *
 */
public interface WxEnterprisePayConstantData {

	/**
	 * 企业付款到零钱的url
	 */
	String transfersLooseMoneyUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";

	/**
	 * 企业付款到零钱结果查询的url
	 */
	String searchLooseMoneyUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

	/**
	 * 获取RSA加密公钥的url
	 */
	String getPublicUrl = "https://fraud.mch.weixin.qq.com/risk/getpublickey";

	/**
	 * 企业转账到银行卡的url
	 */
	String transfersCardUrl = "https://api.mch.weixin.qq.com/mmpaysptrans/pay_bank";

	/**
	 * 查询企业付款到银行卡的url
	 */
	String searchCardUrl = "https://api.mch.weixin.qq.com/mmpaysptrans/query_bank";
}
