package com.simba.util;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.cache.RedisUtil;
import com.simba.framework.util.common.SystemUtil;

/**
 * 在线用户统计工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class OnlineUserUtil {

	@Autowired
	private RedisUtil redisUtil;

	private String getOnlineKey(String appid) throws UnknownHostException {
		return "simba:long:websocket:online_" + SystemUtil.getIpAddress() + "_" + SystemUtil.getMachineName() + "&" + appid;
	}

	private String getOfflineKey(String appid) throws UnknownHostException {
		return "simba:long:websocket:offline_" + SystemUtil.getIpAddress() + "_" + SystemUtil.getMachineName() + "&" + appid;
	}

	private String getOnlineKey() throws UnknownHostException {
		return "simba:long:websocket:online_" + SystemUtil.getIpAddress() + "_" + SystemUtil.getMachineName();
	}

	private String getOfflineKey() throws UnknownHostException {
		return "simba:long:websocket:offline_" + SystemUtil.getIpAddress() + "_" + SystemUtil.getMachineName();
	}

	/**
	 * 增加1个在线用户数
	 * 
	 * @param appid
	 * @throws UnknownHostException
	 */
	public void incrOnlineUser(String appid) throws UnknownHostException {
		String key = getOnlineKey(appid);
		redisUtil.getAutoId(key);
	}

	/**
	 * 增加1个离线用户数
	 * 
	 * @param appid
	 * @throws UnknownHostException
	 */
	public void incrOfflineUser(String appid) throws UnknownHostException {
		String key = getOfflineKey(appid);
		redisUtil.getAutoId(key);
	}

	/**
	 * 重置本机连接的在线用户数
	 * 
	 * @throws UnknownHostException
	 */
	public void reset() throws UnknownHostException {
		String onlineKey = getOnlineKey();
		String offlineKey = getOfflineKey();
		redisUtil.keys(onlineKey + "*").forEach((String key) -> {
			redisUtil.remove(key);
		});
		redisUtil.keys(offlineKey + "*").forEach((String key) -> {
			redisUtil.remove(key);
		});
	}

	@PostConstruct
	@PreDestroy
	public void init() throws UnknownHostException {
		this.reset();
	}

	/**
	 * 获取当前服务器在线用户数
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public long countCurrentSystemOnlineUser() throws UnknownHostException {
		String onlineKey = getOnlineKey();
		String offlineKey = getOfflineKey();
		List<String> onlineKeys = redisUtil.keys(onlineKey + "*");
		List<String> offlineKeys = redisUtil.keys(offlineKey + "*");
		long onlineCount = 0L;
		long offlineCount = 0L;
		for (String key : onlineKeys) {
			onlineCount += NumberUtils.toLong(redisUtil.getString(key));
		}
		for (String key : offlineKeys) {
			offlineCount += NumberUtils.toLong(redisUtil.getString(key));
		}
		return onlineCount - offlineCount;
	}

	/**
	 * 获取所有服务器在线用户数
	 * 
	 * @return
	 */
	public long countOnlineUser() {
		List<String> onlineKeys = redisUtil.keys("simba:long:websocket:online_" + "*");
		List<String> offlineKeys = redisUtil.keys("simba:long:websocket:offline_" + "*");
		long onlineCount = 0L;
		long offlineCount = 0L;
		for (String key : onlineKeys) {
			onlineCount += NumberUtils.toLong(redisUtil.getString(key));
		}
		for (String key : offlineKeys) {
			offlineCount += NumberUtils.toLong(redisUtil.getString(key));
		}
		return onlineCount - offlineCount;
	}

	/**
	 * 计算每个应用的在线用户数
	 * 
	 * @return
	 */
	public Map<String, Long> countOnlineUserByApp() {
		Map<String, Long> onlineMap = new HashMap<>();
		List<String> onlineKeys = redisUtil.keys("simba:long:websocket:online_" + "*");
		List<String> offlineKeys = redisUtil.keys("simba:long:websocket:offline_" + "*");
		onlineKeys.forEach((String key) -> {
			String[] split = key.split("&");
			String appid = split[1];
			Long count = onlineMap.get(appid);
			if (count == null) {
				count = 0L;
			}
			count = count + NumberUtils.toLong(redisUtil.getString(key));
			onlineMap.put(appid, count);
		});
		offlineKeys.forEach((String key) -> {
			String[] split = key.split("&");
			String appid = split[1];
			Long count = onlineMap.get(appid);
			if (count == null) {
				count = 0L;
			}
			count = count - NumberUtils.toLong(redisUtil.getString(key));
			onlineMap.put(appid, count);
		});
		return onlineMap;
	}
}
