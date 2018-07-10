package com.simba.gaode.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.gaode.model.enums.DriveStrategy;
import com.simba.model.constant.ConstantData;

/**
 * 驾车路径规划请求参数对象
 * 
 * @author caozhejun
 *
 */
public class DriveLineParam {

	/**
	 * 出发点 经度在前，纬度在后，经度和纬度用","分割，经纬度小数点后不得超过6位。 由于在实际使用过程中，存在定位飘点的情况。
	 * 为了解决此类问题，允许传入多个起点用于计算车头角度。规划路径时以最后一个坐标对进行规划。 格式为x1,y1|x2,y2|x3,y3。
	 * 最多允许传入3个坐标对，每对坐标之间距离必须超过2m。 虽然对每对坐标之间长度没有上限，但是如果超过4米会有概率性出现不准确的情况。
	 */
	private String origin;

	/**
	 * 目的地 经度在前，纬度在后，经度和纬度用","分割，经纬度小数点后不得超过6位。
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
	 * 驾车选择策略
	 */
	private DriveStrategy strategy = DriveStrategy.TEN;

	/**
	 * 途经点 经度和纬度用","分割，经度在前，纬度在后，小数点后不超过6位，坐标点之间用";"分隔
	 * 最大数目：16个坐标点。如果输入多个途径点，则按照用户输入的顺序进行路径规划
	 */
	private String waypoints;

	/**
	 * 避让区域 区域避让，支持32个避让区域，每个区域最多可有16个顶点
	 * 经度和纬度用","分割，经度在前，纬度在后，小数点后不超过6位，坐标点之间用";"分隔，区域之间用"|"分隔。如果是四边形则有四个坐标点，如果是五边形则有五个坐标点；
	 * 同时传入避让区域及避让道路，仅支持避让道路； 避让区域不能超过81平方公里，否则避让区域会失效。
	 */
	private String avoidpolygons;

	/**
	 * 避让道路名 只支持一条避让道路
	 */
	private String avoidroad;

	/**
	 * 用汉字填入车牌省份缩写，用于判断是否限行 例如：京
	 */
	private String province;

	/**
	 * 填入除省份及标点之外，车牌的字母和数字（需大写）。用于判断限行相关。 例如:NH1N11
	 */
	private String number;

	/**
	 * 在路径规划中，是否使用轮渡 0:使用渡轮(默认) 1:不使用渡轮
	 */
	private String ferry = "0";

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
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

	public DriveStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(DriveStrategy strategy) {
		this.strategy = strategy;
	}

	public String getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(String waypoints) {
		this.waypoints = waypoints;
	}

	public String getAvoidpolygons() {
		return avoidpolygons;
	}

	public void setAvoidpolygons(String avoidpolygons) {
		this.avoidpolygons = avoidpolygons;
	}

	public String getAvoidroad() {
		return avoidroad;
	}

	public void setAvoidroad(String avoidroad) {
		this.avoidroad = avoidroad;
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

	public String getFerry() {
		return ferry;
	}

	public void setFerry(String ferry) {
		this.ferry = ferry;
	}

	public DriveLineParam() {

	}

	public DriveLineParam(String origin, MapAddressPoint destination) {
		this.origin = origin;
		this.destination = destination;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DriveLineParam [origin=");
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
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append(", waypoints=");
		builder.append(waypoints);
		builder.append(", avoidpolygons=");
		builder.append(avoidpolygons);
		builder.append(", avoidroad=");
		builder.append(avoidroad);
		builder.append(", province=");
		builder.append(province);
		builder.append(", number=");
		builder.append(number);
		builder.append(", ferry=");
		builder.append(ferry);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append("&origin=" + origin);
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
		builder.append("&strategy=" + strategy.getName());
		if (StringUtils.isNotEmpty(waypoints)) {
			builder.append("&waypoints=" + waypoints);
		}
		if (StringUtils.isNotEmpty(avoidpolygons)) {
			builder.append("&avoidpolygons=" + avoidpolygons);
		}
		if (StringUtils.isNotEmpty(avoidroad)) {
			builder.append("&avoidroad=" + URLEncoder.encode(avoidroad, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(province)) {
			builder.append("&province=" + URLEncoder.encode(province, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(number)) {
			builder.append("&number=" + number);
		}
		if (StringUtils.isNotEmpty(ferry)) {
			builder.append("&ferry=" + ferry);
		}
		return builder.toString();
	}
}
