package com.simba.framework.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.common.EnvironmentUtil;
import com.simba.model.constant.ConstantData;

@Component("sessionFilter")
public class SessionFilter implements Filter {

	private static final Log logger = LogFactory.getLog(SessionFilter.class);

	@Autowired
	private EnvironmentUtil util;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if (util == null) {
			return;
		}
		String expiredTime = util.get("session.expired.time");
		logger.info("*****************获取配置文件设置session过期时间为:" + expiredTime);
		if (StringUtils.isNotEmpty(expiredTime)) {
			DisSessionRequestWrapper.setExpiry(NumberUtils.toInt(expiredTime, ConstantData.SESSION_TIMEOUT));
		}
		String log = util.get("session.log");
		if (StringUtils.isNotEmpty(log)) {
			DisSessionRequestWrapper.setShowLog("true".equals(log));
		}
		String noShowLogUrls = util.get("session.no.show.log.urls");
		if (StringUtils.isNotEmpty(noShowLogUrls)) {
			String[] urls = noShowLogUrls.split(",");
			List<String> noShowLogUri = new ArrayList<>(urls.length);
			for (String url : urls) {
				if (StringUtils.isNotBlank(url)) {
					noShowLogUri.add(url.trim());
				}
			}
			DisSessionRequestWrapper.setNoShowLogUri(noShowLogUri);
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
