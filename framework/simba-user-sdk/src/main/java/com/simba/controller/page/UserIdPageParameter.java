package com.simba.controller.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.simba.framework.session.page.PageParameter;

@Component
public class UserIdPageParameter implements PageParameter {

	@Override
	public String getKey() {
		return "sessUserId";
	}

	@Override
	public String getValue(HttpServletRequest request, HttpServletResponse response) {
		Object userId = request.getSession().getAttribute("userId");
		return userId + StringUtils.EMPTY;
	}

}
