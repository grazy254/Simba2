package com.simba.util.common;

/**
 * 微信支付常量类
 * 
 * @author caozhejun
 *
 */
public class WxPayConstantData {

	private WxPayConstantData() {

	}

	private static final class WxPayConstantDataHolder {
		private static final WxPayConstantData instance = new WxPayConstantData();
	}

	public static WxPayConstantData getInstance() {
		return WxPayConstantDataHolder.instance;
	}

	/**
	 * 统一下单
	 */
	private String unifiedorderUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/unifiedorder";

	/**
	 * 查询订单
	 */
	private String orderqueryUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/orderquery";

	/**
	 * 关闭订单
	 */
	private String closeorderUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/closeorder";

	/**
	 * 查询退款
	 */
	private String refundqueryUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/refundquery";

	/**
	 * 下载对账单
	 */
	private String downloadbillUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/downloadbill";

	/**
	 * 申请退款
	 */
	private String refundUrl = "https://api.mch.weixin.qq.com/sandboxnew/secapi/pay/refund";

	/**
	 * 获取沙箱key的url地址
	 */
	private String sandboxnewKeyUrl = "https://api.mch.weixin.qq.com/sandboxnew/pay/getsignkey";

	public String getUnifiedorderUrl() {
		return unifiedorderUrl;
	}

	public String getOrderqueryUrl() {
		return orderqueryUrl;
	}

	public String getCloseorderUrl() {
		return closeorderUrl;
	}

	public String getRefundqueryUrl() {
		return refundqueryUrl;
	}

	public String getDownloadbillUrl() {
		return downloadbillUrl;
	}

	public String getRefundUrl() {
		return refundUrl;
	}

	public String getSandboxnewKeyUrl() {
		return sandboxnewKeyUrl;
	}

	/**
	 * 更换成正式环境url
	 */
	public void changeReal() {
		unifiedorderUrl = unifiedorderUrl.replace("/sandboxnew", "");
		orderqueryUrl = orderqueryUrl.replace("/sandboxnew", "");
		closeorderUrl = closeorderUrl.replace("/sandboxnew", "");
		refundqueryUrl = refundqueryUrl.replace("/sandboxnew", "");
		downloadbillUrl = downloadbillUrl.replace("/sandboxnew", "");
		refundUrl = refundUrl.replace("/sandboxnew", "");
	}
}
