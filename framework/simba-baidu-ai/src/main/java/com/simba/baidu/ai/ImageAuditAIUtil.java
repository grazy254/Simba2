package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.imagecensor.AipImageCensor;

/**
 * 百度AI图像审核工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class ImageAuditAIUtil {

	private static final Log logger = LogFactory.getLog(ImageAuditAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipImageCensor aipImageCensor;

	public AipImageCensor getAipImageCensor() {
		return aipImageCensor;
	}

	@PostConstruct
	private void init() {
		aipImageCensor = new AipImageCensor(appid, key, secret);
		// 可选：设置网络连接参数
		aipImageCensor.setConnectionTimeoutInMillis(2000);
		aipImageCensor.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI图像审核完成");
	}

}
