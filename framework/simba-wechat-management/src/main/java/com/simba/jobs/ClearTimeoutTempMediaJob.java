package com.simba.jobs;

import java.io.IOException;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.simba.service.TempMediaService;

/**
 * 定时清理过期的临时素材
 * 
 * @author caozhejun
 *
 */
@Component
public class ClearTimeoutTempMediaJob {

	@Autowired
	private TempMediaService service;

	@Scheduled(cron="0 0/1 * * * *")
	public void clearInvalidMedia() throws IOException, FastdfsException {
		service.clearInvalidMedia();
	}

}
