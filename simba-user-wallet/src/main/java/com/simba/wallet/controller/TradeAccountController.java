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
import com.simba.wallet.model.enums.AccountStatus;
import com.simba.wallet.model.enums.AccountType;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.form.TradeAccountSearchForm;
import com.simba.wallet.model.vo.TradeAccountVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.ErrConfig;
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
    private TradeUserService tradeUserService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping("/doSearch")
    public String getSmartUserAccount(TradeAccountSearchForm tradeAccountSearchForm,
            ModelMap model) {

        if (StringUtils.isEmpty(tradeAccountSearchForm.getUserID())) {
            return "tradeAccount/smartUserList";
        }
        TradeAccount tradeAccount =
                tradeAccountService.get(tradeAccountSearchForm.getUserID(), TradeUserType.PERSION);

        TradeUser tradeUser = tradeUserService.get(tradeAccount.getTradeUserID());
        List<TradeAccountVO> tradeAccountVOList = new ArrayList<>();
        tradeAccountVOList.add(new TradeAccountVO(tradeAccount, tradeUser));

        model.put("list", tradeAccountVOList);
        Map<String, Object> balanceMap =
                tradeAccountService.getBalance(tradeUser.getId(), AccountType.PERSIONAL_ACCOUNT);
        model.putAll(FmtUtil.fmtBalance(balanceMap));
        return "tradeAccount/table";
    }

    // @RequestMapping("/list")
    // public String list() {
    // return "tradeAccount/list";
    // }

    // @RequestMapping("/getList")
    // public String getList(Pager pager, ModelMap model) {
    // List<TradeAccount> list = tradeAccountService.page(pager);
    // model.put("list", list);
    // return "tradeAccount/table";
    // }

    @RequestMapping("/departmentList")
    public String departmentList() {
        return "tradeAccount/departmentList";
    }

    @RequestMapping("/getDepartmentList")
    public String getDepartmentList(ModelMap model) {
        model.putAll(getList(null, AccountType.COMPANY_ACCOUNT));
        return "tradeAccount/table";
    }

    @RequestMapping("/smartUserList")
    public String smartUserList() {
        return "tradeAccount/smartUserList";
    }

    @RequestMapping("/getSmartUserList")
    public String getSmartUserList(ModelMap model) {
        model.putAll(getList(null, AccountType.PERSIONAL_ACCOUNT));
        return "tradeAccount/table";
    }

    @RequestMapping("/channelList")
    public String channelList() {
        return "tradeAccount/channelList";
    }

    @RequestMapping("/getChannelList")
    public String getChannelList(Pager page, ModelMap model) {
        model.putAll(getList(page, AccountType.CHANNEL_ACCOUNT));
        return "tradeAccount/table";
    }


    public Map<String, Object> getList(Pager page, AccountType accountType) {
        List<TradeAccount> list = null;
        if (page != null) {
            list = tradeAccountService.pageByAnd("accountType", accountType.getName(), "isActive",
                    1, page);
        } else {
            list = tradeAccountService.listByAnd("accountType", accountType.getName(), "isActive",
                    1);
        }

        List<TradeAccountVO> tradeAccountVOList = new ArrayList<>();

        Map<String, Object> result = new HashMap<>();
        for (TradeAccount tradeAccount : list) {

            if (tradeAccount.getIsActive() == AccountStatus.CLOSED.getValue()) {
                // 不显示注销的账户信息
                continue;
            }
            TradeUser tradeUser = tradeUserService.get(tradeAccount.getTradeUserID());
            if (tradeUser.getIsActive() == AccountStatus.CLOSED.getValue()) {
                // 不显示注销用户的账户信息
                continue;
            }
            TradeAccountVO tradeAccountVO = new TradeAccountVO(tradeAccount, tradeUser);
            tradeAccountVOList.add(tradeAccountVO);
        }

        result.put("list", tradeAccountVOList);
        Map<String, Object> balanceMap = tradeAccountService.getBalance(accountType);
        result.putAll(FmtUtil.fmtBalance(balanceMap));
        return result;
    }



    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count() {
        Long count = tradeAccountService.count();
        return new JsonResult(count, "", 200);
    }

    // @RequestMapping("/toAdd")
    // public String toAdd() {
    // return "tradeAccount/add";
    // }
    //
    // @RequestMapping("/add")
    // public String add(TradeAccount tradeAccount) {
    // tradeAccountService.add(tradeAccount);
    // return "redirect:/tradeAccount/list";
    // }
    //
    // @RequestMapping("/toUpdate")
    // public String toUpdate(Long id, ModelMap model) {
    // TradeAccount tradeAccount = tradeAccountService.get(id);
    // model.put("tradeAccount", tradeAccount);
    // return "tradeAccount/update";
    // }
    //
    // @RequestMapping("/update")
    // public String update(TradeAccount tradeAccount) {
    // tradeAccountService.update(tradeAccount);
    // return "redirect:/tradeAccount/list";
    // }

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
        try {
            tradeUserService.get(smartUser.getAccount(), TradeUserType.PERSION.getName());
        } catch (Exception e) {
            if (e == ErrConfig.USER_NOT_EXIST_ERR) {
                tradeAccountService.openAccount(smartUser.getAccount(), smartUser.getName(),
                        smartUser.getPassword(), smartUser.getTelNo(), smartUser.getEmail(),
                        TradeUserType.PERSION, 1, 0, AccountStatus.ACTIVE.getValue());
            }
        }
        return new JsonResult(FmtUtil.transToCNYType(tradeAccountService
                .get(smartUser.getAccount(), TradeUserType.PERSION).getAccountBalance()));

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
    public JsonResult openPersonalAccount(String name, String password, String payPhone,
            String payEmail, HttpSession session) throws Exception {
        return tradeAccountService.openAccount(sessionUtil.getSmartUser(session).getAccount(), name,
                password, payPhone, payEmail, TradeUserType.PERSION, 1, 1, 1);
    }

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

    // @ResponseBody
    // @RequestMapping("/delete")
    // public JsonResult delete(Long id, ModelMap model) {
    // tradeAccountService.delete(id);
    // return new JsonResult();
    // }
    //
    // @ResponseBody
    // @RequestMapping("/batchDelete")
    // public JsonResult batchDelete(Long[] id, ModelMap model) {
    // tradeAccountService.batchDelete(Arrays.asList(id));
    // return new JsonResult();
    // }
}
