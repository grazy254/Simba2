package com.simba.framework.session;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.simba.cache.Redis;

/**
 * SessionService的redis实现
 * 
 * @author caozj
 *
 */
@Component
@ConditionalOnProperty(prefix = "distribute", value = "type", havingValue = "redis")
public class SessionServiceRedisImpl implements SessionService {

	private static final Log logger = LogFactory.getLog(SessionServiceRedisImpl.class);

	@Resource
	private Redis redisUtil;

	@PostConstruct
	private void init() {
		logger.info("**************初始化Redis Session****************");
	}

	/**
	 * 根据session id获取session key.
	 * 
	 * @param sid
	 * @return
	 */
	private String getSessionKey(String sid) {
		return "Simba:Object:Sid:" + sid;
	}

	/**
	 * 根据session id获取session对象.
	 * 
	 * @param sid
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSession(String sid) {
		String key = this.getSessionKey(sid);
		return (Map<String, Object>) (redisUtil.get(key));
	}

	/**
	 * 保存Session对象.
	 * 
	 * @param sid
	 *            id
	 * @param session
	 *            map对象
	 * @param seconds
	 *            保存时间
	 */
	public void saveSession(String sid, Map<String, Object> session, int seconds) {
		String key = this.getSessionKey(sid);
		redisUtil.set(key, session, seconds);
	}

	/**
	 * 移除session对象.
	 * 
	 * @param sid
	 */
	public void removeSession(String sid) {
		String key = this.getSessionKey(sid);
		redisUtil.remove(key);
	}

}
