package com.simba.sdk;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simba.eureka.client.EurekaClientUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 版本管理sdk
 * 
 * @author caozhejun
 *
 */
@Service
public class VersionSdk {

	private static final Log logger = LogFactory.getLog(VersionSdk.class);

	private static final String getVersionUrl = "/VERSIONUSER/api/app/getVersionInfo";

	private static final String saveBugFeedbackUrl = "/VERSIONUSER";

	@Autowired
	private EurekaClientUtil client;

	/**
	 * 获取版本信息
	 * 
	 * @param typeId
	 * @return
	 */
	public JsonResult getVersionInfo(int typeId) {
		String getUrl = getVersionUrl + "?typeId=" + typeId;
		String res = client.get(getUrl);
		JsonResult result = FastJsonUtil.toObject(res, JsonResult.class);
		result.check("获取版本信息发生异常");
		return result;
	}
}
