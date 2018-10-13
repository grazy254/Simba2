package com.simba.jobs;

import java.io.IOException;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.simba.service.GroupMessageService;

/**
 * 查询群发消息状态定时任务
 * 
 * @author caozhejun
 *
 */
@Component
public class GroupMessageJob {

	@Autowired
	private GroupMessageService groupMessageService;

	@Scheduled(cron = "0 0/2 * * * *")
	public void clearInvalidMedia() throws IOException, FastdfsException {
		groupMessageService.checkStatus();
	}

}
