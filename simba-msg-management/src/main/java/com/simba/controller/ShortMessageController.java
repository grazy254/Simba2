package com.simba.controller;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.simba.cache.RedisUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.jpush.msg.util.JpushMsgUtil;
import com.simba.model.MsgProject;
import com.simba.model.ShortMessage;
import com.simba.model.Vo.ShortMessageVo;
import com.simba.model.form.ShortMsgSearchForm;
import com.simba.service.MsgProjectService;
import com.simba.service.SendMsgService;
import com.simba.service.ShortMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 短信控制器
 *
 * @author caozj
 */
@Controller
@RequestMapping("/shortMessage")
public class ShortMessageController {

	@Autowired
	private ShortMessageService shortMessageService;

	@Autowired
	private MsgProjectService projectService;

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private JpushMsgUtil jpushMsgUtil;

	@Autowired
	private SendMsgService sendMsgService;

	@RequestMapping("/list")
	public String list() {
		return "shortMessage/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<ShortMessage> list = shortMessageService.page(pager);
		model.put("list", list);
		return "shortMessage/table";
	}

	@RequestMapping("/getListVo")
	public String getListVo(Pager pager, ModelMap model) {
		List<ShortMessageVo> list = shortMessageService.pageVo(pager);
		model.put("list", list);
		return "shortMessage/table";
	}

	@RequestMapping("/getListSearch")
	public String getListSearch(Pager pager, ShortMsgSearchForm msgSearchForm, ModelMap model) {
		List<ShortMessageVo> list = shortMessageService.pageVo(pager, msgSearchForm);
		model.put("list", list);
		return "shortMessage/table";
	}

	@ResponseBody
	@RequestMapping("/resend")
	public JsonResult resend(String id) {
		sendMsgService.resend(Long.valueOf(id));
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = shortMessageService.count();
		return new JsonResult(count, "", 200);
	}

	@ResponseBody
	@RequestMapping("/countSearch")
	public JsonResult count(ShortMsgSearchForm msgSearchForm) {
		Long count = shortMessageService.count(msgSearchForm);
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "shortMessage/add";
	}

	@RequestMapping("/add")
	public String add(ShortMessage shortMessage) {
		shortMessageService.add(shortMessage);
		return "redirect:/shortMessage/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		ShortMessage shortMessage = shortMessageService.get(id);
		model.put("shortMessage", shortMessage);
		return "shortMessage/update";
	}

	@RequestMapping("/update")
	public String update(ShortMessage shortMessage) {
		shortMessageService.update(shortMessage);
		return "redirect:/shortMessage/list";
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		shortMessageService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		shortMessageService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}

	@RequestMapping("/balanceTable")
	public String balanceTable(ModelMap model) {
		List<String> platformList = new ArrayList<>();
		platformList.add("极光短信");
		model.put("list", platformList);
		return "shortMessage/balancetable";
	}

	@RequestMapping("/toBalance")
	public String toBalance() {
		return "shortMessage/messagebalance";
	}

	/**
	 * 查询平台短信总余量
	 *
	 * @param platform
	 *            平台类型,由于只有极光开放余量查询接口,所以该参数暂时没用
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	@ResponseBody
	@RequestMapping("/balanceTotal")
	public JsonResult getMsgBalance(String platform) {
		JsonResult jsonResult = new JsonResult();
		String balance = "--";
		try {
			balance = String.valueOf(jpushMsgUtil.getSMSBalance());
		} catch (Exception e) {
			jsonResult.setMsg("查询不到" + platform + "余量");
			jsonResult.setCode(JsonResult.failCode);
		}
		jsonResult.setData(balance);
		return jsonResult;
	}

	/**
	 * 查询项目当天的短信余量
	 *
	 * @param projectId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/balance")
	public JsonResult getMsgBalance(int projectId) {
		JsonResult jsonResult = new JsonResult();
		int sendNum = (Integer) redisUtil.get("project_" + projectId + "_sendnum");
		MsgProject project = projectService.get(projectId);
		int restNum = project.getLimitNum() - sendNum;
		jsonResult.setData(restNum);
		return jsonResult;
	}

	/**
	 * 查询项目当天的短信用量
	 *
	 * @param projectId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/sendNum")
	public JsonResult getMsgSendNum(int projectId) {
		JsonResult jsonResult = new JsonResult();
		int sendNum = (Integer) redisUtil.get("project_" + projectId + "_sendnum");
		jsonResult.setData(sendNum);
		return jsonResult;
	}

}
