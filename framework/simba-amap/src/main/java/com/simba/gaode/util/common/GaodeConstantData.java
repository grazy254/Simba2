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

	/**
	 * 驾车路径规划
	 */
	String DRIVEURL = "https://restapi.amap.com/v3/direction/driving?output=JSON";

	/**
	 * 骑行路径规划
	 */
	String BIKEURL = "https://restapi.amap.com/v4/direction/bicycling?output=JSON";

	/**
	 * 货车路径规划
	 */
	String TRUCKURL = "https://restapi.amap.com/v4/direction/truck";

	/**
	 * 距离测量
	 */
	String DISTANCEURL = "https://restapi.amap.com/v3/distance?output=JSON";

	/**
	 * 地理编码
	 */
	String GEOURL = "https://restapi.amap.com/v3/geocode/geo?output=JSON";

	/**
	 * 逆地理编码
	 */
	String REGEOURL = "https://restapi.amap.com/v3/geocode/regeo?output=JSON";

	/**
	 * 行政区域查询
	 */
	String AREAURL = "https://restapi.amap.com/v3/config/district?output=JSON";

	/**
	 * 关键字搜索
	 */
	String KEYWORDSURL = "https://restapi.amap.com/v3/place/text?output=JSON";

	/**
	 * 周边搜索
	 */
	String AROUDURL = "https://restapi.amap.com/v3/place/around?output=JSON";

	/**
	 * 多边形搜索
	 */
	String POLYGONURL = "https://restapi.amap.com/v3/place/polygon?output=JSON";

	/**
	 * ID查询
	 */
	String IDSEARCHURL = "https://restapi.amap.com/v3/place/detail?output=JSON";

	/**
	 * IP定位
	 */
	String IPURL = "https://restapi.amap.com/v3/ip?output=JSON";

	/**
	 * 抓路服务
	 */
	String AUTOGRASPURL = "https://restapi.amap.com/v3/autograsp?output=JSON";

	/**
	 * 静态地图
	 */
	String STATICMAPURL = "https://restapi.amap.com/v3/staticmap";
}
