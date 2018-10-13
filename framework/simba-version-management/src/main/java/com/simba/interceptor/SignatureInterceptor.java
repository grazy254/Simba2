package com.simba.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.common.PathUtil;

/**
 * 加密拦截器
 * 
 * @author caozj
 */
public class SignatureInterceptor implements HandlerInterceptor {

	private String excludeUrl;

	private String key;

	private List<String> excludeUrls = new ArrayList<String>();

	public SignatureInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrl = environmentUtil.get("signature.interceptor.exclude");
		key = environmentUtil.get("app.url.signature.key");

		String[] urls = excludeUrl.split(",");
		for (String url : urls) {
			excludeUrls.add(url);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = getRequestUri(request);
		for (String excludeUrl : excludeUrls) {
			if (PathUtil.match(requestUri, excludeUrl)) {
				return true;
			}
		}
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		if (StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(signature)) {
			return false;
		}
		String md5 = EncryptUtil.md5(timestamp + key);
		return md5.equalsIgnoreCase(signature);
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
	public static String getRequestUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (StringUtils.isNotEmpty(contextPath) && !"/".equals(contextPath)) {
			uri = uri.substring(contextPath.length());
		}
		return uri;
	}

}
