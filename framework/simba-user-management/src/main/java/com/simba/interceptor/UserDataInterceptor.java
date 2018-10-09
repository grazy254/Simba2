package com.simba.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.simba.framework.util.data.ThreadDataUtil;

/**
 * 登录用户数据的拦截器
 * 
 * @author caozj
 *
 */
public class UserDataInterceptor implements HandlerInterceptor {

	public UserDataInterceptor() {
		super();
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		loginUserDataInterceptor(request, response);
		return true;
	}

	private void loginUserDataInterceptor(HttpServletRequest request, HttpServletResponse response) {
		Object userId = request.getSession().getAttribute("userId");
		if (userId != null) {
			ThreadDataUtil.set("userId", userId);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

}
