package com.simba.jwt.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.simba.framework.session.page.PageParameter;
import com.simba.jwt.constant.JwtConstantData;

@Component
public class JWTPageParameter implements PageParameter {

	@Override
	public String getKey() {
		return JwtConstantData.tokenPageName;
	}

	@Override
	public String getValue(HttpServletRequest request, HttpServletResponse response) {
		return (String) request.getAttribute(JwtConstantData.requestAttributeName);
	}

}
