package com.simba.controller.form;

/**
 * 下载对账单请求对象
 */
public class BillDownloadForm {


	/**
	 * 自定义参数，可以为终端设备号(门店号或收银设备ID)，PC网页或公众号内支付可以传"WEB"
	 */
	private String device_info;

	/**
	 * 签名类型，默认为MD5，支持HMAC-SHA256和MD5
	 */
	private String sign_type = "MD5";

	/**
	 * 下载对账单的日期，格式：20140603
	 */
	private String bill_date;

	/**
	 * ALL，返回当日所有订单信息，默认值
	 * 
	 * SUCCESS，返回当日成功支付的订单
	 * 
	 * REFUND，返回当日退款订单
	 * 
	 * RECHARGE_REFUND，返回当日充值退款订单（相比其他对账单多一栏“返还手续费”）
	 * 
	 */
	private String bill_type;

	/**
	 * 非必传参数，固定值：GZIP，返回格式为.gzip的压缩包账单。不传则默认为数据流形式。
	 */
	private String tar_type;

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}

	public String getTar_type() {
		return tar_type;
	}

	public void setTar_type(String tar_type) {
		this.tar_type = tar_type;
	}

	@Override
	public String toString() {
		return "BillDownloadForm [device_info=" + device_info + ", sign_type=" + sign_type + ", bill_date=" + bill_date + ", bill_type=" + bill_type + ", tar_type=" + tar_type + "]";
	}

	
	
	
	
}