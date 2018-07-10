package com.simba.gaode.model.truck;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

import com.simba.gaode.model.MapAddressPoint;
import com.simba.gaode.model.enums.TruckStrategy;

/**
 * 货车路径规划请求参数对象
 * 
 * @author caozhejun
 *
 */
public class TruckParam {

	/**
	 * 出发点
	 */
	private MapAddressPoint origin;

	/**
	 * 目的地
	 */
	private MapAddressPoint destination;

	/**
	 * 出发点poiid 当起点为POI时，建议填充此值。
	 */
	private String originid;

	/**
	 * 目的地poiid 当终点为POI时，建议填充此值。
	 */
	private String destinationid;

	/**
	 * 起点的poi类别 当用户知道起点POI的类别时候，建议填充此值
	 */
	private String origintype;

	/**
	 * 终点的poi类别 当用户知道终点POI的类别时候，建议填充此值
	 */
	private String destinationtype;

	/**
	 * 设备唯一编号 android的imei ios的idfa
	 */
	private String diu;

	/**
	 * 驾车选择策略
	 */
	private TruckStrategy strategy = TruckStrategy.ONE;

	/**
	 * 途经点 "规则：经度和纬度用“,”分隔，坐标点之间用";"分隔 默认值：无 最大数目：16个坐标点，如果输入多个途径点，则按照用户输入的顺序进行路径规划"
	 */
	private String waypoints;

	/**
	 * 车辆大小 高德此分类依据国标 1：微型车，2：轻型车（默认值），3：中型车，4：重型车
	 */
	private String size = "2";

	/**
	 * 车辆高度 单位米，取值[0 – 25.5]米，默认 1.6 米，会严格按照填写数字进行限行规避，请按照车辆真实信息合理填写。
	 */
	private String height = "1.6";

	/**
	 * 辆宽度 单位米，取值[0 – 25.5]米，默认 2.5 米，会严格按照填写数字进行限行规避，请按照车辆真实信息合理填写。
	 */
	private String width = "2.5";

	/**
	 * 单位吨，取值[0 – 6553.5]吨，默认 0.9 吨，会严格按照填写数字进行限行规避，请按照车辆真实信息合理填写
	 */
	private String load = "0.9";

	/**
	 * 货车核定载重 单位吨，取值[0 – 6553.5]吨，默认 10 吨，会严格按照填写数字进行限行规避，请按照车辆真实信息合理填写。
	 */
	private String weight = "10";

	/**
	 * 车辆轴数 单位个，取值[0 –255]个，默认 2个轴，会严格按照填写数字进行限行规避，请按照车辆真实信息合理填写。
	 */
	private String axis = "2";

	/**
	 * 车牌省份 用汉字填入车牌省份缩写。用于判断是否限行
	 */
	private String province;

	/**
	 * 车牌详情 填入除省份及标点之外的字母和数字（需大写）。用于判断限行相关。
	 */
	private String number;

	public MapAddressPoint getOrigin() {
		return origin;
	}

	public void setOrigin(MapAddressPoint origin) {
		this.origin = origin;
	}

	public MapAddressPoint getDestination() {
		return destination;
	}

	public void setDestination(MapAddressPoint destination) {
		this.destination = destination;
	}

	public String getOriginid() {
		return originid;
	}

	public void setOriginid(String originid) {
		this.originid = originid;
	}

	public String getDestinationid() {
		return destinationid;
	}

	public void setDestinationid(String destinationid) {
		this.destinationid = destinationid;
	}

	public String getOrigintype() {
		return origintype;
	}

	public void setOrigintype(String origintype) {
		this.origintype = origintype;
	}

	public String getDestinationtype() {
		return destinationtype;
	}

	public void setDestinationtype(String destinationtype) {
		this.destinationtype = destinationtype;
	}

	public String getDiu() {
		return diu;
	}

	public void setDiu(String diu) {
		this.diu = diu;
	}

	public TruckStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(TruckStrategy strategy) {
		this.strategy = strategy;
	}

	public String getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(String waypoints) {
		this.waypoints = waypoints;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getLoad() {
		return load;
	}

	public void setLoad(String load) {
		this.load = load;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAxis() {
		return axis;
	}

	public void setAxis(String axis) {
		this.axis = axis;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TruckParam [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", originid=");
		builder.append(originid);
		builder.append(", destinationid=");
		builder.append(destinationid);
		builder.append(", origintype=");
		builder.append(origintype);
		builder.append(", destinationtype=");
		builder.append(destinationtype);
		builder.append(", diu=");
		builder.append(diu);
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append(", waypoints=");
		builder.append(waypoints);
		builder.append(", size=");
		builder.append(size);
		builder.append(", height=");
		builder.append(height);
		builder.append(", width=");
		builder.append(width);
		builder.append(", load=");
		builder.append(load);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", axis=");
		builder.append(axis);
		builder.append(", province=");
		builder.append(province);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}

	public TruckParam(MapAddressPoint origin, MapAddressPoint destination) {
		this.origin = origin;
		this.destination = destination;
	}

	public TruckParam() {

	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append("&origin=" + origin.toString());
		builder.append("&destination=" + destination.toString());
		if (StringUtils.isNotEmpty(originid)) {
			builder.append("&originid=" + originid);
		}
		if (StringUtils.isNotEmpty(destinationid)) {
			builder.append("&destinationid=" + destinationid);
		}
		if (StringUtils.isNotEmpty(origintype)) {
			builder.append("&origintype=" + origintype);
		}
		if (StringUtils.isNotEmpty(destinationtype)) {
			builder.append("&destinationtype=" + destinationtype);
		}
		if (StringUtils.isNotEmpty(diu)) {
			builder.append("&diu=" + diu);
		}
		
		return builder.toString();
	}

}
