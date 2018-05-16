package com.simba.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.TradeAccount;
import com.simba.model.TradeUser;
import com.simba.model.enums.AccountType;
import com.simba.model.enums.FeeType;
import com.simba.model.enums.TradeUserType;
import com.simba.service.TradeAccountService;
import com.simba.service.TradeUserService;
import com.simba.service.UserProjectService;
import com.simba.wallet.util.SessionUtil;

/**
 * 支付账号控制器
 * 
 * @author fzhang
 * 
 */
@Controller
@RequestMapping("/tradeAccount")
public class TradeAccountController {

	@Autowired
	private TradeUserService tradeUserService;
	
	@Autowired
	private UserProjectService projectService;
	
	@Autowired
	private TradeAccountService tradeAccountService;
	
	@Autowired
	private SessionUtil sessionUtil;
	/**
	 * 展示个人支付账户信息
	 * @param sessSmartUserAccount
	 * @param session
	 * @return
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/showPersonalAccount")
	public JsonResult showPersonalAccount(HttpSession session) {
		return new JsonResult(sessionUtil.getTradeAccount(session));
		
	}
	
	private String generateAccountID(AccountType accountType, String userID) {
		String accountID = accountType.getShortName();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		accountID += now.format(formatter);
		accountID += EncryptUtil.md5(userID);
		return accountID;
	}
	
	@ResponseBody
	@RequestMapping("/openPersonalAccount") 
	public JsonResult addTradeUser(String name, String password, String payPhone, String payEmail, HttpSession session) throws Exception {
		return addTradeUser("", name, password, payPhone, payEmail, TradeUserType.PERSION, 1, 1, session);
	}
	
	@ResponseBody
	@RequestMapping("/openCompanyAccount") 
	public JsonResult addTradeUser(String deptID, String name, String password, String payPhone, @RequestParam(required=false) String payEmail, HttpSession session) throws Exception {
		return addTradeUser(deptID, name, password, payPhone, payEmail, TradeUserType.COMPANY, 0, 0, session);
	}
	
	/**
	 * 创建支付用户
	 * @param deptID
	 * @param name
	 * @param password
	 * @param payPhone
	 * @param payEmail
	 * @param tradeUserType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public JsonResult addTradeUser(String deptID, String name, String password, String payPhone, 
			String payEmail, TradeUserType tradeUserType, int isAllowPay, int isAllowRecharge, 
			HttpSession session) throws Exception {
		SmartUser smartUser = null;
		String userID = deptID;
		String accountID = "";
		AccountType accountType = null;
		
		if (tradeUserType.equals(TradeUserType.PERSION)) {
			//通过session的userId获取smart用户信息
			smartUser = sessionUtil.getSmartUser(session);
			userID = smartUser.getAccount();
			accountID = generateAccountID(AccountType.PERSIONAL_ACCOUNT, smartUser.getAccount());
			accountType = AccountType.PERSIONAL_ACCOUNT;
		} else {
			accountID = generateAccountID(AccountType.COMPANY_ACCOUNT, deptID);
			accountType = AccountType.COMPANY_ACCOUNT;
		}
		
		//检查数据库是否存在该记录
		long userIDCount = tradeUserService.countBy("userID", userID);
		if (userIDCount != 0) {
			return new JsonResult("", "支付用户已经存在", 400);
		}
		TradeUser tradeUser = new TradeUser();
		tradeUser.setUserID(userID);
		tradeUser.setIsAllowPay(1);
		tradeUser.setName(name);
		tradeUser.setPayEmail(payEmail);
		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(payPhone);
		boolean isMatch = m.matches();
		if (!isMatch) {
			return new JsonResult("", "手机号格式不正确", 400);
		}
		tradeUser.setPayPhone(payPhone);
		tradeUser.setPayEmail(payEmail);
		tradeUser.setCreateTime(new Date());
		tradeUser.setLastUpdateTime(new Date());
		String p = "";
		// 给密码解密之后再md5。
		String sk = "";
		if (projectService.listBy("name", "des").size() > 0) {
			sk = projectService.listBy("name", "des").get(0).getProjectKey();
		} else {
			return new JsonResult("", "没有配置系统加密密钥，请联系管理员配置", 400);
		}
		p = DesUtil.decrypt(password, sk);
		p = EncryptUtil.md5(p);
		tradeUser.setPayPassword(p);

		Long tradeUserID = tradeUserService.add(tradeUser);
		if (tradeUserID <= 0) {
			return new JsonResult("", "保存支付用户信息失败", 400);
		}
		//检查数据库是否存在该记录
		long tradeAccountCount = tradeAccountService.countBy("accountID", accountID);
		if (tradeAccountCount != 0) {
			return new JsonResult("", "支付账号已经存在", 400);
		}
		
		TradeAccount tradeAccount = new TradeAccount();
		tradeAccount.setAccountID(accountID);
		tradeAccount.setAccountType(accountType.getName());
		tradeAccount.setAccountBalance(0);
		tradeAccount.setAvailableBalance(0);
		tradeAccount.setFeeType(FeeType.CNY.getName());
		tradeAccount.setFrozenBalance(0);
		tradeAccount.setIsActive(1);
		tradeAccount.setIsAllowPay(isAllowPay);
		tradeAccount.setIsAllowRecharge(isAllowRecharge);
		tradeAccount.setIsFrozen(0);
		tradeAccount.setTradeUserID(tradeUserID);
		tradeAccount.setLastUpdateTime(new Date());
		tradeAccount.setCreateTime(new Date());
		Long tradeAccountID = tradeAccountService.add(tradeAccount);
		if (tradeAccountID <= 0) {
			return new JsonResult("", "保存支付账号信息失败", 400);
		}
		return new JsonResult("", "钱包功能开通成功", 200);
	}
	
	@ResponseBody
	@RequestMapping("/getTradeAccount")
	public JsonResult getTradeAccount() {
		return new JsonResult();
	}

	
	/**
	 * 新增支付账号
	 * 
	 * @param tradeAccount
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public JsonResult add(TradeAccount tradeAccount) {
		tradeAccountService.add(tradeAccount);
		return new JsonResult();
	}

	@ResponseBody
	@RequestMapping("/update")
	public JsonResult update(TradeAccount tradeAccount) {
		tradeAccountService.update(tradeAccount);
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
