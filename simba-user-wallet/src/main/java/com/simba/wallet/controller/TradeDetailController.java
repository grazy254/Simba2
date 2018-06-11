package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.base.Strings;
import com.simba.framework.util.date.DateTime;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.json.JsonResult;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradeUser;
import com.simba.wallet.model.form.TradeDetailSearchForm;
import com.simba.wallet.model.vo.TradeDetailVO;
import com.simba.wallet.service.TradeChannelDetailService;
import com.simba.wallet.service.TradeChannelService;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradePartyDetailService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.Constants.TradeStatus;
import com.simba.wallet.util.Constants.TradeType;
import com.simba.wallet.util.Constants.TradeUserType;
import com.simba.wallet.util.ErrConfig;
import com.simba.wallet.util.SessionUtil;

/**
 * 交易详情信息控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradeDetail")
public class TradeDetailController {

    @Autowired
    private TradeDetailService tradeDetailService;

    @Autowired
    private TradeUserService tradeUserService;

    @Autowired
    private TradePartyDetailService tradePartyDetailService;

    @Autowired
    private TradeChannelDetailService tradeChannelDetailService;

    @Autowired
    private TradeChannelService tradeChannelService;

    @Autowired
    private SessionUtil sessionUtil;

    @RequestMapping("/list")
    public String list(ModelMap model) {
        model.put("tradeUserTypeList", TradeUserType.values());
        model.put("tradeTypeList", TradeType.values());
        model.put("tradeStatusList", TradeStatus.values());
        return "tradeDetail/list";
    }

    @RequestMapping("/getList")
    public String getList(Pager pager, ModelMap model) {
        model.put("list", getTradeDetailVOList(tradeDetailService.page(pager)));
        return "tradeDetail/table";
    }

    @RequestMapping("/doSearch")
    public String getList(Pager pager, TradeDetailSearchForm tradeDetailSearchForm,
            ModelMap model) {
        model.put("list", getList(pager, tradeDetailSearchForm));
        return "tradeDetail/table";
    }

    @ResponseBody
    @RequestMapping("/count")
    public JsonResult count(TradeDetailSearchForm tradeDetailSearchForm) {
        Long count = tradeDetailService.count(fillTradeUserID(tradeDetailSearchForm));
        return new JsonResult(count, "", 200);
    }

    @ResponseBody
    @RequestMapping("/search")
    public List<TradeDetailVO> search(Integer pageStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tradeDate,
            HttpSession session) {
        TradeDetailSearchForm tradeDetailSearchFrom = new TradeDetailSearchForm();
        tradeDetailSearchFrom.setUserID(sessionUtil.getSmartUser(session).getAccount());
        tradeDetailSearchFrom.setTradeUserType(TradeUserType.PERSION.getName());
        if (tradeDate != null) {
            tradeDetailSearchFrom.setStartTime(DateUtil.getTime(tradeDate));
        }
        return getList(new Pager((pageStart - 1) * 10, 10), tradeDetailSearchFrom);
    }

    public List<TradeDetailVO> getList(Pager page, TradeDetailSearchForm tradeDetailSearchForm) {
        return getTradeDetailVOList(
                tradeDetailService.page(page, fillTradeUserID(tradeDetailSearchForm)));
    }

    private List<TradeDetailVO> getTradeDetailVOList(List<TradeDetail> tradeDetailList) {
        List<TradeDetailVO> result = new ArrayList<>();
        for (TradeDetail tradeDetail : tradeDetailList) {
            TradeDetailVO vo = new TradeDetailVO();
            vo.setPaymentAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount()));
            vo.setTradeStatus(CommonUtil.getTradeStatusValue(tradeDetail.getTradeStatus()));
            vo.setTradePaymentTime(DateTime.getTime(tradeDetail.getTradePaymentTime()));
            vo.setTradeType(CommonUtil.getTradeTypeValue(tradeDetail.getTradeType()));
            if (tradeDetail.getTradeChannelID() >= 0) {
                vo.setChannelName(tradeChannelService.get(tradeChannelDetailService
                        .get(tradeDetail.getTradeChannelID()).getChannelID()).getName());
            }

            vo.setCreateTime(DateUtil.date2String(tradeDetail.getCreateTime()));
            vo.setFeeType(tradeDetail.getFeeType());
            vo.setLastUpdateTime(DateUtil.date2String(tradeDetail.getLastUpdateTime()));
            vo.setOrderNO(tradeDetail.getOrderNO());
            vo.setOriginalAmount(CommonUtil.transToCNYType(tradeDetail.getOriginalAmount()));
            vo.setPaymentAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount()));
            vo.setTradeCounterpartyName(tradePartyDetailService
                    .get(tradeDetail.getTradeCounterpartyID()).getPartyName());
            vo.setTradeCreateTime(DateUtil.date2String(tradeDetail.getTradeCreateTime()));
            vo.setTradeNO(Long.toString(tradeDetail.getTradeNO()));
            vo.setTradePartyName(
                    tradePartyDetailService.get(tradeDetail.getTradePartyID()).getPartyName());
            vo.setTradePaymentTime(DateUtil.date2String(tradeDetail.getTradePaymentTime()));
            result.add(vo);
        }
        return result;
    }

    private TradeDetailSearchForm fillTradeUserID(TradeDetailSearchForm tradeDetailSearchForm) {
        if (!Strings.isNullOrEmpty(tradeDetailSearchForm.getUserID())) {
            if (!Strings.isNullOrEmpty(tradeDetailSearchForm.getTradeUserType())) {
                TradeUser tradeUser = tradeUserService.get(tradeDetailSearchForm.getUserID(),
                        CommonUtil.getTradeUserType(tradeDetailSearchForm.getTradeUserType()));
                tradeDetailSearchForm.setTradeUserID(tradeUser.getId());
            } else {
                throw ErrConfig.INVALID_PARAMETER;
            }
        }
        return tradeDetailSearchForm;
    }
}
