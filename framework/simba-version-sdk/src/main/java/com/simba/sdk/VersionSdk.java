package com.simba.sdk;

import java.util.HashMap;
import java.util.Map;

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

	private static final String saveBugFeedbackUrl = "/VERSIONUSER/api/bugFeedback/save";

	@Autowired
	private EurekaClientUtil client;

	/**
	 * 获取版本信息
	 * 
	 * @param typeId
	 *            类型id
	 * @return
	 */
	public JsonResult getVersionInfo(int typeId) {
		String getUrl = getVersionUrl + "?typeId=" + typeId;
		String res = client.get(getUrl);
		JsonResult result = FastJsonUtil.toObject(res, JsonResult.class);
		result.check("获取版本信息发生异常");
		return result;
	}

	/**
	 * 保存bug反馈
	 * 
	 * @param userId
	 *            反馈bug的用户id
	 * @param title
	 *            bug名称
	 * @param text
	 *            bug内容
	 * @param img
	 *            bug截图
	 * @return
	 */
	public JsonResult saveBugFeedback(Integer userId, String title, String text, String img) {
		Map<String, String> param = new HashMap<>();
		param.put("userId", userId + "");
		param.put("title", title);
		param.put("text", text);
		param.put("img", img);
		String res = client.post(saveBugFeedbackUrl, param);
		JsonResult result = FastJsonUtil.toObject(res, JsonResult.class);
		result.check("保存bug反馈发生异常");
		return result;
	}
}
