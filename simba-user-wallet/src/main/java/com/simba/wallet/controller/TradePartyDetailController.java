package com.simba.wallet.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.simba.framework.util.date.DateTime;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeDetail;
import com.simba.wallet.model.TradePartyDetail;
import com.simba.wallet.model.enums.TradeUserType;
import com.simba.wallet.model.vo.TradePartyVO;
import com.simba.wallet.service.TradeDetailService;
import com.simba.wallet.service.TradePartyDetailService;
import com.simba.wallet.service.TradeUserService;
import com.simba.wallet.util.CommonUtil;
import com.simba.wallet.util.SessionUtil;

/**
 * 交易主体控制器
 * 
 * @author caozj
 * 
 */
@Controller
@RequestMapping("/tradePartyDetail")
public class TradePartyDetailController {

    @Autowired
    private TradePartyDetailService tradePartyDetailService;

    @Autowired
    private TradeDetailService tradeDetailService;

    @Autowired
    private TradeUserService tradeUserService;

    @Autowired
    private SessionUtil sessionUtil;



    @ResponseBody
    @RequestMapping("/list")
    public List<TradePartyVO> list(Integer pageStart,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date tradeDate,
            HttpSession session) {

        List<TradePartyDetail> tradePartyDetailList = null;
        if (tradeDate != null) {
            tradePartyDetailList = tradePartyDetailService.pageByAnd("tradeUserID",
                    tradeUserService.get(sessionUtil.getSmartUser(session).getAccount(),
                            TradeUserType.PERSION).getId(),
                    "createDate", tradeDate, new Pager((pageStart - 1) * 10, 10));
        } else {
            tradePartyDetailList =
                    tradePartyDetailService.pageBy("tradeUserID",
                            tradeUserService.get(sessionUtil.getSmartUser(session).getAccount(),
                                    TradeUserType.PERSION).getId(),
                            new Pager((pageStart - 1) * 10, 10));
        }

        List<TradePartyVO> result = new ArrayList<>();
        for (TradePartyDetail detail : tradePartyDetailList) {
            TradeDetail tradeDetail = tradeDetailService.getBy("tradePartyID", detail.getId());
            if (tradeDetail != null) {
                TradePartyVO vo = new TradePartyVO();
                vo.setTradeAmount(CommonUtil.transToCNYType(tradeDetail.getPaymentAmount()));
                vo.setTradeStatus("充值" + CommonUtil.fmtTradeStatus(tradeDetail.getTradeStatus()));
                vo.setTradeTime(DateTime.getTime(tradeDetail.getTradePaymentTime()));
                vo.setTradeType(CommonUtil.fmtTradeType(tradeDetail.getTradeType()));
                result.add(vo);
            }
        }
        return result;
    }

}
