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
import com.simba.dao.UserProjectDao;
import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.dao.TradeAccountDao;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.AccountStatus;
import com.simba.wallet.model.enums.AccountType;
import com.simba.wallet.model.enums.FeeType;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.form.TradeAccountSearchForm;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
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

    @Autowired
    private UserProjectDao projectDao;

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
    public List<TradeAccount> listByAnd(String field1, Object value1, String field2,
            Object value2) {
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
    public List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2,
            Pager page) {
        return tradeAccountDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2,
            Pager page) {
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

        return accountID + random.ints(100000, 999999).limit(1).findFirst().getAsInt()
                + StringUtils.EMPTY;
    }


    /**
     * 创建支付用户
     * 
     * @param uid
     * @param name
     * @param password
     * @param payPhone
     * @param payEmail
     * @param tradeUserType
     * @param smartUser
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public JsonResult openAccount(String userID, String name, String password, String payPhone,
            String payEmail, TradeUserType tradeUserType, int isAllowPay, int isAllowRecharge,
            int isActive) throws Exception {

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
        TradeUser tradeUserDB = tradeUserDao.getByAnd("userID", userID, "type",
                tradeUserType.getName(), "isActive", 1);
        if (tradeUserDB == null) {
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
            // String p = "";
            // 给密码解密之后再md5。
            // String sk = "";
            // if (projectDao.listBy("name", "wallet").size() > 0) {
            // sk = projectDao.listBy("name", "wallet").get(0).getProjectKey();
            // } else {
            // throw new BussException("没有配置系统加密密钥，请联系管理员配置");
            // }
            // p = DesUtil.decrypt(password, sk);
            // p = EncryptUtil.md5(p);
            tradeUser.setPayPassword(password);

            tradeUserID = tradeUserDao.add(tradeUser);
            if (tradeUserID <= 0) {
                throw new BussException("保存支付用户信息失败");
            }
        } else {
            tradeUserID = tradeUserDB.getId();
        }
        // 检查数据库是否存在该记录
        TradeAccount tradeAccountDB = tradeAccountDao.getByAnd("accountType", accountType.getName(),
                "tradeUserID", tradeUserID, "isActive", 1);
        if (tradeAccountDB != null) {
            if (tradeAccountDB.getIsFrozen() == 1) {
                throw new BussException("请解冻账户");
            } else {
                throw ErrConfig.ACCOUNT_EXIST_ERR;
            }
        }

        TradeAccount tradeAccount = new TradeAccount();
        tradeAccount.setAccountID(accountID);
        tradeAccount.setAccountType(accountType.getName());
        tradeAccount.setAccountBalance(0);
        tradeAccount.setAvailableBalance(0);
        tradeAccount.setFeeType(FeeType.CNY.getName());
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
            throw new BussException("保存支付账号信息失败");
        }
        return new JsonResult("", "钱包功能开通成功", 200);
    }

    @Override
    public JsonResult frozeAccount(String userID, TradeUserType userType) {
        // TODO: 手机验证码 根据userID获取注册时的手机号
        TradeAccount tradeAccount = tradeAccountDao.get(userID, userType);
        tradeAccount.setIsFrozen(AccountStatus.FRONZEN.getValue());
        tradeAccountDao.update(tradeAccount);
        return new JsonResult();
    }

    @Override
    public JsonResult closeAccount(String userID, TradeUserType userType) {
        try {
            TradeUser tradeUser = tradeUserDao.get(userID, userType.getName());
            TradeAccount tradeAccount = tradeAccountDao.get(tradeUser.getId(), userType);
            tradeUser.setIsActive(AccountStatus.CLOSED.getValue());
            tradeUserDao.update(tradeUser);
            if (tradeAccount.getAccountBalance() == 0) {
                tradeAccount.setIsActive(AccountStatus.CLOSED.getValue());
                tradeAccountDao.update(tradeAccount);
            } else {
                throw new BussException("删除失败：账户余额不为0");
            }
        } catch (Exception e) {
            if (e == ErrConfig.USER_NOT_EXIST_ERR || e == ErrConfig.ACCOUNT_NOT_EXIST_ERR) {
                // TODO: logger
                System.out.println(e);
            } else {
                throw new BussException(e.getMessage());
            }
        }
        return new JsonResult();
    }

    @Override
    public JsonResult activeAccount(String userID, TradeUserType userType) {
        TradeAccount tradeAccount = tradeAccountDao.get(userID, userType);
        if (tradeAccount.getIsFrozen() == AccountStatus.FRONZEN.getValue()) {
            tradeAccount.setIsFrozen(AccountStatus.NOTFROZEN.getValue());
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
