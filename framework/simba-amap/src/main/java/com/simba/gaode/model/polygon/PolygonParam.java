package com.simba.gaode.model.polygon;

/**
 * 多边形搜索请求参数对象
 * 
 * @author caozhejun
 *
 */
public class PolygonParam {

	/**
	 * 经纬度坐标对 规则：经度和纬度用","分割，经度在前，纬度在后，坐标对用"|"分割。经纬度小数点后不得超过6位。
	 * 多边形为矩形时，可传入左上右下两顶点坐标对；其他情况下首尾坐标对需相同。
	 */
	private String polygon;

	/**
	 * 查询关键字 规则： 多个关键字用“|”分割
	 */
	private String keywords;
	
	
}
