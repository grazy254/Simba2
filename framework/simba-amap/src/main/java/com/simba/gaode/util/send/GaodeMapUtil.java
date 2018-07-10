package com.simba.gaode.util.send;

import java.io.UnsupportedEncodingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.gaode.BikeResult;
import com.simba.gaode.model.BusLineParam;
import com.simba.gaode.model.BusResult;
import com.simba.gaode.model.DriveLineParam;
import com.simba.gaode.model.DriveResult;
import com.simba.gaode.model.MapAddressPoint;
import com.simba.gaode.model.WalkingResult;
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

	public static void main(String[] args) throws UnsupportedEncodingException {
		MapAddressPoint origin = new MapAddressPoint("113.561166", "22.267807");
		MapAddressPoint destination = new MapAddressPoint("113.552068", "22.247789");
		logger.info("步行" + GaodeMapUtil.getInstance().walking(origin, destination));

		BusLineParam param = new BusLineParam(origin, destination, "珠海市");
		logger.info("公交" + GaodeMapUtil.getInstance().bus(param));

		DriveLineParam dparam = new DriveLineParam(origin.toString(), destination);
		logger.info("驾车" + GaodeMapUtil.getInstance().drive(dparam));

		logger.info("骑行" + GaodeMapUtil.getInstance().bike(origin, destination));
	}

}
