package com.simba.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.simba.framework.session.page.PageParameter;
import com.simba.permission.model.Org;
import com.simba.util.SessionUtil;

@Component
public class OrgIdPageParameter implements PageParameter {

	@Override
	public String getKey() {
		return SessionKey.orgIdKey;
	}

	@Override
	public String getValue(HttpServletRequest request, HttpServletResponse response) {
		List<Org> orgs = SessionUtil.getOrgs(request.getSession());
		String orgId = StringUtils.EMPTY;
		if (orgs != null && orgs.size() > 0) {
			orgId = orgs.get(0).getId() + StringUtils.EMPTY;
		}
		return orgId;
	}

}
