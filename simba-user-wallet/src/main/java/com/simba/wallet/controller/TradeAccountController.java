package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
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
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.form.TradeAccountSearchForm;
import com.simba.wallet.model.vo.TradeAccountVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants;
import com.simba.wallet.util.Constants.AccountType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;
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
    private TradeUserService tradeUserService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping("/doSearch")
    public String getSmartUserAccount(TradeAccountSearchForm tradeAccountSearchForm,
            ModelMap model) {

        if (StringUtils.isEmpty(tradeAccountSearchForm.getUserID())) {
            return "redirect:/tradeAccount/smartUserList";
        }
        TradeAccount tradeAccount =
                tradeAccountService.get(tradeAccountSearchForm.getUserID(), TradeUserType.PERSION);
        List<TradeAccountVO> tradeAccountVOList = new ArrayList<>();
        model.put("list", tradeAccountVOList);
        if (tradeAccount != null) {

            TradeUser tradeUser = tradeUserService.get(tradeAccount.getTradeUserID());
            if (tradeUser != null) {
                tradeAccountVOList.add(new TradeAccountVO(tradeAccount, tradeUser));

                Map<String, Object> balanceMap = tradeAccountService.getBalance(tradeUser.getId(),
                        AccountType.PERSIONAL_ACCOUNT);
                model.putAll(CommonUtil.fmtBalance(balanceMap));
            }
        }
        model.put("showSummery", true);
        return "tradeAccount/table";
    }

    @RequestMapping("/departmentList")
    public String departmentList(ModelMap model) {
        model.put("accountType", AccountType.COMPANY_ACCOUNT.getValue());
        return "tradeAccount/departmentList";
    }

    @RequestMapping("/smartUserList")
    public String smartUserList(ModelMap model) {
        model.put("accountType", AccountType.PERSIONAL_ACCOUNT.getValue());
        return "tradeAccount/smartUserList";
    }

    @RequestMapping("/channelList")
    public String channelList(ModelMap model) {
        model.put("accountType", AccountType.CHANNEL_ACCOUNT.getValue());
        return "tradeAccount/channelList";
    }

    @RequestMapping("/getList")
    public String getList(Pager page, String accountType, ModelMap model) {
        model.putAll(getList(page, CommonUtil.getAccountType(accountType)));
        return "tradeAccount/table";
    }

    public Map<String, Object> getList(Pager page, AccountType accountType) {
        List<TradeAccount> list = null;
        if (page != null) {
            list = tradeAccountService.pageByAnd("accountType", accountType.getValue(), "isActive",
                    1, page);
        } else {
            list = tradeAccountService.listByAnd("accountType", accountType.getValue(), "isActive",
                    1);
        }

        List<TradeAccountVO> tradeAccountVOList = new ArrayList<>();

        Map<String, Object> result = new HashMap<>();
        for (TradeAccount tradeAccount : list) {

            TradeUser tradeUser = tradeUserService.get(tradeAccount.getTradeUserID());
            TradeAccountVO tradeAccountVO = new TradeAccountVO(tradeAccount, tradeUser);
            tradeAccountVOList.add(tradeAccountVO);
        }

        result.put("list", tradeAccountVOList);
        Map<String, Object> balanceMap = tradeAccountService.getBalance(accountType);
        result.putAll(CommonUtil.fmtBalance(balanceMap));
        boolean showSummery = false;
        if (accountType != AccountType.COMPANY_ACCOUNT) {
            showSummery = true;
        }
        result.put("showSummery", showSummery);
        return result;
    }



    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count(String accountType) {
        Long count = tradeAccountService.countByAnd("accountType", accountType, "isActive", 1);
        return new JsonResult(count, "", 200);
    }



    /**
     * 展示余额
     * 
     * @param sessSmartUserAccount @param session @return @throws
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/showBalance")
    public JsonResult showBalance(HttpSession session) throws Exception {
        SmartUser smartUser = sessionUtil.getSmartUser(session);

        TradeUser tradeUser = tradeUserService.get(smartUser.getAccount(), TradeUserType.PERSION);
        if (tradeUser == null) {
            tradeAccountService.openAccount(smartUser.getAccount(), smartUser.getName(),
                    smartUser.getPassword(), smartUser.getTelNo(), smartUser.getEmail(),
                    TradeUserType.PERSION, 1, 1, Constants.AccountActiveStatus.ACTIVE.getValue());
        }
        TradeAccount smartUserTradeAccount =
                tradeAccountService.get(smartUser.getAccount(), TradeUserType.PERSION);
        if (smartUserTradeAccount == null) {
            throw ErrConfig.INVALID_WALLET_USER;
        }
        return new JsonResult(CommonUtil.transToCNYType(smartUserTradeAccount.getAccountBalance()));

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
    // @ResponseBody
    // @RequestMapping("/openPersonalAccount")
    // public JsonResult openPersonalAccount(String name, String password, String payPhone,
    // String payEmail, HttpSession session) throws Exception {
    // return tradeAccountService.openAccount(sessionUtil.getSmartUser(session).getAccount(), name,
    // password, payPhone, payEmail, TradeUserType.PERSION, 1, 1, 1);
    // }

    /**
     * 冻结个人账户
     * 
     * @param account
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/frozePersonalAccount")
    public JsonResult frozePersonalAccount(String account) throws Exception {
        return tradeAccountService.frozeAccount(account, TradeUserType.PERSION);
    }

    /**
     * 激活冻结的账户
     * 
     * @param account
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/activatePersonalAccount")
    public JsonResult activatePersonAccount(String account) throws Exception {
        return tradeAccountService.activeAccount(account, TradeUserType.PERSION);
    }

    /**
     * 开通部门支付账户
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
    public JsonResult openCompanyAccount(String deptNO, String deptName, String password,
            String payPhone, @RequestParam(required = false) String payEmail, HttpSession session)
            throws Exception {
        return tradeAccountService.openAccount(deptNO, deptName, password, payPhone, payEmail,
                TradeUserType.DEPARTMENT, 0, 0, 1);
    }

    /**
     * 冻结部门账户
     * 
     * @param deptNO
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/frozeDepartmentAccount")
    public JsonResult frozeCompanyAccount(String deptNO) throws Exception {
        return tradeAccountService.frozeAccount(deptNO, TradeUserType.DEPARTMENT);
    }

    /**
     * 激活冻结的账户
     * 
     * @param deptNO
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/activateDepartmentAccount")
    public JsonResult activateDepartmentAccount(String deptNO) throws Exception {
        return tradeAccountService.activeAccount(deptNO, TradeUserType.DEPARTMENT);
    }

    /**
     * 开通渠道账户
     * 
     * @param type
     * @param name
     * @param password
     * @param payPhone
     * @param payEmail
     * @param session
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/openChannelAccount")
    public JsonResult openChannelAccount(String type, String name, String password, String payPhone,
            @RequestParam(required = false) String payEmail, HttpSession session) throws Exception {
        return tradeAccountService.openAccount(type, name, password, payPhone, payEmail,
                TradeUserType.CHANNEL, 0, 0, 1);
    }

    /**
     * 冻结渠道账户
     * 
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/frozeChannelAccount")
    public JsonResult frozeChannelAccount(String type) throws Exception {
        return tradeAccountService.frozeAccount(type, TradeUserType.CHANNEL);
    }

    /**
     * 激活冻结的账户
     * 
     * @param type
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/activateChannelAccount")
    public JsonResult activateChannelAccount(String type) throws Exception {
        return tradeAccountService.activeAccount(type, TradeUserType.CHANNEL);
    }

}
