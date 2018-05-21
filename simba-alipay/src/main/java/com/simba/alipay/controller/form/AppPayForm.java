package com.simba.alipay.controller.form;

/**
 * app支付参数对象
 * 
 * @author caozhejun
 *
 */
public class AppPayForm {

	/**
	 * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给body。
	 */
	private String body;

	/**
	 * 商品的标题/交易标题/订单标题/订单关键字等。
	 */
	private String subject;

	/**
	 * 商户网站唯一订单号
	 */
	private String outTradeNo;

	/**
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
	 * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	 */
	private String timeoutExpress;

	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 */
	private String totalAmount;

	/**
	 * 销售产品码，商家和支付宝签约的产品码
	 */
	private String productCode;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getTimeoutExpress() {
		return timeoutExpress;
	}

	public void setTimeoutExpress(String timeoutExpress) {
		this.timeoutExpress = timeoutExpress;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppPayForm [body=");
		builder.append(body);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", outTradeNo=");
		builder.append(outTradeNo);
		builder.append(", timeoutExpress=");
		builder.append(timeoutExpress);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append(", productCode=");
		builder.append(productCode);
		builder.append("]");
		return builder.toString();
	}

}
