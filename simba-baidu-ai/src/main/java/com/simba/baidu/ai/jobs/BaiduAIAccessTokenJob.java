package com.simba.baidu.ai.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.simba.baidu.ai.util.BaiduAiAccessTokenUtil;

/**
 * ai定时任务获取accesstoken
 * 
 * @author caozhejun
 *
 */
@Component
public class BaiduAIAccessTokenJob {

	@Value("${baidu.ai.token.job.enable}")
	private String enable;

	@Autowired
	private BaiduAiAccessTokenUtil baiduAiAccessTokenUtil;

	@Scheduled(fixedRate = 43200000, initialDelay = 5000)
	public void requestAccessToken() {
		if ("true".equals(enable)) {
			baiduAiAccessTokenUtil.requestAccessToken();
		}
	}

}
