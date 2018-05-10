package com.simba.jwt.interceptor;

import java.util.ArrayList;
import java.util.Date;
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
import com.simba.jwt.util.JwtUtil;

import io.jsonwebtoken.Claims;

/**
 * JWT拦截器(请求头中authorization,值为bearer;token)
 * 
 * @author caozj
 */
public class JwtInterceptor implements HandlerInterceptor {

	private String excludeUrl;

	private List<String> excludeUrls = new ArrayList<String>();

	public JwtInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrl = environmentUtil.get("jwt.interceptor.exclude.url");
		String[] urls = excludeUrl.split(",");
		for (String url : urls) {
			if (StringUtils.isNotEmpty(url)) {
				excludeUrls.add(url.trim());
			}
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
		// 请求头信息authorization信息
		String authHeader = request.getHeader("authorization");
		if (StringUtils.isEmpty(authHeader)) {
			throw new ForbidException("请求头中没有带token信息");
		}
		if (authHeader == null || !authHeader.startsWith("bearer;")) {
			throw new ForbidException("请求头中token信息格式错误");
		}
		String token = authHeader.substring(7);
		Claims claims = JwtUtil.parseJWT(token);
		Date expiration = claims.getExpiration();
		if (expiration.before(new Date())) {
			throw new ForbidException("token已经过期");
		}
		String audience = claims.getAudience();
		String issuer = claims.getIssuer();
		String content = (String) claims.get("content");
		request.setAttribute("jwtTokenContent", content);
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
