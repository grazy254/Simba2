package com.simba.alipay.cosntantData;

/**
 * 阿里支付的常量类
 * 
 * @author caozhejun
 *
 */
public interface AliPayConstantData {

	/**
	 * 支付宝网关
	 */
	String payUrl = "https://openapi.alipay.com/gateway.do";

	/**
	 * 参数返回格式
	 */
	String format = "json";

	/**
	 * 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	 */
	String signType = "RSA2";
}
