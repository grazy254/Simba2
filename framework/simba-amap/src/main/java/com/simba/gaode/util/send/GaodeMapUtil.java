package com.simba.gaode.util.send;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.gaode.model.MapAddressPoint;
import com.simba.gaode.model.area.AreaParam;
import com.simba.gaode.model.area.AreaResult;
import com.simba.gaode.model.around.AroundParam;
import com.simba.gaode.model.autograsp.AutoGraspParam;
import com.simba.gaode.model.autograsp.AutoGraspResult;
import com.simba.gaode.model.bike.BikeResult;
import com.simba.gaode.model.bus.BusLineParam;
import com.simba.gaode.model.bus.BusResult;
import com.simba.gaode.model.converter.MapConverterResult;
import com.simba.gaode.model.correct.CorrectData;
import com.simba.gaode.model.correct.CorrectResult;
import com.simba.gaode.model.distance.DistanceParam;
import com.simba.gaode.model.distance.DistanceResult;
import com.simba.gaode.model.drive.DriveLineParam;
import com.simba.gaode.model.drive.DriveResult;
import com.simba.gaode.model.fence.CreateFenceResult;
import com.simba.gaode.model.fence.FenceParam;
import com.simba.gaode.model.fence.FenceResult;
import com.simba.gaode.model.fence.MonitorFenceParam;
import com.simba.gaode.model.fence.MonitorFenceResult;
import com.simba.gaode.model.fence.QueryFenceParam;
import com.simba.gaode.model.fence.QueryFenceResult;
import com.simba.gaode.model.geo.GeoParam;
import com.simba.gaode.model.geo.GeoResult;
import com.simba.gaode.model.geo.RegeoParam;
import com.simba.gaode.model.geo.RegeoResult;
import com.simba.gaode.model.ip.IPResult;
import com.simba.gaode.model.keywords.KeyWordsParam;
import com.simba.gaode.model.keywords.KeyWordsResult;
import com.simba.gaode.model.polygon.PolygonParam;
import com.simba.gaode.model.staticmap.StaticMapParam;
import com.simba.gaode.model.status.CircleStatusParam;
import com.simba.gaode.model.status.ReactangleStatusParam;
import com.simba.gaode.model.status.RoadStatusParam;
import com.simba.gaode.model.status.StatusResult;
import com.simba.gaode.model.tip.TipParam;
import com.simba.gaode.model.tip.TipResult;
import com.simba.gaode.model.truck.TruckParam;
import com.simba.gaode.model.truck.TruckResult;
import com.simba.gaode.model.walking.WalkingResult;
import com.simba.gaode.model.weather.WeatherResult;
import com.simba.gaode.util.common.GaodeConstantData;
import com.simba.model.constant.ConstantData;

/**
 * 高德地图Java版Web Api 工具类
 * 
 * @author caozhejun
 *
 */
public class GaodeMapUtil {

	private static final Log logger = LogFactory.getLog(GaodeMapUtil.class);

	private String key;

	private GaodeMapUtil() {
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		key = environmentUtil.get("gaode.map.web.api.key");
	}

	private static final class GaodeMapUtilHolder {
		private static final GaodeMapUtil instance = new GaodeMapUtil();
	}

	public static GaodeMapUtil getInstance() {
		return GaodeMapUtilHolder.instance;
	}

	/**
	 * 步行路径规划
	 * 
	 * @param origin
	 *            出发点
	 * @param destination
	 *            目的地
	 * @return
	 */
	public WalkingResult walking(MapAddressPoint origin, MapAddressPoint destination) {
		String url = GaodeConstantData.WORKLINEURL + "&key=" + key + "&origin=" + origin.toString() + "&destination=" + destination.toString();
		logger.info("提交高德地图[步行路径规划]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[步行路径规划]url:" + url + ",返回结果:" + res);
		WalkingResult result = FastJsonUtil.toObject(res, WalkingResult.class);
		return result;
	}

	/**
	 * 公交路径规划
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public BusResult bus(BusLineParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.BUSLINEURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[公交路径规划]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[公交路径规划]url:" + url + ",返回结果:" + res);
		BusResult result = FastJsonUtil.toObject(res, BusResult.class);
		return result;
	}

	/**
	 * 驾车路径规划
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public DriveResult drive(DriveLineParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.DRIVEURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[驾车路径规划]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[驾车路径规划]url:" + url + ",返回结果:" + res);
		DriveResult result = FastJsonUtil.toObject(res, DriveResult.class);
		return result;
	}

	/**
	 * 骑行路径规划
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public BikeResult bike(MapAddressPoint origin, MapAddressPoint destination) {
		String url = GaodeConstantData.BIKEURL + "&key=" + key + "&origin=" + origin.toString() + "&destination=" + destination.toString();
		logger.info("提交高德地图[骑行路径规划]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[骑行路径规划]url:" + url + ",返回结果:" + res);
		BikeResult result = FastJsonUtil.toObject(res, BikeResult.class);
		return result;
	}

	/**
	 * 货车路径规划
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public TruckResult truck(TruckParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.TRUCKURL + "?key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[货车路径规划]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[货车路径规划]url:" + url + ",返回结果:" + res);
		TruckResult result = FastJsonUtil.toObject(res, TruckResult.class);
		return result;
	}

	/**
	 * 距离测量
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public DistanceResult distance(DistanceParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.DISTANCEURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[距离测量]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[距离测量]url:" + url + ",返回结果:" + res);
		DistanceResult result = FastJsonUtil.toObject(res, DistanceResult.class);
		return result;
	}

	/**
	 * 地理编码
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public GeoResult geo(GeoParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.GEOURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[地理编码]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[地理编码]url:" + url + ",返回结果:" + res);
		GeoResult result = FastJsonUtil.toObject(res, GeoResult.class);
		return result;
	}

	/**
	 * 行政区域查询
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public AreaResult area(AreaParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.AREAURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[行政区域查询]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[行政区域查询]url:" + url + ",返回结果:" + res);
		AreaResult result = FastJsonUtil.toObject(res, AreaResult.class);
		return result;
	}

	/**
	 * 逆地理编码
	 * 
	 * @param param
	 * @return
	 */
	public RegeoResult regeo(RegeoParam param) {
		String url = GaodeConstantData.REGEOURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[逆地理编码]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[逆地理编码]url:" + url + ",返回结果:" + res);
		RegeoResult result = FastJsonUtil.toObject(res, RegeoResult.class);
		return result;
	}

	/**
	 * 关键字搜索
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public KeyWordsResult keywords(KeyWordsParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.KEYWORDSURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[关键字搜索]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[关键字搜索]url:" + url + ",返回结果:" + res);
		KeyWordsResult result = FastJsonUtil.toObject(res, KeyWordsResult.class);
		return result;
	}

	/**
	 * 周边搜索
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public KeyWordsResult around(AroundParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.AROUDURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[周边搜索]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[周边搜索]url:" + url + ",返回结果:" + res);
		KeyWordsResult result = FastJsonUtil.toObject(res, KeyWordsResult.class);
		return result;
	}

	/**
	 * 多边形搜索
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public KeyWordsResult polygon(PolygonParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.POLYGONURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[多边形搜索]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[多边形搜索]url:" + url + ",返回结果:" + res);
		KeyWordsResult result = FastJsonUtil.toObject(res, KeyWordsResult.class);
		return result;
	}

	/**
	 * ID查询
	 * 
	 * @param id
	 * @return
	 */
	public KeyWordsResult idSearch(String id) {
		String url = GaodeConstantData.IDSEARCHURL + "&key=" + key + "&id=" + id;
		logger.info("提交高德地图[ID查询]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[ID查询]url:" + url + ",返回结果:" + res);
		KeyWordsResult result = FastJsonUtil.toObject(res, KeyWordsResult.class);
		return result;
	}

	/**
	 * IP定位查询
	 * 
	 * @param ip
	 * @return
	 */
	public IPResult ip(String ip) {
		String url = GaodeConstantData.IPURL + "&key=" + key;
		if (StringUtils.isNotEmpty(ip)) {
			url = url + "&ip=" + ip;
		}
		logger.info("提交高德地图[IP定位查询]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[IP定位查询]url:" + url + ",返回结果:" + res);
		IPResult result = FastJsonUtil.toObject(res, IPResult.class);
		return result;
	}

	/**
	 * 抓路服务
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public AutoGraspResult autoGrasp(AutoGraspParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.AUTOGRASPURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[抓路服务]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[抓路服务]url:" + url + ",返回结果:" + res);
		AutoGraspResult result = FastJsonUtil.toObject(res, AutoGraspResult.class);
		return result;
	}

	/**
	 * 静态地图
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public byte[] staticMap(StaticMapParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.STATICMAPURL + "?key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[静态地图]url:" + url);
		byte[] result = HttpClientUtil.getBytes(url);
		logger.info("提交高德地图[静态地图]url:" + url + "地图图片生成完成");
		return result;
	}

	/**
	 * 坐标转换
	 * 
	 * @param locations
	 *            坐标点
	 *            经度和纬度用","分割，经度在前，纬度在后，经纬度小数点后不得超过6位。多个坐标对之间用”|”进行分隔最多支持40对坐标。
	 * @param coordsys
	 *            原坐标系 可选值： gps; mapbar; baidu; autonavi(不进行转换)
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public MapConverterResult converter(String locations, String coordsys) throws UnsupportedEncodingException {
		String url = GaodeConstantData.CONVERTERURL + "&key=" + key + "&locations=" + URLEncoder.encode(locations, ConstantData.DEFAULT_CHARSET) + "&coordsys=" + coordsys;
		logger.info("提交高德地图[坐标转换]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[坐标转换]url:" + url + ",返回结果:" + res);
		MapConverterResult result = FastJsonUtil.toObject(res, MapConverterResult.class);
		return result;
	}

	/**
	 * 天气查询
	 * 
	 * @param city
	 *            城市名称 输入adcode
	 * @param extensions
	 *            气象类型 可选值：base/all base:返回实况天气 all:返回预报天气
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public WeatherResult weather(String city, String extensions) throws UnsupportedEncodingException {
		String url = GaodeConstantData.WEATHERURL + "&key=" + key + "&city=" + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET) + "&extensions=" + extensions;
		logger.info("提交高德地图[天气查询]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[天气查询]url:" + url + ",返回结果:" + res);
		WeatherResult result = FastJsonUtil.toObject(res, WeatherResult.class);
		return result;
	}

	/**
	 * 输入提示
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public TipResult tip(TipParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.TIPURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[输入提示]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[输入提示]url:" + url + ",返回结果:" + res);
		TipResult result = FastJsonUtil.toObject(res, TipResult.class);
		return result;
	}

	/**
	 * 矩形区域交通态势
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public StatusResult reactangle(ReactangleStatusParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.REACTANGLESTATUSURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[矩形区域交通态势]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[矩形区域交通态势]url:" + url + ",返回结果:" + res);
		StatusResult result = FastJsonUtil.toObject(res, StatusResult.class);
		return result;
	}

	/**
	 * 圆形区域交通态势
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public StatusResult circle(CircleStatusParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.CIRCLESTATUSURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[圆形区域交通态势]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[圆形区域交通态势]url:" + url + ",返回结果:" + res);
		StatusResult result = FastJsonUtil.toObject(res, StatusResult.class);
		return result;
	}

	/**
	 * 指定线路交通态势
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public StatusResult road(RoadStatusParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.ROADSTATUSURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[指定线路交通态势]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[指定线路交通态势]url:" + url + ",返回结果:" + res);
		StatusResult result = FastJsonUtil.toObject(res, StatusResult.class);
		return result;
	}

	/**
	 * 创建围栏
	 * 
	 * @param param
	 * @return
	 */
	public CreateFenceResult createFence(FenceParam param) {
		String url = GaodeConstantData.CREATEFENCEURL + "?key=" + key;
		String json = param.toJson();
		String res = HttpClientUtil.postJson(url, json);
		logger.info("提交高德地图[创建围栏]url:" + url + ",返回结果:" + res);
		CreateFenceResult result = FastJsonUtil.toObject(res, CreateFenceResult.class);
		return result;
	}

	/**
	 * 查询围栏
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public QueryFenceResult queryFence(QueryFenceParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.QUERYFENCEURL + "?key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[查询围栏]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[查询围栏]url:" + url + ",返回结果:" + res);
		QueryFenceResult result = FastJsonUtil.toObject(res, QueryFenceResult.class);
		return result;
	}

	/**
	 * 更新围栏
	 * 
	 * @param gid
	 *            围栏全局id
	 * @param param
	 * @return
	 */
	public FenceResult updateFence(String gid, FenceParam param) {
		String url = GaodeConstantData.UPDATEFENCEURL + "&key=" + key + "&gid=" + gid;
		String json = param.toJson();
		String res = HttpClientUtil.postJson(url, json);
		logger.info("提交高德地图[更新围栏]url:" + url + ",返回结果:" + res);
		FenceResult result = FastJsonUtil.toObject(res, FenceResult.class);
		return result;
	}

	/**
	 * 围栏启动&停止
	 * 
	 * @param gid
	 *            围栏全局id
	 * @param enable
	 *            围栏激活状态；不能与更新围栏参数同时存在
	 * @return
	 */
	public FenceResult enableFence(String gid, boolean enable) {
		String url = GaodeConstantData.ENABLEFENCEURL + "&key=" + key + "&gid=" + gid;
		Map<String, Object> param = new HashMap<>();
		param.put("enable", enable);
		String json = FastJsonUtil.toJson(param);
		String res = HttpClientUtil.postJson(url, json);
		logger.info("提交高德地图[围栏启动&停止]url:" + url + ",返回结果:" + res);
		FenceResult result = FastJsonUtil.toObject(res, FenceResult.class);
		return result;
	}

	/**
	 * 删除围栏
	 * 
	 * @param gid
	 *            围栏全局id
	 * @return
	 */
	public FenceResult deleteFence(String gid) {
		String url = GaodeConstantData.DELETEFENCEURL + "&key=" + key + "&gid=" + gid;
		String res = HttpClientUtil.post(url);
		logger.info("提交高德地图[删除围栏]url:" + url + ",返回结果:" + res);
		FenceResult result = FastJsonUtil.toObject(res, FenceResult.class);
		return result;
	}

	/**
	 * 围栏设备监控
	 * 
	 * @param param
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public MonitorFenceResult monitorFence(MonitorFenceParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.MONITORFENCEURL + "?key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[围栏设备监控]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[围栏设备监控]url:" + url + ",返回结果:" + res);
		MonitorFenceResult result = FastJsonUtil.toObject(res, MonitorFenceResult.class);
		return result;
	}

	/**
	 * 轨迹纠偏
	 * 
	 * @param datas
	 * @return
	 */
	public CorrectResult correct(List<CorrectData> datas) {
		String url = GaodeConstantData.CORRECTIONDRIVEURL + "?key=" + key;
		String json = FastJsonUtil.toJson(datas);
		String res = HttpClientUtil.postJson(url, json);
		logger.info("提交高德地图[轨迹纠偏]url:" + url + ",json:" + json + ",返回结果:" + res);
		CorrectResult result = FastJsonUtil.toObject(res, CorrectResult.class);
		return result;
	}

}
