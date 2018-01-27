package com.simba.framework.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.common.EnvironmentUtil;
import com.simba.model.constant.ConstantData;

@Component("sessionFilter")
public class SessionFilter implements Filter {

	@Autowired
	private EnvironmentUtil util;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (util == null) {
			return;
		}
		String expiredTime = util.get("session.expired.time");
		if (StringUtils.isNotEmpty(expiredTime)) {
			DisSessionRequestWrapper.setExpiry(NumberUtils.toInt(expiredTime, ConstantData.SESSION_TIMEOUT));
		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		SessionRequestWrapper httpRequestWraper = new SessionRequestWrapper(request, response);
		chain.doFilter(httpRequestWraper, response);
	}

	@Override
	public void destroy() {

	}

}
