package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * 百度AI图像识别工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class ImageAIUtil {

	private static final Log logger = LogFactory.getLog(ImageAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipImageClassify aipImageClassify;

	public AipImageClassify getAipImageClassify() {
		return aipImageClassify;
	}

	@PostConstruct
	private void init() {
		aipImageClassify = new AipImageClassify(appid, key, secret);
		// 可选：设置网络连接参数
		aipImageClassify.setConnectionTimeoutInMillis(2000);
		aipImageClassify.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI图像识别完成");
	}

}
