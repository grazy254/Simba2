package com.simba.interptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.common.EnvironmentUtil;
import com.simba.exception.ForbidException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.PathUtil;

/**
 * 禁止访问拦截器
 * 
 * @author caozj
 */
public class ForbidInterceptor implements HandlerInterceptor {

	private String includeUrl;

	private List<String> includeUrls = new ArrayList<String>();

	public ForbidInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		includeUrl = environmentUtil.get("forbid.interceptor.include.url");
		if (StringUtils.isEmpty(includeUrl)) {
			return;
		}
		String[] urls = includeUrl.split(",");
		for (String url : urls) {
			if (StringUtils.isNotEmpty(url)) {
				includeUrls.add(url.trim());
			}
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = getRequestUri(request);
		for (String excludeUrl : includeUrls) {
			if (PathUtil.match(requestUri, excludeUrl)) {
				throw new ForbidException("不能访问" + requestUri);
			}
		}
		return true;
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
