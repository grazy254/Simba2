package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.speech.AipSpeech;

/**
 * 百度语音AI工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class VoiceAIUtil {

	private static final Log logger = LogFactory.getLog(VoiceAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipSpeech aipSpeech;

	public AipSpeech getAipSpeech() {
		return aipSpeech;
	}

	@PostConstruct
	private void init() {
		aipSpeech = new AipSpeech(appid, key, secret);
		// 可选：设置网络连接参数
		aipSpeech.setConnectionTimeoutInMillis(2000);
		aipSpeech.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI语音识别完成");
	}

}
