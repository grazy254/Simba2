package com.simba.wallet.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.form.TradeAccountSearchForm;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.Constants.AccountActiveStatus;
import com.simba.wallet.util.Constants.AccountFrozenStatus;
import com.simba.wallet.util.Constants.AccountType;
import com.simba.wallet.util.Constants.FeeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;

/**
 * 支付账号 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeAccountServiceImpl implements TradeAccountService {

	@Autowired
	private TradeAccountDao tradeAccountDao;

	@Autowired
	private TradeUserService tradeUserDao;

	@Override
	public Long add(TradeAccount tradeAccount) {
		return tradeAccountDao.add(tradeAccount);
	}

	@Override
	public void delete(Long id) {
		tradeAccountDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount get(Long id) {
		return tradeAccountDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> page(Pager page) {
		return tradeAccountDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> page(Pager page, TradeAccountSearchForm tradeAccountSearchForm) {
		return tradeAccountDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return tradeAccountDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return tradeAccountDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		tradeAccountDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listAll() {
		return tradeAccountDao.listAll();
	}

	@Override
	public void update(TradeAccount tradeAccount) {
		tradeAccountDao.update(tradeAccount);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount getBy(String field, Object value) {
		return tradeAccountDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount getByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TradeAccount getByOr(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listBy(String field, Object value) {
		return tradeAccountDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> listByOr(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageBy(String field, Object value, Pager page) {
		return tradeAccountDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeAccountDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tradeAccountDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
		tradeAccountDao.deleteByAnd(field1, value1, field2, value2);
	}

	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2) {
		tradeAccountDao.deleteByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByAnd(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.countByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Long countByOr(String field1, Object value1, String field2, Object value2) {
		return tradeAccountDao.countByOr(field1, value1, field2, value2);
	}

	private String generateAccountID(AccountType accountType) {
		String accountID = accountType.getShortName();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		accountID += now.format(formatter);
		Random random = new Random();

		return accountID + random.ints(100000, 999999).limit(1).findFirst().getAsInt() + StringUtils.EMPTY;
	}

	/**
	 * 开通账户 包括smart用户，部门，渠道
	 * 
	 * @param userID
	 *            用户id
	 * @param name
	 *            用户名称
	 * @param password
	 *            已加密的密码
	 * @param payPhone
	 *            移动电话
	 * @param payEmail
	 *            邮箱
	 * @param tradeUserType
	 *            用户类型
	 * @param isAllowPay
	 *            是否允许支付
	 * @param isAllowRecharge
	 *            是否允许充值
	 * @param isActive
	 *            是否激活
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public JsonResult openAccount(String userID, String name, String password, String payPhone, String payEmail, TradeUserType tradeUserType, int isAllowPay, int isAllowRecharge, int isActive)
			throws Exception {

		String accountID = "";
		AccountType accountType = null;

		if (tradeUserType.equals(TradeUserType.PERSION)) {
			accountID = generateAccountID(AccountType.PERSIONAL_ACCOUNT);
			accountType = AccountType.PERSIONAL_ACCOUNT;
		} else if (tradeUserType.equals(TradeUserType.DEPARTMENT)) {
			accountID = generateAccountID(AccountType.COMPANY_ACCOUNT);
			accountType = AccountType.COMPANY_ACCOUNT;
		} else if (tradeUserType.equals(TradeUserType.CHANNEL)) {
			accountID = generateAccountID(AccountType.CHANNEL_ACCOUNT);
			accountType = AccountType.CHANNEL_ACCOUNT;
		} else {
			throw new BussException("错误的用户类型");
		}
		Long tradeUserID = 0L;

		// 检查数据库是否存在该记录
		long userCount = tradeUserDao.countByAnd("userID", userID, "type", tradeUserType.getName(), "isActive", 1);

		if (userCount == 0) {
			TradeUser tradeUser = new TradeUser();
			tradeUser.setUserID(userID);
			// TODO:1 不达意
			tradeUser.setIsAllowPay(1);
			tradeUser.setIsActive(1);
			tradeUser.setName(name);
			tradeUser.setType(tradeUserType.getName());
			tradeUser.setPayEmail(payEmail);
			String regex = "^1[3|4|5|7|8][0-9]\\d{4,8}$";
			Pattern pat = Pattern.compile(regex);
			Matcher m = pat.matcher(payPhone);
			boolean isMatch = m.matches();
			if (!isMatch) {
				throw new BussException("手机号格式不正确");
			}
			tradeUser.setPayPhone(payPhone);
			tradeUser.setPayEmail(payEmail);
			tradeUser.setCreateTime(new Date());
			tradeUser.setLastUpdateTime(new Date());
			tradeUser.setPayPassword(password);

			tradeUserID = tradeUserDao.add(tradeUser);
			if (tradeUserID <= 0) {
				throw ErrConfig.OPEN_WALLET_ACCOUNT_FAILED;
			}
		} else {
			throw ErrConfig.ACCOUNT_EXIST_ERR;
		}
		// 检查数据库是否存在该记录
		Long accountCount = tradeAccountDao.countByAnd("accountType", accountType.getValue(), "tradeUserID", tradeUserID, "isActive", 1);
		if (accountCount != 0) {
			throw ErrConfig.ACCOUNT_EXIST_ERR;
		}

		TradeAccount tradeAccount = new TradeAccount();
		tradeAccount.setAccountID(accountID);
		tradeAccount.setAccountType(accountType.getValue());
		tradeAccount.setAccountBalance(0);
		tradeAccount.setAvailableBalance(0);
		tradeAccount.setFeeType(FeeType.CNY.name());
		tradeAccount.setFrozenBalance(0);
		tradeAccount.setIsActive(isActive);
		tradeAccount.setIsAllowPay(isAllowPay);
		tradeAccount.setIsAllowRecharge(isAllowRecharge);
		tradeAccount.setIsFrozen(0);
		tradeAccount.setTradeUserID(tradeUserID);
		tradeAccount.setLastUpdateTime(new Date());
		tradeAccount.setCreateTime(new Date());
		Long tradeAccountID = tradeAccountDao.add(tradeAccount);
		if (tradeAccountID <= 0) {
			throw ErrConfig.OPEN_WALLET_ACCOUNT_FAILED;
		}
		return new JsonResult("", "钱包功能开通成功", 200);
	}

	/**
	 * 
	 */
	@Override
	public JsonResult frozeAccount(String userID, TradeUserType userType) {
		// TODO: 手机验证码 根据userID获取注册时的手机号
		TradeAccount tradeAccount = tradeAccountDao.get(userID, userType);
		tradeAccount.setIsFrozen(AccountFrozenStatus.FROZEN.getValue());
		tradeAccountDao.update(tradeAccount);
		return new JsonResult();
	}

	@Override
	public JsonResult closeAccount(String userID, TradeUserType userType) {

		TradeUser tradeUser = tradeUserDao.get(userID, userType);
		TradeAccount tradeAccount = tradeAccountDao.get(tradeUser.getId(), userType);
		tradeUser.setIsActive(AccountActiveStatus.CLOSED.getValue());
		tradeUserDao.update(tradeUser);
		if (tradeAccount.getAccountBalance() == 0) {
			tradeAccount.setIsActive(AccountActiveStatus.CLOSED.getValue());
			tradeAccountDao.update(tradeAccount);
		} else {
			throw new BussException("注销失败：账户余额不为0");
		}

		return new JsonResult();
	}

	@Override
	public JsonResult activeAccount(String userID, TradeUserType userType) {
		TradeAccount tradeAccount = tradeAccountDao.get(userID, userType);
		if (tradeAccount.getIsFrozen() == AccountFrozenStatus.FROZEN.getValue()) {
			tradeAccount.setIsFrozen(AccountFrozenStatus.NOTFROZEN.getValue());
			tradeAccountDao.update(tradeAccount);
		}
		return new JsonResult();
	}

	@Override
	public TradeAccount get(String userID, TradeUserType userType) {
		return tradeAccountDao.get(userID, userType);
	}

	@Override
	public TradeAccount get(Long tradeUserID, TradeUserType userType) {
		return tradeAccountDao.get(tradeUserID, userType);
	}

	@Override
	public Map<String, Object> getBalance(AccountType accountType) {
		return tradeAccountDao.getBalance(accountType);
	}

	@Override
	public Map<String, Object> getBalance(Long tradeUserID, AccountType accountType) {
		return tradeAccountDao.getBalance(tradeUserID, accountType);
	}

}
