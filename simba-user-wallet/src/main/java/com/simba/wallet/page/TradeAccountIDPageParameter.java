package com.simba.wallet.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.simba.framework.session.page.PageParameter;
import com.simba.page.SessionKey;

public class TradeAccountIDPageParameter implements PageParameter{

	@Override
	public String getKey() {
		return SessionKey.smartUserIDKey;
	}

	@Override
	public String getValue(HttpServletRequest request, HttpServletResponse response) {
		Object tradeAccountIDSess = request.getSession().getAttribute("tradeAccountID");
		if (tradeAccountIDSess != null) {
			return (String)tradeAccountIDSess;
		}
		return StringUtils.EMPTY;
	}

}
