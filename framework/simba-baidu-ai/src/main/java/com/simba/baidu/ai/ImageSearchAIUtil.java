package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.imagesearch.AipImageSearch;

/**
 * 百度AI图片检索工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class ImageSearchAIUtil {

	private static final Log logger = LogFactory.getLog(ImageSearchAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipImageSearch aipImageSearch;

	public AipImageSearch getAipImageSearch() {
		return aipImageSearch;
	}

	@PostConstruct
	private void init() {
		aipImageSearch = new AipImageSearch(appid, key, secret);
		// 可选：设置网络连接参数
		aipImageSearch.setConnectionTimeoutInMillis(2000);
		aipImageSearch.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI图片检索完成");
	}

}
