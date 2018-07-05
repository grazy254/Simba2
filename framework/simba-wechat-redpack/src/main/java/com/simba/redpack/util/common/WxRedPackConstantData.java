package com.simba.redpack.util.common;

/**
 * 微信现金红包常量类
 * 
 * @author caozhejun
 *
 */
public interface WxRedPackConstantData {

	/**
	 * 发送普通红包的url
	 */
	String sendNormalRedPackUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

	/**
	 * 发送裂变红包的url
	 */
	String sendGroupRedPackUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";

	/**
	 * 查询红包的url
	 */
	String searchRedPackUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";
}
