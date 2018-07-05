package com.simba.framework.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.CookieUtil;
import com.simba.model.constant.ConstantData;

public class DisSessionRequestWrapper extends HttpServletRequestWrapper {

	private static final Log logger = LogFactory.getLog(DisSessionRequestWrapper.class);

	private final String sid;

	private HttpSession session;

	private static int expiry = ConstantData.SESSION_TIMEOUT;

	private static boolean showLog = false;

	private static List<String> noShowLogUri = new ArrayList<>();

	public static void setNoShowLogUri(List<String> noShowLogUri) {
		DisSessionRequestWrapper.noShowLogUri = noShowLogUri;
	}

	public static void setShowLog(boolean show) {
		DisSessionRequestWrapper.showLog = show;
	}

	public static boolean IsShowLog(String requestUri) {
		boolean show = DisSessionRequestWrapper.showLog;
		if (show) {
			for (String uri : noShowLogUri) {
				if (requestUri.contains(uri)) {
					show = false;
					break;
				}
			}
		}
		return show;
	}

	public static void setExpiry(int expiry) {
		if (expiry < 100) {
			throw new IllegalArgumentException("session超时时间不能小于100[" + expiry + "].");
		}
		DisSessionRequestWrapper.expiry = expiry;
		logger.info("****************设置session过期时间为" + expiry);
	}

	protected HttpServletResponse response;

	public DisSessionRequestWrapper(HttpServletRequest request, HttpServletResponse response) {
		super(request);
		this.response = response;
		this.sid = this.createJsessionIdCookie();
	}

	private String createJsessionIdCookie() {
		String mobileSessionFlag = this.getHeader(ConstantData.MOBILE_SESSION_FLAG_NAME);
		if (StringUtils.isEmpty(mobileSessionFlag)) {
			mobileSessionFlag = this.getParameter(ConstantData.MOBILE_SESSION_FLAG_NAME);
		}
		if (IsShowLog(this.getRequestURI())) {
			logger.info("***********************************************App标识为:" + mobileSessionFlag + "," + this.getRequestURI());
		}
		String sid = null;
		if (StringUtils.isEmpty(mobileSessionFlag)) {
			sid = CookieUtil.getCookie(ConstantData.SESSIONID_COOKIE_NAME, this);
			if (IsShowLog(this.getRequestURI())) {
				logger.info("**************************浏览器获取sid为:" + sid + "," + this.getRequestURI());
			}
			if (StringUtils.isEmpty(sid)) {
				// 写cookie
				sid = java.util.UUID.randomUUID().toString();
				setSidToCookie(sid);
				if (IsShowLog(this.getRequestURI())) {
					logger.info("****************************写sid:" + sid + "进cookie" + "," + this.getRequestURI());
				}
			} else {
				setSidToCookie(sid);
			}
		} else {
			sid = this.getHeader(ConstantData.MOBILE_SESSION_TOKEN_NAME);
			if (StringUtils.isEmpty(sid)) {
				sid = this.getParameter(ConstantData.MOBILE_SESSION_TOKEN_NAME);
			}
			if (IsShowLog(this.getRequestURI())) {
				logger.info("**************************App获取sid为:" + sid + "," + this.getRequestURI());
			}
			if (StringUtils.isEmpty(sid)) {
				sid = java.util.UUID.randomUUID().toString();
				setTokenToHeader(sid);
				if (IsShowLog(this.getRequestURI())) {
					logger.info("****************************写sid:" + sid + "进header" + "," + this.getRequestURI());
				}
			} else {
				setTokenToHeader(sid);
			}
		}
		return sid;
	}

	private void setSidToCookie(String sid) {
		String domain = ApplicationContextUtil.getBean(EnvironmentUtil.class).get("cookie.domain");
		if (StringUtils.isEmpty(domain)) {
			CookieUtil.setCookie(ConstantData.SESSIONID_COOKIE_NAME, sid, DisSessionRequestWrapper.expiry / 1000, this, response);
		} else {
			CookieUtil.setCookie(ConstantData.SESSIONID_COOKIE_NAME, sid, DisSessionRequestWrapper.expiry / 1000, false, domain, response);
		}
		this.setAttribute(ConstantData.SESSIONID_COOKIE_NAME, sid);
	}

	private void setTokenToHeader(String sid) {
		response.addHeader(ConstantData.MOBILE_SESSION_TOKEN_NAME, sid);
		this.setAttribute(ConstantData.SESSIONID_COOKIE_NAME, sid);
	}

	@Override
	public HttpSession getSession(boolean create) {
		if (session != null) {
			return session;
		}
		if (create) {
			this.session = new HttpSessionWrapper(this.sid, expiry);
			return session;
		} else {
			return null;
		}
	}

	@Override
	public HttpSession getSession() {
		return this.getSession(true);
	}
}
