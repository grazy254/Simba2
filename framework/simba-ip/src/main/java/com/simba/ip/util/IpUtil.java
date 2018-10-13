package com.simba.ip.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.cache.Redis;
import com.simba.framework.util.http.HttpClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.ip.model.IpInfo;
import com.simba.ip.model.IpResult;

/**
 * ip地址查询地理信息工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class IpUtil {

	@Autowired
	private Redis redisUtil;

	private static final int timeout = 60 * 60;

	private static final String url = "http://ip.taobao.com/service/getIpInfo.php?ip=";

	private static final String[] innerIps = new String[] { "127", "192" };

	/**
	 * 根据ip地址查询地址位置信息
	 * 
	 * @param ip
	 * @return
	 */
	public IpInfo getAdress(String ip) {
		for (String innerIp : innerIps) {
			if (ip.startsWith(innerIp)) {
				return new IpInfo();
			}
		}
		String key = "ip_" + ip;
		IpResult result = (IpResult) redisUtil.get(key);
		if (result == null) {
			String resp = HttpClientUtil.get(url + ip);
			if (StringUtils.isNotEmpty(resp)) {
				result = FastJsonUtil.toObject(resp, IpResult.class);
				redisUtil.set(key, result, timeout);
			} else {
				result = new IpResult();
			}
		}
		return result.getData();
	}
}
