package com.simba.framework.session.config;

import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.simba.framework.session.DisSessionListener;
import com.simba.framework.session.SessionFilter;

/**
 * session的配置类
 * 
 * @author caozhejun
 *
 */
@Configuration
public class SessionConfig {

	private static final Log log = LogFactory.getLog(SessionConfig.class);

	@Autowired
	private SessionFilter sessionFilter;

	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> disSessionListener() {
		log.info("=====================init session listener Configuration==============================");
		ServletListenerRegistrationBean<HttpSessionListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<HttpSessionListener>();
		servletListenerRegistrationBean.setListener(new DisSessionListener());
		return servletListenerRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		log.info("=====================init session filter Configuration==============================");
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setName("sessionFilter");
		filterRegistrationBean.setFilter(sessionFilter);
		filterRegistrationBean.addUrlPatterns("/*");
		return filterRegistrationBean;
	}
}
