package com.simba.baidu.ai;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baidu.aip.nlp.AipNlp;

/**
 * 百度AI语言处理工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class WordsAIUtil {

	private static final Log logger = LogFactory.getLog(WordsAIUtil.class);

	@Value("${baidu.ai.appid}")
	private String appid;

	@Value("${baidu.ai.key}")
	private String key;

	@Value("${baidu.ai.secret}")
	private String secret;

	private AipNlp aipNlp;

	public AipNlp getAipNlp() {
		return aipNlp;
	}

	@PostConstruct
	private void init() {
		aipNlp = new AipNlp(appid, key, secret);
		// 可选：设置网络连接参数
		aipNlp.setConnectionTimeoutInMillis(2000);
		aipNlp.setSocketTimeoutInMillis(60000);
		logger.info("初始化百度AI语言处理完成");
	}

}
