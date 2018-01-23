package com.simba.framework.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.simba.common.EnvironmentUtil;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.common.CookieUtil;
import com.simba.model.constant.ConstantData;

public class DisSessionRequestWrapper extends HttpServletRequestWrapper {

	private final String sid;

	private HttpSession session;

	private static int expiry = ConstantData.SESSION_TIMEOUT;

	public static void setExpiry(int expiry) {
		if (expiry < 100) {
			throw new IllegalArgumentException("session超时时间不能小于100[" + expiry + "].");
		}
		DisSessionRequestWrapper.expiry = expiry;
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
		String sid = null;
		if (StringUtils.isEmpty(mobileSessionFlag)) {
			sid = CookieUtil.getCookie(ConstantData.SESSIONID_COOKIE_NAME, this);
			if (StringUtils.isEmpty(sid)) {
				// 写cookie
				sid = java.util.UUID.randomUUID().toString();
				String domain = ApplicationContextUtil.getBean(EnvironmentUtil.class).get("cookie.domain");
				if (StringUtils.isEmpty(domain)) {
					CookieUtil.setCookie(ConstantData.SESSIONID_COOKIE_NAME, sid, this, response);
				} else {
					CookieUtil.setCookie(ConstantData.SESSIONID_COOKIE_NAME, sid, 86400, false, domain, response);
				}
				this.setAttribute(ConstantData.SESSIONID_COOKIE_NAME, sid);
			}
		} else {
			sid = this.getHeader(ConstantData.MOBILE_SESSION_TOKEN_NAME);
			if (StringUtils.isEmpty(sid)) {
				sid = this.getParameter(ConstantData.MOBILE_SESSION_TOKEN_NAME);
			}
			if (StringUtils.isEmpty(sid)) {
				sid = java.util.UUID.randomUUID().toString();
				response.addHeader(ConstantData.MOBILE_SESSION_TOKEN_NAME, sid);
				this.setAttribute(ConstantData.SESSIONID_COOKIE_NAME, sid);
			}
		}
		return sid;
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
