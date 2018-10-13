package com.simba.gaode.model.status;

/**
 * 道路信息
 * 
 * @author caozhejun
 *
 */
public class Road {

	/**
	 * 道路名称
	 */
	private String name;

	/**
	 * 路况 0：未知 1：畅通 2：缓行 3：拥堵
	 */
	private String status;

	/**
	 * 方向描述
	 */
	private String direction;

	/**
	 * 车行角度，判断道路正反向使用。 以正东方向为0度，逆时针方向为正， 取值范围：[0,360]
	 */
	private String angle;

	/**
	 * 速度 单位：千米/小时
	 */
	private String speed;

	/**
	 * 方向
	 */
	private String lcodes;

	/**
	 * 道路坐标集，坐标集合 经度和纬度使用","分隔 坐标之间使用";"分隔。 例如：x1,y1;x2,y2
	 */
	private String ployline;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getAngle() {
		return angle;
	}

	public void setAngle(String angle) {
		this.angle = angle;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getLcodes() {
		return lcodes;
	}

	public void setLcodes(String lcodes) {
		this.lcodes = lcodes;
	}

	public String getPloyline() {
		return ployline;
	}

	public void setPloyline(String ployline) {
		this.ployline = ployline;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Road [name=");
		builder.append(name);
		builder.append(", status=");
		builder.append(status);
		builder.append(", direction=");
		builder.append(direction);
		builder.append(", angle=");
		builder.append(angle);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", lcodes=");
		builder.append(lcodes);
		builder.append(", ployline=");
		builder.append(ployline);
		builder.append("]");
		return builder.toString();
	}

}
