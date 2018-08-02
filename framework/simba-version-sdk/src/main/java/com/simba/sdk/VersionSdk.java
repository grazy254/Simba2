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

	private static final String getIosVersionUrl = "/VERSIONUSER/api/ios/getVersionInfo";

	private static final String saveOpinionFeedbackUrl = "/VERSIONUSER/api/opinionFeedback/save";

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
	 * 获取IOS版本信息
	 * 
	 * @param typeId
	 *            类型id
	 * @return
	 */
	public JsonResult getIOSVersionInfo(int typeId) {
		String getUrl = getIosVersionUrl + "?typeId=" + typeId;
		String res = client.get(getUrl);
		JsonResult result = FastJsonUtil.toObject(res, JsonResult.class);
		result.check("获取IOS版本信息发生异常");
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

	/**
	 * 保存反馈意见
	 * 
	 * @param userId
	 * @param title
	 * @param text
	 * @return
	 */
	public JsonResult saveOpinionFeedback(Integer userId, String title, String text) {
		Map<String, String> param = new HashMap<>();
		param.put("userId", userId + "");
		param.put("title", title);
		param.put("text", text);
		String res = client.post(saveOpinionFeedbackUrl, param);
		JsonResult result = FastJsonUtil.toObject(res, JsonResult.class);
		result.check("保存反馈意见发生异常");
		return result;
	}
}
