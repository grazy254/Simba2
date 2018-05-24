package com.simba.alipay.model;

/**
 * 统一收单交易创建
 * 
 * @author caozhejun
 *
 */
public class CreateOrder {

	/**
	 * 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
	 */
	private String out_trade_no;

	/**
	 * 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
	 */
	private String seller_id;

	/**
	 * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
	 */
	private double total_amount;

	/**
	 * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
	 * 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】
	 */
	private double discountable_amount;

	/**
	 * 订单标题
	 */
	private String subject;

	/**
	 * 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
	 */
	private GoodsDetail goods_detail;

	/**
	 * 对交易或商品的描述
	 */
	private String body;

	/**
	 * 买家的支付宝唯一用户号（2088开头的16位纯数字）,和buyer_logon_id不能同时为空
	 */
	private String buyer_id;

	/**
	 * 商户操作员编号
	 */
	private String operator_id;

	/**
	 * 商户门店编号
	 */
	private String store_id;

	/**
	 * 商户机具终端编号
	 */
	private String terminal_id;

	/**
	 * 业务扩展参数
	 */
	private ExtendParams extend_params;

	/**
	 * 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
	 * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
	 */
	private String timeout_express;

	/**
	 * 商户传入业务信息，具体值要和支付宝约定，应用于安全，营销等参数直传场景，格式为json格式
	 */
	private String business_params;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public double getDiscountable_amount() {
		return discountable_amount;
	}

	public void setDiscountable_amount(double discountable_amount) {
		this.discountable_amount = discountable_amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public GoodsDetail getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(GoodsDetail goods_detail) {
		this.goods_detail = goods_detail;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	public ExtendParams getExtend_params() {
		return extend_params;
	}

	public void setExtend_params(ExtendParams extend_params) {
		this.extend_params = extend_params;
	}

	public String getTimeout_express() {
		return timeout_express;
	}

	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}

	public String getBusiness_params() {
		return business_params;
	}

	public void setBusiness_params(String business_params) {
		this.business_params = business_params;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateOrder [out_trade_no=");
		builder.append(out_trade_no);
		builder.append(", seller_id=");
		builder.append(seller_id);
		builder.append(", total_amount=");
		builder.append(total_amount);
		builder.append(", discountable_amount=");
		builder.append(discountable_amount);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", goods_detail=");
		builder.append(goods_detail);
		builder.append(", body=");
		builder.append(body);
		builder.append(", buyer_id=");
		builder.append(buyer_id);
		builder.append(", operator_id=");
		builder.append(operator_id);
		builder.append(", store_id=");
		builder.append(store_id);
		builder.append(", terminal_id=");
		builder.append(terminal_id);
		builder.append(", extend_params=");
		builder.append(extend_params);
		builder.append(", timeout_express=");
		builder.append(timeout_express);
		builder.append(", business_params=");
		builder.append(business_params);
		builder.append("]");
		return builder.toString();
	}

}
