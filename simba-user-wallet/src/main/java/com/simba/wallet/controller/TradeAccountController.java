package com.simba.wallet.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.util.FmtUtil;
import com.simba.wallet.util.SessionUtil;

/**
 * 支付账号控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeAccount")
public class TradeAccountController {

	@Autowired
	private TradeAccountService tradeAccountService;
	
	@Autowired
	private SessionUtil sessionUtil;
	
	
	@RequestMapping("/list")
	public String list() {
		return "tradeAccount/list";
	}

	@RequestMapping("/getList")
	public String getList(Pager pager, ModelMap model) {
		List<TradeAccount> list = tradeAccountService.page(pager);
		model.put("list", list);
		return "tradeAccount/table";
	}

	@ResponseBody
	@RequestMapping("/count")
	public JsonResult count() {
		Long count = tradeAccountService.count();
		return new JsonResult(count, "", 200);
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "tradeAccount/add";
	}

	@RequestMapping("/add")
	public String add(TradeAccount tradeAccount) {
		tradeAccountService.add(tradeAccount);
		return "redirect:/tradeAccount/list";
	}

	@RequestMapping("/toUpdate")
	public String toUpdate(Long id, ModelMap model) {
		TradeAccount tradeAccount = tradeAccountService.get(id);
		model.put("tradeAccount", tradeAccount);
		return "tradeAccount/update";
	}

	@RequestMapping("/update")
	public String update(TradeAccount tradeAccount) {
		tradeAccountService.update(tradeAccount);
		return "redirect:/tradeAccount/list";
	}
	
	/**
	 * 展示余额
	 * 
	 * @param sessSmartUserAccount
	 * @param session
	 * @return 
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/showBalance")
	public JsonResult showBalance(HttpSession session) {
		SmartUser smartUser = sessionUtil.getSmartUser(session);
		return new JsonResult(
				FmtUtil.transToCNYType(
						tradeAccountService.get(smartUser.getAccount(), TradeUserType.PERSION)
								.getAccountBalance()));
		
	}

	/**
	 * 开通个人支付账户
	 * 
	 * @param name
	 * @param password
	 * @param payPhone
	 * @param payEmail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/openPersonalAccount") 
	public JsonResult openPersonalAccount(String name, String password, String payPhone, String payEmail,
			HttpSession session) throws Exception {
		return tradeAccountService.openAccount(sessionUtil.getSmartUser(session).getAccount(), name, password, payPhone,
				payEmail,
				TradeUserType.PERSION, 1, 1, 1);
	}
	
	/**
	 * 开通公司支付账户
	 * 
	 * @param deptID
	 * @param name
	 * @param password
	 * @param payPhone
	 * @param payEmail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/openDepartmentAccount")
	public JsonResult openCompanyAccount(String deptNO, String deptName, String password, String payPhone,
			@RequestParam(required = false) String payEmail, HttpSession session) throws Exception {
		return tradeAccountService.openAccount(deptNO, deptName, password, payPhone, payEmail, TradeUserType.DEPARTMENT,
				0,
				0, 1);
	}
	@ResponseBody
	@RequestMapping("/frozeDepartmentAccount")
	public JsonResult frozeCompanyAccount(String deptNO) throws Exception {
		return tradeAccountService.frozeAccount(deptNO, TradeUserType.DEPARTMENT);
	}

	@ResponseBody
	@RequestMapping("/openChannelAccount")
	public JsonResult openChannelAccount(String type, String name, String password, String payPhone,
			@RequestParam(required = false) String payEmail, HttpSession session) throws Exception {
		return tradeAccountService.openAccount(type, name, password, payPhone, payEmail, TradeUserType.CHANNEL, 0, 0,
				1);
	}
	@ResponseBody
	@RequestMapping("/frozeChannelAccount")
	public JsonResult frozeChannelAccount(String type) throws Exception {
		return tradeAccountService.frozeAccount(type, TradeUserType.CHANNEL);
	}

	@ResponseBody
	@RequestMapping("/getTradeAccount")
	public JsonResult getTradeAccount() {
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/delete")
	public JsonResult delete(Long id, ModelMap model) {
		tradeAccountService.delete(id);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/batchDelete")
	public JsonResult batchDelete(Long[] id, ModelMap model) {
		tradeAccountService.batchDelete(Arrays.asList(id));
		return new JsonResult();
	}
}
