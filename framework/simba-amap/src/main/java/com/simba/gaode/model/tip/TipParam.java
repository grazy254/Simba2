package com.simba.gaode.model.tip;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 输入提示请求参数对象
 * 
 * @author caozhejun
 *
 */
public class TipParam {

	public TipParam() {

	}

	public TipParam(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * 查询关键词
	 */
	private String keywords;

	/**
	 * POI分类 服务可支持传入多个分类，多个类型剑用“|”分隔 可选值：POI分类名称、分类代码 此处强烈建议使用分类代码，否则可能会得到不符合预期的结果
	 */
	private String type;

	/**
	 * 坐标 格式：“X,Y”（经度,纬度），不可以包含空格 建议使用location参数，可在此location附近优先返回搜索关键词信息
	 */
	private String location;

	/**
	 * 搜索城市 可选值：citycode、adcode 如：010/110000
	 */
	private String city;

	/**
	 * 仅返回指定城市数据 可选值：true/false
	 */
	private String citylimit;

	/**
	 * 返回的数据类型
	 * 多种数据类型用“|”分隔，可选值：all-返回所有数据类型、poi-返回POI数据类型、bus-返回公交站点数据类型、busline-返回公交线路数据类型
	 */
	private String datatype;

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCitylimit() {
		return citylimit;
	}

	public void setCitylimit(String citylimit) {
		this.citylimit = citylimit;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipParam [keywords=");
		builder.append(keywords);
		builder.append(", type=");
		builder.append(type);
		builder.append(", location=");
		builder.append(location);
		builder.append(", city=");
		builder.append(city);
		builder.append(", citylimit=");
		builder.append(citylimit);
		builder.append(", datatype=");
		builder.append(datatype);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(keywords)) {
			builder.append("&keywords=" + URLEncoder.encode(keywords, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(type)) {
			builder.append("&type=" + URLEncoder.encode(type, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(city)) {
			builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(citylimit)) {
			builder.append("&citylimit=" + citylimit);
		}
		if (StringUtils.isNotEmpty(location)) {
			builder.append("&location=" + location);
		}
		if (StringUtils.isNotEmpty(datatype)) {
			builder.append("&datatype=" + datatype);
		}
		return builder.toString();
	}

}
