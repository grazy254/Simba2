package com.simba.gaode.model.fence;

import com.simba.framework.util.json.FastJsonUtil;

/**
 * 创建围栏请求参数对象
 * 
 * @author caozhejun
 *
 */
public class CreateFenceParam {

	/**
	 * 
	 * 围栏名称 字母&数字&汉字
	 */
	private String name;

	/**
	 * 圆形围栏中心点 longitude,latitude 圆形围栏必填与points互斥
	 */
	private String center;

	/**
	 * 圆形围栏半径 单位：米。范围0~3000。 圆形围栏必填与points互斥
	 */
	private String radius;

	/**
	 * 多边形围栏坐标点 lon1,lat1;lon2,lat2;lon3,lat3（3<=点个数<=5000） 多边形围栏必填
	 */
	private String points;

	/**
	 * 围栏监控状态 布尔类型
	 */
	private String enable;

	/**
	 * 过期日期 围栏有效截止日期，过期后不对此围栏进行维护（围栏数据过期删除）； 不能设定创建围栏时间点之前的日期； 格式yyyy-MM-dd；
	 * 请设置2055年之前的日期
	 * 
	 */
	private String valid_time;

	/**
	 * 一周内围栏监控日期的重复模式 星期缩写列表，用","或“;”隔开。 样例："Mon,Sat" 表示周一和周六有效。 星期简称如下（首字母大写）：
	 * Mon,Tues,Wed,Thur,Fri,Sat,Sun repeat和fixed_date不能同时缺省或同时为空，二者所指出的监控日期为“或”关系
	 * 可选，repeat和fixed_date不能同时缺省或同时为空，二者所指出的监控日期为“或”关系
	 */
	private String repeat;

	/**
	 * 指定日期列表 格式"date1;date2;date3"； date格式"yyyy-MM-dd"； 最大个数180，不能设定过去日期；
	 * repeat和fixed_date不能同时缺省或同时为空，二者所指出的监控日期为“或”关系；
	 * 可选，repeat和fixed_date不能同时缺省或同时为空，二者所指出的监控日期为“或”关系
	 */
	private String fixed_date;

	/**
	 * 一天内围栏监控时段 开始时间和结束时间定义一时间段，可设置多个时间段，时间段按照时间顺序排列，各时间段不可重叠；
	 * 拼接字符串格式如："startTime1,endTime1;startTime2,endTime2"； 最大个数24； 不可为空；
	 * 范围00:00-23:59； 时间段不可重叠； 时间段长度>15min；
	 */
	private String time;

	/**
	 * 围栏描述信息
	 */
	private String desc;

	/**
	 * 配置触发围栏所需动作 触发动作分号分割 enter;leave（进入、离开触发）
	 */
	private String alert_condition;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getValid_time() {
		return valid_time;
	}

	public void setValid_time(String valid_time) {
		this.valid_time = valid_time;
	}

	public String getRepeat() {
		return repeat;
	}

	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	public String getFixed_date() {
		return fixed_date;
	}

	public void setFixed_date(String fixed_date) {
		this.fixed_date = fixed_date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAlert_condition() {
		return alert_condition;
	}

	public void setAlert_condition(String alert_condition) {
		this.alert_condition = alert_condition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateFenceParam [name=");
		builder.append(name);
		builder.append(", center=");
		builder.append(center);
		builder.append(", radius=");
		builder.append(radius);
		builder.append(", points=");
		builder.append(points);
		builder.append(", enable=");
		builder.append(enable);
		builder.append(", valid_time=");
		builder.append(valid_time);
		builder.append(", repeat=");
		builder.append(repeat);
		builder.append(", fixed_date=");
		builder.append(fixed_date);
		builder.append(", time=");
		builder.append(time);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", alert_condition=");
		builder.append(alert_condition);
		builder.append("]");
		return builder.toString();
	}

	public String toJson() {
		return FastJsonUtil.toJson(this);
	}

}
