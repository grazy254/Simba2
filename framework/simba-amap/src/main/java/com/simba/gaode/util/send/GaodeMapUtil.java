package com.simba.gaode.util.send;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.gaode.model.BusLineParam;
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

	public String bus(BusLineParam param) {
		String url = GaodeConstantData.BUSLINEURL + "&key=" + key + param.toParamUrl();
		return null;
	}

	public static void main(String[] args) {
		MapAddressPoint origin = new MapAddressPoint("113.561166", "22.267807");
		MapAddressPoint destination = new MapAddressPoint("113.552068", "22.247789");
		System.out.println("步行" + GaodeMapUtil.getInstance().walking(origin, destination));

		BusLineParam param = new BusLineParam(origin, destination, "珠海市");
		System.out.println("公交" + GaodeMapUtil.getInstance().bus(param));
	}

}