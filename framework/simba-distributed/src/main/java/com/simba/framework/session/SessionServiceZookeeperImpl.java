package com.simba.framework.session;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.simba.framework.session.zookeeper.ZooKeeperSessionHelper;

/**
 * SessionService的zookeeper实现
 * 
 * @author caozj
 *
 */
@Component
@ConditionalOnProperty(prefix = "distribute", value = "type", havingValue = "zookeeper")
public class SessionServiceZookeeperImpl implements SessionService {

	private static final Log logger = LogFactory.getLog(SessionServiceZookeeperImpl.class);

	@PostConstruct
	private void init() {
		logger.info("**************初始化Zookeeper Session****************");
	}

	@Autowired
	private ZooKeeperSessionHelper zooKeeperSessionHelper;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getSession(String sid) {
		return (Map<String, Object>) zooKeeperSessionHelper.get(getSessionKey(sid));
	}

	@Override
	public void saveSession(String sid, Map<String, Object> session, int seconds) {
		zooKeeperSessionHelper.save(getSessionKey(sid), session);
	}

	@Override
	public void removeSession(String sid) {
		zooKeeperSessionHelper.delete(getSessionKey(sid));
	}

	private String getSessionKey(String sid) {
		return ZooKeeperSessionHelper.rootPath + "/" + sid;
	}

}
