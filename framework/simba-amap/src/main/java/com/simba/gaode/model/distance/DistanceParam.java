package com.simba.gaode.model.distance;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.simba.gaode.model.MapAddressPoint;
import com.simba.model.constant.ConstantData;

/**
 * 距离测量请求参数对象
 * 
 * @author caozhejun
 *
 */
public class DistanceParam {

	/**
	 * 出发点 公交支持20个坐标对 其余支持100个坐标对，坐标对见用“| ”分隔；经度和纬度用","分隔
	 */
	private String origins;

	/**
	 * 目的地 规则： lon，lat（经度，纬度）， “,”分割 如117.500244, 40.417801 经纬度小数点不超过6位
	 */
	private MapAddressPoint destination;

	/**
	 * 路径计算的方式和方法 0：直线距离 1：驾车导航距离（仅支持国内坐标）。 必须指出，当为1时会考虑路况，故在不同时间请求返回结果可能不同。
	 * 此策略和驾车路径规划接口的 strategy=4策略基本一致，策略为“ 躲避拥堵的路线，但是可能会存在绕路的情况，耗时可能较长 ”
	 * 若需要实现高德地图客户端效果，可以考虑使用驾车路径规划接口 2：公交规划距离（仅支持同城坐标,QPS不可超过1，否则可能导致意外）
	 * 3：步行规划距离（仅支持5km之间的距离）
	 */
	private String type = "0";

	public String getOrigins() {
		return origins;
	}

	public void setOrigins(String origins) {
		this.origins = origins;
	}

	public MapAddressPoint getDestination() {
		return destination;
	}

	public void setDestination(MapAddressPoint destination) {
		this.destination = destination;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public DistanceParam() {

	}

	public DistanceParam(String origins, MapAddressPoint destination) {
		this.origins = origins;
		this.destination = destination;
	}

	public DistanceParam(String origins, MapAddressPoint destination, String type) {
		this.origins = origins;
		this.destination = destination;
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DistanceParam [origins=");
		builder.append(origins);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append("&origins=" + URLEncoder.encode(origins, ConstantData.DEFAULT_CHARSET));
		builder.append("&destination=" + destination.toString());
		builder.append("&type=" + type);
		return builder.toString();
	}

}
