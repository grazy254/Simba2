package com.simba.controller.api;

import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.controller.enums.CardMoneyBillStatus;
import com.simba.controller.enums.LooseMoneyBillStatus;
import com.simba.controller.form.CardTransferForm;
import com.simba.controller.form.LooseMoneyTransferForm;
import com.simba.enterprise.pay.model.card.CardReq;
import com.simba.enterprise.pay.model.card.CardRes;
import com.simba.enterprise.pay.model.loosemoney.LooseMoneyReq;
import com.simba.enterprise.pay.model.loosemoney.LooseMoneyRes;
import com.simba.enterprise.pay.util.send.WxEnterprisePayUtil;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.data.RandomUtil;
import com.simba.framework.util.json.JsonResult;
import com.simba.model.CardMoneyBill;
import com.simba.model.LooseMoneyBill;
import com.simba.service.CardMoneyBillService;
import com.simba.service.LooseMoneyBillService;

/**
 * 微信企业支付api接口Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/api/wechatEnterprisePay")
public class WechatEnterprisePayApiController {

	private WxEnterprisePayUtil wxEnterprisePayUtil;

	@Value("${appID}")
	private String appID;

	@Value("${wx.pay.mchid}")
	private String mchid;

	@Autowired
	private LooseMoneyBillService looseMoneyBillService;

	@Autowired
	private CardMoneyBillService cardMoneyBillService;

	@PostConstruct
	private void init() {
		wxEnterprisePayUtil = WxEnterprisePayUtil.getInstance();
	}

	/**
	 * 企业给用户转账到零钱
	 * 
	 * @param looseMoneyTransferForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/transfersLooseMoney")
	public JsonResult transfersLooseMoney(LooseMoneyTransferForm looseMoneyTransferForm, HttpServletRequest request) throws ParseException, IOException {
		looseMoneyTransferForm.setPartner_trade_no(RandomUtil.random32Chars());
		LooseMoneyReq looseMoneyReq = new LooseMoneyReq();
		looseMoneyReq.setAmount(looseMoneyTransferForm.getAmount());
		looseMoneyReq.setCheck_name(looseMoneyTransferForm.getCheck_name());
		looseMoneyReq.setDesc(looseMoneyTransferForm.getDesc());
		looseMoneyReq.setDevice_info(looseMoneyTransferForm.getDevice_info());
		looseMoneyReq.setOpenid(looseMoneyTransferForm.getOpenid());
		looseMoneyReq.setPartner_trade_no(looseMoneyTransferForm.getPartner_trade_no());
		looseMoneyReq.setRe_user_name(looseMoneyTransferForm.getRe_user_name());
		looseMoneyReq.setSpbill_create_ip(StringUtils.defaultString(looseMoneyTransferForm.getSpbill_create_ip(), ServerUtil.getProxyIp(request)));
		LooseMoneyRes res = wxEnterprisePayUtil.transfersLooseMoney(looseMoneyReq);
		LooseMoneyBill bill = new LooseMoneyBill();
		bill.setAppid(appID);
		bill.setMchid(mchid);
		bill.setDeviceInfo(looseMoneyTransferForm.getDevice_info());
		bill.setPartnerTradeNo(looseMoneyTransferForm.getPartner_trade_no());
		bill.setOpenid(looseMoneyTransferForm.getOpenid());
		bill.setReUserName(looseMoneyTransferForm.getRe_user_name());
		bill.setAmount(looseMoneyTransferForm.getAmount());
		bill.setDescription(looseMoneyTransferForm.getDesc());
		bill.setClientIp(looseMoneyReq.getSpbill_create_ip());
		bill.setErrMsg(res.getErr_code_des());
		bill.setPaymentNo(res.getPayment_no());
		bill.setPaymentTime(res.getPayment_time());
		bill.setCreateTime(new Date());
		bill.setCreateUser(StringUtils.EMPTY);
		if (StringUtils.isNotEmpty(bill.getPaymentNo())) {
			bill.setStatus(LooseMoneyBillStatus.PROCESSING.getStatus());
		} else {
			bill.setStatus(LooseMoneyBillStatus.FAILED.getStatus());
		}
		looseMoneyBillService.add(bill);
		return new JsonResult(res);
	}

	/**
	 * 按照商户订单号 查找企业给用户的付款详情(付款到零钱)
	 * 
	 * @param partner_trade_no
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/searchLooseMoney")
	public JsonResult searchLooseMoney(String partner_trade_no) throws ParseException, IOException {
		return new JsonResult(wxEnterprisePayUtil.searchLooseMoney(partner_trade_no));
	}

	/**
	 * 企业给用户转账到银行卡
	 * 
	 * @param cardTransferForm
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/transfersCard")
	public JsonResult transfersCard(CardTransferForm cardTransferForm) throws Exception {
		cardTransferForm.setPartner_trade_no(RandomUtil.random32Chars());
		CardReq cardReq = new CardReq();
		cardReq.setPartner_trade_no(cardTransferForm.getPartner_trade_no());
		cardReq.setAmount(cardTransferForm.getAmount());
		cardReq.setBank_code(cardTransferForm.getBank_code());
		cardReq.setDesc(cardTransferForm.getDesc());
		cardReq.setEnc_bank_no(cardTransferForm.getEnc_bank_no());
		cardReq.setEnc_true_name(cardTransferForm.getTrueName());
		CardRes res = wxEnterprisePayUtil.transfersCard(cardReq);
		CardMoneyBill bill = new CardMoneyBill();
		bill.setMchId(mchid);
		bill.setPartnerTradeNo(cardTransferForm.getPartner_trade_no());
		bill.setBankNo(cardTransferForm.getEnc_bank_no());
		bill.setTrueName(cardTransferForm.getTrueName());
		bill.setBankCode(cardTransferForm.getBank_code());
		bill.setAmount(cardTransferForm.getAmount());
		bill.setDescription(cardTransferForm.getDesc());
		if (StringUtils.isNotEmpty(bill.getPaymentNo())) {
			bill.setStatus(CardMoneyBillStatus.PROCESSING.getStatus());
		} else {
			bill.setStatus(CardMoneyBillStatus.FAILED.getStatus());
		}
		bill.setErrMsg(res.getErr_code_des());
		bill.setPaymentNo(res.getPayment_no());
		bill.setCmmsAmt(res.getCmms_amt());
		bill.setCreateTime(new Date());
		bill.setCreateUser(StringUtils.EMPTY);
		cardMoneyBillService.add(bill);
		return new JsonResult(res);
	}

	/**
	 * 按照商户订单号 查找企业给用户的付款详情(付款到银行卡)
	 * 
	 * @param partner_trade_no
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/searchCard")
	public JsonResult searchCard(String partner_trade_no) throws ParseException, IOException {
		return new JsonResult(wxEnterprisePayUtil.searchCard(partner_trade_no));
	}

}
