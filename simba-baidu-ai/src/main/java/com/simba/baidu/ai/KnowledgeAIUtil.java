package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.kg.AipKnowledgeGraphic;

/**
 * 结构化数据抽取接口工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class KnowledgeAIUtil {

	private static final Log logger = LogFactory.getLog(KnowledgeAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipKnowledgeGraphic aipKnowledgeGraphic;

	@PostConstruct
	private void init() {
		aipKnowledgeGraphic = new AipKnowledgeGraphic(appid, key, secret);
		// 可选：设置网络连接参数
		aipKnowledgeGraphic.setConnectionTimeoutInMillis(2000);
		aipKnowledgeGraphic.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI结构化数据抽取完成");
	}

}
