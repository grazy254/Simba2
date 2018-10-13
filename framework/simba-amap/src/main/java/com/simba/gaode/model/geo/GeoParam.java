package com.simba.gaode.model.geo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

import com.simba.model.constant.ConstantData;

/**
 * 地理编码请求参数对象
 * 
 * @author caozhejun
 *
 */
public class GeoParam {

	/**
	 * 结构化地址信息
	 * 规则遵循：国家、省份、城市、区县、城镇、乡村、街道、门牌号码、屋邨、大厦，如：北京市朝阳区阜通东大街6号。如果需要解析多个地址的话，请用"|"进行间隔，并且将
	 * batch 参数设置为 true，最多支持 10 个地址进进行"|"分割形式的请求。
	 */
	private String address;

	/**
	 * 指定查询的城市
	 * 可选输入内容包括：指定城市的中文（如北京）、指定城市的中文全拼（beijing）、citycode（010）、adcode（110000）。当指定城市查询内容为空时，会进行全国范围内的地址转换检索
	 */
	private String city;

	/**
	 * 批量查询控制 batch 参数设置为 true 时进行批量查询操作，最多支持 10 个地址进行批量查询。 batch 参数设置为 false
	 * 时进行单点查询，此时即使传入多个地址也只返回第一个地址的解析查询结果。
	 */
	private String batch = "false";

	public GeoParam() {

	}

	public GeoParam(String address) {
		this.address = address;
	}

	public GeoParam(String address, String batch) {
		this.address = address;
		this.batch = batch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeoParam [address=");
		builder.append(address);
		builder.append(", city=");
		builder.append(city);
		builder.append(", batch=");
		builder.append(batch);
		builder.append("]");
		return builder.toString();
	}

	public String buildParamUrl() throws UnsupportedEncodingException {
		StringBuilder builder = new StringBuilder();
		if (StringUtils.isNotEmpty(batch)) {
			builder.append("&batch=" + batch);
		}
		if (StringUtils.isNotEmpty(city)) {
			builder.append("&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET));
		}
		if (StringUtils.isNotEmpty(address)) {
			builder.append("&address=" + URLEncoder.encode(address, ConstantData.DEFAULT_CHARSET));
		}
		return builder.toString();
	}

}
