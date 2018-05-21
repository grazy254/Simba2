package com.simba.alipay.model;

/**
 * 订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”
 * 
 * @author caozhejun
 *
 */
public class GoodsDetail {

	/**
	 * 商品的编号
	 */
	private String goods_id;

	/**
	 * 商品名称
	 */
	private String goods_name;

	/**
	 * 商品数量
	 */
	private int quantity;

	/**
	 * 商品单价，单位为元
	 */
	private double price;

	/**
	 * 商品类目
	 */
	private String goods_category;

	/**
	 * 商品描述信息
	 */
	private String body;

	/**
	 * 商品的展示地址
	 */
	private String show_url;

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoods_category() {
		return goods_category;
	}

	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsDetail [goods_id=");
		builder.append(goods_id);
		builder.append(", goods_name=");
		builder.append(goods_name);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", price=");
		builder.append(price);
		builder.append(", goods_category=");
		builder.append(goods_category);
		builder.append(", body=");
		builder.append(body);
		builder.append(", show_url=");
		builder.append(show_url);
		builder.append("]");
		return builder.toString();
	}

}
