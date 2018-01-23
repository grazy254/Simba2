package com.simba.weather.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.cache.Redis;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.model.constant.ConstantData;
import com.simba.weather.model.Weather;

/**
 * 查询天气工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class WeatherUtil {

	private static final String url = "http://www.sojson.com/open/api/weather/json.shtml?city=";

	private static final int timeout = 60 * 60;

	@Autowired
	private Redis redisUtil;

	/**
	 * 查询天气预报(返回昨天\今天\之后4天的天气情况)
	 * 
	 * @param city
	 *            城市(珠海)
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Weather get(String city) throws UnsupportedEncodingException {
		String today = DateUtil.date2String(new Date(), "yyyyMMddHH");
		String key = "weather_" + city + "_" + today;
		Weather weather = (Weather) redisUtil.get(key);
		if (weather == null) {
			String queryCityUrl = url + URLEncoder.encode(city, ConstantData.DEFAULT_CHARSET);
			String result = HttpClientUtil.get(queryCityUrl);
			if (StringUtils.isNotEmpty(result)) {
				weather = FastJsonUtil.toObject(result, Weather.class);
				redisUtil.set(key, weather, timeout);
			} else {
				weather = new Weather();
			}
		}
		return weather;
	}

}
