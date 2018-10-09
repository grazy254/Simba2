package com.simba.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.common.EnvironmentUtil;
import com.simba.exception.ErrorCodeException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.PathUtil;

/**
 * 登录的拦截器
 * 
 * @author caozj
 *
 */
public class UserLoginInterceptor implements HandlerInterceptor {

	private static final Log logger = LogFactory.getLog(UserLoginInterceptor.class);

	private String excludeUrls;

	private List<String> excludeUrlList;

	public UserLoginInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrls = environmentUtil.get("user.login.interceptor.exclude");
		String[] urls = excludeUrls.split(",");
		excludeUrlList = new ArrayList<>(urls.length);
		for (String url : urls) {
			excludeUrlList.add(url);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = getRequestUri(request);
		logger.debug("===========================访问服务器" + getRequestUri(request) + "=====================");
		Map<String, String[]> map = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			logger.debug("Key = " + entry.getKey());
			for (int i = 0; i < entry.getValue().length; i++) {
				logger.debug("Value = " + entry.getValue()[i]);
			}
		}
		for (String url : excludeUrlList) {
			if (PathUtil.match(requestUri, url)) {
				return true;
			}
		}
		loginInterceptor(request, response);
		return true;
	}

	private void loginInterceptor(HttpServletRequest request, HttpServletResponse response) {
		Object userId = request.getSession().getAttribute("userId");
		if (userId == null) {
			throw new ErrorCodeException("用户没有登录", 401);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	/**
	 * 从request中取出uri.经过处理，已经过滤了上下文路径
	 * 
	 * @param request
	 * @return
	 */
	private String getRequestUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtils.isNotEmpty(contextPath) && !"/".equals(contextPath)) {
			uri = uri.substring(contextPath.length());
		}
		return uri;
	}
}
