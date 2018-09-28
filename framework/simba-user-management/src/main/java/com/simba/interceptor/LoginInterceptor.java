package com.simba.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.cache.RedisUtil;
import com.simba.common.EnvironmentUtil;
import com.simba.exception.ErrorCodeException;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.PathUtil;
import com.simba.model.constant.ConstantData;

/**
 * 登录的拦截器(如果用户没有传UUID)
 * 
 * @author lilei
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	private static final Log logger = LogFactory.getLog(LoginInterceptor.class);

	private static final String USERID = "userId";

	private String excludeUrls;

	private List<String> excludeUrlList;

	public LoginInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrls = environmentUtil.get("login.interceptor.exclude");
		String[] urls = excludeUrls.split(",");
		excludeUrlList = new ArrayList<>(urls.length);
		for (String url : urls) {
			excludeUrlList.add(url);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = getRequestUri(request);
		logger.info("==========登录拦截url==========" + requestUri);
		for (String url : excludeUrlList) {
			if (PathUtil.match(requestUri, url)) {
				return true;
			}
		}
		loginInterceptor(request, response);
		return true;
	}

	private void loginInterceptor(HttpServletRequest request, HttpServletResponse response) {
		RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);
		HttpSession session = request.getSession();
		String token = request.getHeader(ConstantData.MOBILE_SESSION_TOKEN_NAME);
		if (StringUtils.isEmpty(token)) {
			token = request.getParameter(ConstantData.MOBILE_SESSION_TOKEN_NAME);
		}
		logger.info("登录拦截器获取到token=" + token);
		if (StringUtils.isEmpty(token)) {
			throw new ErrorCodeException("没有发现token，请每次访问携带token", 401);
		}
		// 判断redis中token关联的userId是否存在，不存在就说明是伪造的token或者token失效
		if (StringUtils.isEmpty(redisUtil.get(token) + StringUtils.EMPTY)) {
			throw new ErrorCodeException("所发送的token已失效，请重新登录", 401);
		}
		// 判断session中的userId是否存在
		if (StringUtils.isEmpty(session.getAttribute(USERID) + StringUtils.EMPTY)) {
			// 说明登录状态过期，使用token保持登录状态
			session.setAttribute(USERID, Long.parseLong(redisUtil.get(token).toString()));
		} else {
			// 说明登录状态保持 不做操作即可
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
