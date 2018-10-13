package com.simba.gaode.model.keywords;

/**
 * 深度信息
 * 
 * @author caozhejun
 *
 */
public class BizExt {

	/**
	 * 评分 仅存在于餐饮、酒店、景点、影院类POI之下
	 */
	private String rating;

	/**
	 * 人均消费 仅存在于餐饮、酒店、景点、影院类POI之下
	 */
	private String cost;

	/**
	 * 是否可订餐 仅存在于餐饮相关POI之下（此字段逐渐废弃）
	 */
	private String meal_ordering;

	/**
	 * 是否可选座 仅存在于影院相关POI之下（此字段逐渐废弃）
	 */
	private String seat_ordering;

	/**
	 * 是否可订票 仅存在于景点相关POI之下（此字段逐渐废弃）
	 */
	private String ticket_ordering;

	/**
	 * 是否可以订房 仅存在于酒店相关POI之下（此字段逐渐废弃）
	 */
	private String hotel_ordering;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getMeal_ordering() {
		return meal_ordering;
	}

	public void setMeal_ordering(String meal_ordering) {
		this.meal_ordering = meal_ordering;
	}

	public String getSeat_ordering() {
		return seat_ordering;
	}

	public void setSeat_ordering(String seat_ordering) {
		this.seat_ordering = seat_ordering;
	}

	public String getTicket_ordering() {
		return ticket_ordering;
	}

	public void setTicket_ordering(String ticket_ordering) {
		this.ticket_ordering = ticket_ordering;
	}

	public String getHotel_ordering() {
		return hotel_ordering;
	}

	public void setHotel_ordering(String hotel_ordering) {
		this.hotel_ordering = hotel_ordering;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BizExt [rating=");
		builder.append(rating);
		builder.append(", cost=");
		builder.append(cost);
		builder.append(", meal_ordering=");
		builder.append(meal_ordering);
		builder.append(", seat_ordering=");
		builder.append(seat_ordering);
		builder.append(", ticket_ordering=");
		builder.append(ticket_ordering);
		builder.append(", hotel_ordering=");
		builder.append(hotel_ordering);
		builder.append("]");
		return builder.toString();
	}

}
