package com.simba.gaode.model.bus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.gaode.model.enums.Extensions;
import com.simba.gaode.model.enums.NightFlag;
import com.simba.gaode.model.MapAddressPoint;
import com.simba.gaode.model.enums.BusStrategy;
import com.simba.model.constant.ConstantData;

/**
 * 公交线路规划请求参数对象
 * 
 * @author caozhejun
 *
 */
public class BusLineParam {

	/**
	 * 出发点
	 */
	private MapAddressPoint origin;

	/**
	 * 目的地
	 */
	private MapAddressPoint destination;

	/**
	 * 城市/跨城规划时的起点城市 目前支持市内公交换乘/跨城公交的起点城市。 可选值：城市名称/citycode
	 */
	private String city;

	/**
	 * 跨城公交规划时的终点城市 跨城公交规划必填参数。 可选值：城市名称/citycode
	 */
	private String cityd = StringUtils.EMPTY;

	/**
	 * 返回结果详略
	 */
	private Extensions extensions = Extensions.ALL;

	/**
	 * 公交换乘策略
	 */
	private BusStrategy strategy = BusStrategy.QUICK;

	/**
	 * 是否计算夜班车
	 */
	private NightFlag nightflag = NightFlag.Y;

	/**
	 * 出发日期 根据出发时间和日期筛选可乘坐的公交路线，格式：date=2014-3-19 为了保证计算正确，在不填写日期的时候请不要在请求之中携带此参数
	 */
	private String date = StringUtils.EMPTY;

	/**
	 * 出发时间 根据出发时间和日期筛选可乘坐的公交路线，格式：time=22:34 为了保证计算正确，在不填写日期的时候请不要在请求之中携带此参数
	 */
	private String time = StringUtils.EMPTY;

	public BusLineParam(MapAddressPoint origin, MapAddressPoint destination, String city) {
		this.origin = origin;
		this.destination = destination;
		this.city = city;
	}

	public BusLineParam() {

	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityd() {
		return cityd;
	}

	public void setCityd(String cityd) {
		this.cityd = cityd;
	}

	public Extensions getExtensions() {
		return extensions;
	}

	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}

	public BusStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(BusStrategy strategy) {
		this.strategy = strategy;
	}

	public NightFlag getNightflag() {
		return nightflag;
	}

	public void setNightflag(NightFlag nightflag) {
		this.nightflag = nightflag;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusLineParam [origin=");
		builder.append(origin);
		builder.append(", destination=");
		builder.append(destination);
		builder.append(", city=");
		builder.append(city);
		builder.append(", cityd=");
		builder.append(cityd);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append(", strategy=");
		builder.append(strategy);
		builder.append(", nightflag=");
		builder.append(nightflag);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		builder.append("&origin=" + origin.toString());
		builder.append("&destination=" + destination.toString());
		builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		builder.append("&cityd=" + cityd);
		builder.append("&extensions=" + extensions.getName());
		builder.append("&strategy=" + strategy.getName());
		builder.append("&nightflag=" + nightflag.getName());
		if (StringUtils.isNotEmpty(date)) {
			builder.append("&date=" + date);
		}
		if (StringUtils.isNotEmpty(time)) {
			builder.append("&time=" + time);
		}
		return builder.toString();
	}

}
