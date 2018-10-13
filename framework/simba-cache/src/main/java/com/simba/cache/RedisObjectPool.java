package com.simba.cache;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Redis对象池
 * 
 * @author caozhejun
 *
 */
@Component
@ConditionalOnProperty(prefix = "object", value = "storage", havingValue = "redis")
public class RedisObjectPool implements ObjectPoolInterface {

	private static final Log logger = LogFactory.getLog(RedisObjectPool.class);

	@Resource
	private Redis redisUtil;

	@PostConstruct
	private void init() {
		logger.info("=================初始化Redis对象池=======================");
	}

	@Override
	public void save(String key, Object value) {
		redisUtil.set(key, value);
	}

	@Override
	public Object get(String key) {
		return redisUtil.get(key);
	}

	@Override
	public void remove(String key) {
		redisUtil.remove(key);
	}

}
