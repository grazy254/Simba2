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
import com.simba.framework.util.data.ThreadDataUtil;
import com.simba.model.SmartUser;
import com.simba.service.SmartUserService;

/**
 * 线程变量注入的拦截器(如果用户登录，则将用户的对象set进去)
 * 
 * @author caozhejun
 *
 */
public class ThreadDataInterceptor implements HandlerInterceptor {

	private static final Log logger = LogFactory.getLog(ThreadDataInterceptor.class);

	private static final String USERID = "userId";

	private String excludeUrls;

	private List<String> excludeUrlList;

	private SmartUserService smartUserService = ApplicationContextUtil.getBean(SmartUserService.class);

	public ThreadDataInterceptor() {
		super();
		init();
	}

	private void init() {
		EnvironmentUtil environmentUtil = ApplicationContextUtil.getBean(EnvironmentUtil.class);
		excludeUrls = environmentUtil.get("user.threadData.interceptor.exclude.url");
		String[] urls = excludeUrls.split(",");
		excludeUrlList = new ArrayList<>(urls.length);
		for (String url : urls) {
			excludeUrlList.add(url);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = getRequestUri(request);
		for (String url : excludeUrlList) {
			if (PathUtil.match(requestUri, url)) {
				return true;
			}
		}
		threadDataInterceptor(request);
		return true;
	}

	private void threadDataInterceptor(HttpServletRequest request) {
		RedisUtil redisUtil = ApplicationContextUtil.getBean(RedisUtil.class);
		HttpSession session = request.getSession();
		Object userId = session.getAttribute(USERID);
		String token = request.getHeader("session_token");
		String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
		logger.info("userId:" + userId);
		logger.info("token:" + token);
		if (userId == null || StringUtils.isEmpty(userId + StringUtils.EMPTY)) {
			// 通过token获取userId
			if (token == null || redisUtil.get(token) == null) {
				throw new ErrorCodeException("您还未登录系统，无法set登录session进去" + url, 401);
			} else {
				userId = redisUtil.get(token);
				session.setAttribute(USERID, Long.parseLong(userId.toString()));
				logger.info("userId:" + userId.toString());
				ThreadDataUtil.set("account", smartUserService.get(Long.parseLong(userId.toString())));
				SmartUser smartUser = smartUserService.get(Long.parseLong(userId.toString()));
				if (smartUser == null) {
					session.removeAttribute(USERID);
					throw new ErrorCodeException("用户数据已经删除，请换其他账号登录", 401);
				}
				// 处于安全考虑，将密码设为空
				smartUser.setPassword(StringUtils.EMPTY);
				logger.info("已写入线程变量 --key=account value=" + smartUser);
			}
		} else {
			logger.info("userId:" + userId.toString());
			ThreadDataUtil.set("account", smartUserService.get(Long.parseLong(userId.toString())));
			SmartUser smartUser = smartUserService.get(Long.parseLong(userId.toString()));
			if (smartUser == null) {
				session.removeAttribute(USERID);
				throw new ErrorCodeException("用户数据已经删除，请换其他账号登录", 401);
			}
			// 处于安全考虑，将密码设为空
			smartUser.setPassword(StringUtils.EMPTY);
			logger.info("已写入线程变量 --key=account value=" + smartUser);
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
