package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.ocr.AipOcr;

/**
 * 百度文字识别工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class OCRAIUtil {

	private static final Log logger = LogFactory.getLog(OCRAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipOcr aipOcr;

	public AipOcr getAipOcr() {
		return aipOcr;
	}

	@PostConstruct
	private void init() {
		aipOcr = new AipOcr(appid, key, secret);
		// 可选：设置网络连接参数
		aipOcr.setConnectionTimeoutInMillis(2000);
		aipOcr.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI文字识别完成");
	}

}
