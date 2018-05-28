package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.SmartUser;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.AccountType;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.vo.TradeAccountVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
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

    @RequestMapping("/departmentList")
    public String departmentList() {
        return "tradeAccount/departmentList";
    }

    @RequestMapping("/getDepartmentList")
    public String getDepartmentList(ModelMap model) {
        model.putAll(getList(AccountType.COMPANY_ACCOUNT));
        return "tradeAccount/table";
    }

    @RequestMapping("/channelList")
    public String channelList() {
        return "tradeAccount/channelList";
    }

    @RequestMapping("/getChannelList")
    public String getChannelList(ModelMap model) {
        model.putAll(getList(AccountType.CHANNEL_ACCOUNT));
        return "tradeAccount/table";
    }


    public Map<String, Object> getList(AccountType accountType) {
        List<TradeAccount> list =
                tradeAccountService.listByAnd("accountType", accountType.getName(), "isActive", 1);
        List<TradeAccountVO> tradeAccountVOList = new ArrayList<>();
        Long accountBalance = 0L;
        Long avaliableBalance = 0L;
        Long frozenBalance = 0L;
        Map<String, Object> result = new HashMap<>();
        for (TradeAccount tradeAccount : list) {
            TradeAccountVO tradeAccountVO = new TradeAccountVO();
            tradeAccountVO
                    .setAccountBalance(FmtUtil.transToCNYType(tradeAccount.getAccountBalance()));
            tradeAccountVO.setAccountID(tradeAccount.getAccountID());
            tradeAccountVO.setAvailableBalance(
                    FmtUtil.transToCNYType(tradeAccount.getAvailableBalance()));
            tradeAccountVO.setCreateTime(DateUtil.date2String(tradeAccount.getCreateTime()));
            tradeAccountVO
                    .setLastUpdateTime(DateUtil.date2String(tradeAccount.getLastUpdateTime()));

            tradeAccountVO
                    .setFrozenBalance(FmtUtil.transToCNYType(tradeAccount.getFrozenBalance()));
            tradeAccountVO.setAccountStatus(FmtUtil.getAccountStatus(tradeAccount).getName());
            TradeUser tradeUser = tradeUserService.get(tradeAccount.getTradeUserID());
            tradeAccountVO.setUserID(tradeUser.getUserID());

            accountBalance += tradeAccount.getAccountBalance();
            avaliableBalance += tradeAccount.getAvailableBalance();
            frozenBalance += tradeAccount.getFrozenBalance();
            tradeAccountVOList.add(tradeAccountVO);
        }

        result.put("list", tradeAccountVOList);
        result.put("accountBalance", FmtUtil.transToCNYType(accountBalance));
        result.put("avaliableBalance", FmtUtil.transToCNYType(avaliableBalance));
        result.put("frozenBalance", FmtUtil.transToCNYType(frozenBalance));

        return result;
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
     * @param sessSmartUserAccount @param session @return @throws
     */
    @ResponseBody
    @RequestMapping("/showBalance")
    public JsonResult showBalance(HttpSession session) {
        SmartUser smartUser = sessionUtil.getSmartUser(session);
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

    @ResponseBody
    @RequestMapping("/frozePersonalAccount")
    public JsonResult frozePersonalAccount(String account) throws Exception {
        return tradeAccountService.frozeAccount(account, TradeUserType.PERSION);
    }

    @ResponseBody
    @RequestMapping("/activatePersonalAccount")
    public JsonResult activatePersonAccount(String account) throws Exception {
        return tradeAccountService.activeAccount(account, TradeUserType.PERSION);
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
    public JsonResult openCompanyAccount(String deptNO, String deptName, String password,
            String payPhone, @RequestParam(required = false) String payEmail, HttpSession session)
            throws Exception {
        return tradeAccountService.openAccount(deptNO, deptName, password, payPhone, payEmail,
                TradeUserType.DEPARTMENT, 0, 0, 1);
    }

    @ResponseBody
    @RequestMapping("/frozeDepartmentAccount")
    public JsonResult frozeCompanyAccount(String deptNO) throws Exception {
        return tradeAccountService.frozeAccount(deptNO, TradeUserType.DEPARTMENT);
    }

    @ResponseBody
    @RequestMapping("/activateDepartmentAccount")
    public JsonResult activateDepartmentAccount(String deptNO) throws Exception {
        return tradeAccountService.activeAccount(deptNO, TradeUserType.DEPARTMENT);
    }

    @ResponseBody
    @RequestMapping("/openChannelAccount")
    public JsonResult openChannelAccount(String type, String name, String password, String payPhone,
            @RequestParam(required = false) String payEmail, HttpSession session) throws Exception {
        return tradeAccountService.openAccount(type, name, password, payPhone, payEmail,
                TradeUserType.CHANNEL, 0, 0, 1);
    }

    @ResponseBody
    @RequestMapping("/frozeChannelAccount")
    public JsonResult frozeChannelAccount(String type) throws Exception {
        return tradeAccountService.frozeAccount(type, TradeUserType.CHANNEL);
    }

    @ResponseBody
    @RequestMapping("/activateChannelAccount")
    public JsonResult activateChannelAccount(String type) throws Exception {
        return tradeAccountService.activeAccount(type, TradeUserType.CHANNEL);
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
