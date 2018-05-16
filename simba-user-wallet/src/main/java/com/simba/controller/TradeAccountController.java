package com.simba.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.common.utils.DateUtil;
import com.simba.exception.BussException;
import com.simba.framework.util.code.DesUtil;
import com.simba.framework.util.code.EncryptUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.model.TradeAccount;
import com.simba.model.TradeUser;
import com.simba.model.enums.AccountType;
import com.simba.model.enums.FeeType;
import com.simba.service.SmartUserService;
import com.simba.service.TradeAccountService;
import com.simba.service.TradeUserService;
import com.simba.service.UserProjectService;

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
	private TradeUserService tradeUserService;
	
	@Autowired
	private UserProjectService projectService;
	
	@Autowired
	private SmartUserService smartUserService;
	
	@Autowired
	private TradeAccountService tradeAccountService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<TradeAccount> list() {
		List<TradeAccount> list = tradeAccountService.listAll();
		return list;
	}
	
	private String generateAccountID(AccountType accountType, String userID) {
		String accountID = accountType.getShortName();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		accountID += now.format(formatter);
		accountID += EncryptUtil.toHexString(userID);
		return accountID;
	}
	@ResponseBody
	@RequestMapping("/openAccount") 
	public JsonResult addTradeUser(String account, String name, String password, String payPhone, String payEmail, HttpSession session) throws Exception {
		SmartUser smartUser = smartUserService.getBy("account", account);
		if (smartUser == null) {
			throw new BussException("非法参数");
		}
		TradeUser tradeUser = new TradeUser();
		tradeUser.setIsAllowPay(1);
		tradeUser.setUserID(account);
		tradeUser.setName(name);
		tradeUser.setPayEmail(payEmail);
		String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
		Pattern pat = Pattern.compile(regex);
		Matcher m = pat.matcher(payPhone);
		boolean isMatch = m.matches();
		if (!isMatch) {
			throw new BussException("手机号不正确，请更换账号");
		}
		tradeUser.setPayPhone(payPhone);
		tradeUser.setPayEmail(payEmail);
		tradeUser.setCreateTime(new Date());
		tradeUser.setLastUpdateTime(new Date());
		String p = "";
		// 给密码解密之后再md5。
		String sk = "";
		if (projectService.listBy("name", "wallet").size() > 0) {
			sk = projectService.listBy("name", "wallet").get(0).getProjectKey();
		} else {
			throw new BussException("没有配置系统加密密钥，请联系管理员配置");
		}
		p = DesUtil.decrypt(password, sk);
		p = EncryptUtil.md5(p);
		tradeUser.setPayPassword(p);
		Long tradeUserID = tradeUserService.add(tradeUser);
		if (tradeUserID > 0) {
			// 注册成功后userId写入session
			session.setAttribute("tradeUserID", tradeUserID);
		} else {
			throw new BussException("钱包开通失败");
		}
		
		TradeAccount tradeAccount = new TradeAccount();
		tradeAccount.setAccountBalance(0);
		tradeAccount.setAccountID(generateAccountID(AccountType.PERSIONAL_ACCOUNT, account));
		tradeAccount.setAccountType(AccountType.PERSIONAL_ACCOUNT.getName());
		tradeAccount.setAvailableBalance(0);
		tradeAccount.setFeeType(FeeType.CNY.getName());
		tradeAccount.setFrozenBalance(0);
		tradeAccount.setIsActive(1);
		tradeAccount.setIsAllowPay(1);
		tradeAccount.setIsAllowRecharge(1);
		tradeAccount.setIsFrozen(0);
		tradeAccount.setTradeUserID(tradeUserID);
		tradeAccount.setLastUpdateTime(new Date());
		tradeAccount.setCreateTime(new Date());
		Long tradeAccountID = tradeAccountService.add(tradeAccount);
		if (tradeAccountID > 0) {
			// 注册成功后userId写入session
			session.setAttribute("tradeAccountID", tradeAccountID);
		} else {
			throw new BussException("钱包功能开通失败");
		}
		return new JsonResult("", "钱包功能开通成功", 200);
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
