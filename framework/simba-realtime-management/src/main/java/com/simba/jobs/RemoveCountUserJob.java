package com.simba.jobs;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.simba.util.OnlineUserUtil;

/**
 * 为了防止onlineCount和offlineCount数组溢出，当onlineCount和offlineCount相等时，remove掉这两个key
 * 
 * @author lilei
 *
 */
@Component
public class RemoveCountUserJob {

	@Autowired
	private OnlineUserUtil onlineUserUtil;

	@Scheduled(cron = "0 0 3 * * *")
	private void removeKey() throws UnknownHostException {
		long count = onlineUserUtil.countCurrentSystemOnlineUser();
		if (count == 0) {
			onlineUserUtil.reset();
		}
	}
}
