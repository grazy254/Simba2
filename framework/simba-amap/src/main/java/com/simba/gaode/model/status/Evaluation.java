package com.simba.gaode.model.status;

/**
 * 路况评价
 * 
 * @author caozhejun
 *
 */
public class Evaluation {

	/**
	 * 畅通所占百分比
	 */
	private String expedite;

	/**
	 * 缓行所占百分比
	 */
	private String congested;

	/**
	 * 拥堵所占百分比
	 */
	private String blocked;

	/**
	 * 未知路段所占百分比
	 */
	private String unknown;

	/**
	 * 路况 0：未知 1：畅通 2：缓行 3：拥堵
	 */
	private String status;

	/**
	 * 道路描述
	 */
	private String description;

	public String getExpedite() {
		return expedite;
	}

	public void setExpedite(String expedite) {
		this.expedite = expedite;
	}

	public String getCongested() {
		return congested;
	}

	public void setCongested(String congested) {
		this.congested = congested;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public String getUnknown() {
		return unknown;
	}

	public void setUnknown(String unknown) {
		this.unknown = unknown;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evaluation [expedite=");
		builder.append(expedite);
		builder.append(", congested=");
		builder.append(congested);
		builder.append(", blocked=");
		builder.append(blocked);
		builder.append(", unknown=");
		builder.append(unknown);
		builder.append(", status=");
		builder.append(status);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
