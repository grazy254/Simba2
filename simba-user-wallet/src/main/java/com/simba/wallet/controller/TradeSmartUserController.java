package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.enums.AccountStatus;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.form.TradeSmartUserSearchForm;
import com.simba.wallet.model.vo.TradeSmartUserVO;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;

/**
 * 钱包用户信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeSmartUser")
public class TradeSmartUserController {

    @Autowired
    private TradeUserService tradeUserService;

    @Autowired
    private TradeAccountService tradeAccountService;

    @RequestMapping("/doSearch")
    public String getTradeSmartUser(TradeSmartUserSearchForm tradeSmartUserSearchForm,
            ModelMap model) {

        if (StringUtils.isEmpty(tradeSmartUserSearchForm.getUserID())) {
            return "trade/list";
        }

        TradeUser tradeUser =
                tradeUserService.get(tradeSmartUserSearchForm.getUserID(), TradeUserType.PERSION);
        List<TradeSmartUserVO> tradeSmartUserVOList = new ArrayList<>();
        String accountStatus = AccountStatus.NOTEXIST.getName();
        TradeAccount tradeAccount = null;
        try {
            tradeAccount = tradeAccountService.get(tradeUser.getId(), TradeUserType.PERSION);
            accountStatus = CommonUtil.getAccountStatus(tradeAccount).getName();
        } catch (Exception e) {

        }
        TradeSmartUserVO vo = new TradeSmartUserVO();
        vo.setId(tradeUser.getId());
        vo.setAccount(tradeUser.getUserID());
        vo.setAccountStatus(accountStatus);
        // TODO: 判断账户的状态是否激活
        vo.setIsAllowPay(tradeUser.getIsAllowPay() == 1 ? "允许" : "不允许");
        vo.setUserStatus(CommonUtil.getUserStatus(tradeUser).getName());
        vo.setName(tradeUser.getName());
        vo.setCreateTime(DateUtil.date2String(tradeUser.getCreateTime()));
        vo.setLastUpdateTime(DateUtil.date2String(tradeUser.getLastUpdateTime()));
        tradeSmartUserVOList.add(vo);

        model.put("list", tradeSmartUserVOList);

        return "tradeSmartUser/table";
    }

    @RequestMapping("/list")
    public String list() {
        return "tradeSmartUser/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        List<TradeUser> list =
                tradeUserService.pageBy("type", TradeUserType.PERSION.getName(), pager);
        List<TradeSmartUserVO> tradeSmartUserVOList = new ArrayList<>();
        for (TradeUser tradeUser : list) {
            String accountStatus = AccountStatus.NOTEXIST.getName();
            TradeAccount tradeAccount = null;

            tradeAccount = tradeAccountService.get(tradeUser.getUserID(), TradeUserType.PERSION);
            accountStatus = CommonUtil.getAccountStatus(tradeAccount).getName();

            TradeSmartUserVO vo = new TradeSmartUserVO();
            vo.setId(tradeUser.getId());
            vo.setAccount(tradeUser.getUserID());
            vo.setAccountStatus(accountStatus);
            // TODO: 判断账户的状态是否激活
            vo.setIsAllowPay(tradeUser.getIsAllowPay() == 1 ? "允许" : "不允许");
            vo.setUserStatus(CommonUtil.getUserStatus(tradeUser).getName());
            vo.setName(tradeUser.getName());
            vo.setCreateTime(DateUtil.date2String(tradeUser.getCreateTime()));
            vo.setLastUpdateTime(DateUtil.date2String(tradeUser.getLastUpdateTime()));
            tradeSmartUserVOList.add(vo);
        }
        model.put("list", tradeSmartUserVOList);
        return "tradeSmartUser/table";
    }

    @ResponseBody
    @RequestMapping("/activateSmartUserPayment")
    public JsonResult activateSmartUserPayment(String account) throws Exception {
        return tradeUserService.activatePayment(account, TradeUserType.PERSION);
    }

    @ResponseBody
    @RequestMapping("/frozeSmartUserPayment")
    public JsonResult frozeSmartUserPayment(String account) throws Exception {
        return tradeUserService.frozePayment(account, TradeUserType.PERSION);
    }

    // @ResponseBody
    // @RequestMapping("/add")
    // public JsonResult add(TradeUser tradeUser) {
    // tradeUserService.add(tradeUser);
    // return new JsonResult();
    // }

    // @ResponseBody
    // @RequestMapping("/update")
    // public JsonResult update(TradeUser tradeUser) {
    // tradeUserService.update(tradeUser);
    // return new JsonResult();
    // }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count(TradeUser tradeUser) {
        tradeUserService.count();
        return new JsonResult();
    }
}
