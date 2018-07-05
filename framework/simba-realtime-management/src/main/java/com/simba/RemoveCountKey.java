package com.simba;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.simba.cache.RedisUtil;

/**
 * 为了防止onlineCount和offlineCount数组溢出，当onlineCount和offlineCount相等时，remove掉这两个key
 * @author lilei
 *
 */
@Component
public class RemoveCountKey {

	private static final Log logger=LogFactory.getLog(RemoveCountKey.class);
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Scheduled(cron="0 0 3 * * *")
	private void  removeKey(){
		int onlineCount = 0;
		int offlineCount = 0;
		onlineCount=(Integer)redisUtil.get("onlineCount");
		offlineCount=(Integer)redisUtil.get("offlineCount");
		if(onlineCount==offlineCount){
			redisUtil.remove("onlineCount");
			redisUtil.remove("offlineCount");
			logger.info("清除onlineCount 和 offlineCount 这两个key");
		}
	} 
}
