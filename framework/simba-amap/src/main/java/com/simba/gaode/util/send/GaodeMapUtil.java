package com.simba.gaode.util.send;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.gaode.model.MapAddressPoint;
import com.simba.gaode.model.area.AreaParam;
import com.simba.gaode.model.area.AreaResult;
import com.simba.gaode.model.around.AroundParam;
import com.simba.gaode.model.around.AroundResult;
import com.simba.gaode.model.bike.BikeResult;
import com.simba.gaode.model.bus.BusLineParam;
import com.simba.gaode.model.bus.BusResult;
import com.simba.gaode.model.distance.DistanceParam;
import com.simba.gaode.model.distance.DistanceResult;
import com.simba.gaode.model.drive.DriveLineParam;
import com.simba.gaode.model.drive.DriveResult;
import com.simba.gaode.model.geo.GeoParam;
import com.simba.gaode.model.geo.GeoResult;
import com.simba.gaode.model.geo.RegeoParam;
import com.simba.gaode.model.geo.RegeoResult;
import com.simba.gaode.model.keywords.KeyWordsParam;
import com.simba.gaode.model.keywords.KeyWordsResult;
import com.simba.gaode.model.truck.TruckParam;
import com.simba.gaode.model.truck.TruckResult;
import com.simba.gaode.model.walking.WalkingResult;
import com.simba.gaode.util.common.GaodeConstantData;

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
		key = "cc3ce763d853914058ea2fd86149678f";
		// EnvironmentUtil environmentUtil =
		// ApplicationContextUtil.getBean(EnvironmentUtil.class);
		// key = environmentUtil.get("gaode.map.web.api.key");
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
	 */
	public DistanceResult distance(DistanceParam param) {
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
	public AroundResult around(AroundParam param) throws UnsupportedEncodingException {
		String url = GaodeConstantData.AROUDURL + "&key=" + key + param.buildParamUrl();
		logger.info("提交高德地图[周边搜索]url:" + url);
		String res = HttpClientUtil.get(url);
		logger.info("提交高德地图[周边搜索]url:" + url + ",返回结果:" + res);
		AroundResult result = FastJsonUtil.toObject(res, AroundResult.class);
		return result;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		// MapAddressPoint origin = new MapAddressPoint("113.561166", "22.267807");
		// MapAddressPoint destination = new MapAddressPoint("113.552068", "22.247789");
		// logger.info("步行" + GaodeMapUtil.getInstance().walking(origin, destination));

		// BusLineParam param = new BusLineParam(origin, destination, "珠海市");
		// logger.info("公交" + GaodeMapUtil.getInstance().bus(param));
		//
		// DriveLineParam dparam = new DriveLineParam(origin.toString(), destination);
		// logger.info("驾车" + GaodeMapUtil.getInstance().drive(dparam));
		//
		// logger.info("骑行" + GaodeMapUtil.getInstance().bike(origin, destination));

		// TruckParam tparam = new TruckParam(origin, destination);
		// logger.info("货车" + GaodeMapUtil.getInstance().truck(tparam));

		// DistanceParam dparam = new DistanceParam("113.561166,22.267807",
		// destination,"1");
		// logger.info("距离测量" + GaodeMapUtil.getInstance().distance(dparam));

		// GeoParam gparam = new GeoParam("方恒国际中心A座");
		// logger.info("地理编码" + GaodeMapUtil.getInstance().geo(gparam));

		// RegeoParam rparam = new RegeoParam("113.561166,22.267807") ;
		// logger.info("逆地理编码" + GaodeMapUtil.getInstance().regeo(rparam));

		// logger.info("行政区域查询" + GaodeMapUtil.getInstance().area(new AreaParam()));

		// KeyWordsParam kparam = new KeyWordsParam();
		// kparam.setKeywords("天安门");
		// logger.info("关键字搜索" + GaodeMapUtil.getInstance().keywords(kparam));

		// AroundParam aparam = new AroundParam("113.561166,22.267807");
		// logger.info("周边搜索" + GaodeMapUtil.getInstance().around(aparam));

	}

}
