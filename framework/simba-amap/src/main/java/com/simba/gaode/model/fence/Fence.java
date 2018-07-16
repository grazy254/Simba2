package com.simba.gaode.model.fence;

/**
 * 围栏
 * 
 * @author caozhejun
 *
 */
public class Fence {

	/**
	 * 围栏所在地区adcode
	 */
	private String adcode;

	/**
	 * 围栏监控触发条件
	 */
	private String alert_condition;

	/**
	 * 圆形围栏中心点
	 */
	private String center;

	/**
	 * 围栏创建时间
	 */
	private String create_time;

	/**
	 * 围栏激活状态
	 */
	private String enable;

	/**
	 * 指定日期
	 */
	private String fixed_date;

	/**
	 * 围栏全局id
	 */
	private String gid;

	/**
	 * 围栏id
	 */
	private String id;

	/**
	 * 开发者key
	 */
	private String key;

	/**
	 * 围栏名称
	 */
	private String name;

	/**
	 * 多边形围栏点
	 */
	private String points;

	/**
	 * 圆形围栏半径
	 */
	private String radius;

	/**
	 * 一周内围栏监控的重复星期
	 */
	private String repeat;

	/**
	 * 一天内监控的具体时段
	 */
	private String time;

	/**
	 * 
	 * 过期日期
	 */
	private String valid_time;

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getAlert_condition() {
		return alert_condition;
	}

	public void setAlert_condition(String alert_condition) {
		this.alert_condition = alert_condition;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getFixed_date() {
		return fixed_date;
	}

	public void setFixed_date(String fixed_date) {
		this.fixed_date = fixed_date;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getValid_time() {
		return valid_time;
	}

	public void setValid_time(String valid_time) {
		this.valid_time = valid_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fence [adcode=");
		builder.append(adcode);
		builder.append(", alert_condition=");
		builder.append(alert_condition);
		builder.append(", center=");
		builder.append(center);
		builder.append(", create_time=");
		builder.append(create_time);
		builder.append(", enable=");
		builder.append(enable);
		builder.append(", fixed_date=");
		builder.append(fixed_date);
		builder.append(", gid=");
		builder.append(gid);
		builder.append(", id=");
		builder.append(id);
		builder.append(", key=");
		builder.append(key);
		builder.append(", name=");
		builder.append(name);
		builder.append(", points=");
		builder.append(points);
		builder.append(", radius=");
		builder.append(radius);
		builder.append(", repeat=");
		builder.append(repeat);
		builder.append(", time=");
		builder.append(time);
		builder.append(", valid_time=");
		builder.append(valid_time);
		builder.append("]");
		return builder.toString();
	}

}
