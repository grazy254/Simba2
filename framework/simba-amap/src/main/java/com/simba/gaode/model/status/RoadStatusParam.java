package com.simba.gaode.model.status;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 指定线路交通态势请求参数对象
 * 
 * @author caozhejun
 *
 */
public class RoadStatusParam {

	/**
	 * 道路等级 指定道路等级，下面各值代表的含义： 1：高速（京藏高速） 2：城市快速路、国道(西三环、103国道) 3：高速辅路（G6辅路）
	 * 4：主要道路（长安街、三环辅路路） 5：一般道路（彩和坊路） 6：无名道路
	 */
	private String level;

	/**
	 * 返回结果控制 可选值：base,all
	 */
	private String extensions;

	/**
	 * 道路名
	 */
	private String name;

	/**
	 * 城市名 由于开发者可能对城市称呼和高德的称呼存在差异 （例如开发者称呼为深圳，但高德仅识别深圳市） 故强烈建议使用adcode，不使用city字段
	 * 另外此处的adcode仅识别市级的adcode 非必填（city和adcode必填一个）
	 */
	private String city;

	/**
	 * 城市编码 由于开发者可能对城市称呼和高德的称呼存在差异 （例如开发者称呼为深圳，但高德仅识别深圳市） 故强烈建议使用adcode，不使用city字段
	 * 非必填（city和adcode必填一个）
	 */
	private String adcode;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getExtensions() {
		return extensions;
	}

	public void setExtensions(String extensions) {
		this.extensions = extensions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoadStatusParam [level=");
		builder.append(level);
		builder.append(", extensions=");
		builder.append(extensions);
		builder.append(", name=");
		builder.append(name);
		builder.append(", city=");
		builder.append(city);
		builder.append(", adcode=");
		builder.append(adcode);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(name)) {
			builder.append("&name=" + URLEncoder.encode(name, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(city)) {
			builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(adcode)) {
			builder.append("&adcode=" + adcode);
		}
		if (StringUtils.isNotEmpty(level)) {
			builder.append("&level=" + level);
		}
		if (StringUtils.isNotEmpty(extensions)) {
			builder.append("&extensions=" + extensions);
		}
		return builder.toString();
	}
}
