package com.simba.gaode.util.common;

/**
 * 高德地图常量类
 * 
 * @author caozhejun
 *
 */
public interface GaodeConstantData {

	/**
	 * 步行路径规划
	 */
	String WORKLINEURL = "http://restapi.amap.com/v3/direction/walking?output=JSON";

	/**
	 * 公交路径规划
	 */
	String BUSLINEURL = "http://restapi.amap.com/v3/direction/transit/integrated?output=JSON";

}
