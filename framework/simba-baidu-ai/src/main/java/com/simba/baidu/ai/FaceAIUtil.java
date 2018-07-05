package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.face.AipFace;

/**
 * 人脸识别接口工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class FaceAIUtil {

	private static final Log logger = LogFactory.getLog(FaceAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipFace aipFace;

	@PostConstruct
	private void init() {
		aipFace = new AipFace(appid, key, secret);
		// 可选：设置网络连接参数
		aipFace.setConnectionTimeoutInMillis(2000);
		aipFace.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI人脸识别完成");
	}

	public AipFace getAipFace() {
		return aipFace;
	}

}
