package com.simba.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * 内存对象池
 * 
 * @author caozhejun
 *
 */
@Component
@ConditionalOnProperty(prefix = "object", value = "storage", havingValue = "local")
public class MemoryObjectPool implements ObjectPoolInterface {

	private static final Log logger = LogFactory.getLog(MemoryObjectPool.class);

	private Map<String, Object> data = new ConcurrentHashMap<>();

	@PostConstruct
	private void init() {
		logger.info("=================初始化本地内存对象池=======================");
	}

	@Override
	public void save(String key, Object value) {
		data.put(key, value);
	}

	@Override
	public Object get(String key) {
		return data.get(key);
	}

	@Override
	public void remove(String key) {
		data.remove(key);
	}

}
