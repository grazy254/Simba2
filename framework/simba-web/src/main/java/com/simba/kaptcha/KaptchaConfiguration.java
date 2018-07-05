package com.simba.kaptcha;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.simba.common.EnvironmentUtil;

/**
 * google验证码组件配置类
 * 
 * @author caozhejun
 *
 */
@Configuration
public class KaptchaConfiguration {

	private static final Log logger = LogFactory.getLog(KaptchaConfiguration.class);

	@Autowired
	private EnvironmentUtil environmentUtil;

	@Bean
	public ServletRegistrationBean druidServlet() {
		logger.info("=====================init google kaptcha Servlet Configuration =========================================");
		String height = StringUtils.defaultString(environmentUtil.get("kaptcha.height"), "50");
		String width = StringUtils.defaultString(environmentUtil.get("kaptcha.width"), "150");
		String length = StringUtils.defaultString(environmentUtil.get("kaptcha.length"), "6");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new KaptchaServlet());
		servletRegistrationBean.addUrlMappings("/kaptcha");
		Map<String, String> initParameters = new HashMap<String, String>();
		initParameters.put("kaptcha.image.width", width);
		initParameters.put("kaptcha.image.height", height);
		initParameters.put("kaptcha.textproducer.char.length", length);
		initParameters.put("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
		servletRegistrationBean.setInitParameters(initParameters);
		return servletRegistrationBean;
	}

}
