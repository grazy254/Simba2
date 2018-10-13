package com.simba.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.exception.LoginException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.PathUtil;
import com.simba.framework.util.common.ServerUtil;
import com.simba.util.SessionUtil;

/**
 * 系统登陆拦截器
 * 
 * @author caozj
 */
public class LoginInterceptor implements HandlerInterceptor {

	private static final Log logger = LogFactory.getLog(LoginInterceptor.class);

	private String excludeUrl;

	private List<String> excludeUrls = new ArrayList<String>();

	public LoginInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrl = environmentUtil.get("login.interceptor.exclude");
		String[] urls = excludeUrl.split(",");
		for (String url : urls) {
			excludeUrls.add(url);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = SessionUtil.getRequestUri(request);
		for (String excludeUrl : excludeUrls) {
			if (PathUtil.match(requestUri, excludeUrl)) {
				return true;
			}
		}
		if (SessionUtil.isLogin(request.getSession())) {
			return true;
		}
		logger.error("****************************用户[" + ServerUtil.getProxyIp(request) + "]还未登陆系统,所以不能访问" + requestUri + "*******************************");
		throw new LoginException("您还未登陆系统,所以不能访问" + requestUri);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.debug("================登录拦截器执行afterCompletion==============================" + request.getRequestURI());
	}

}
