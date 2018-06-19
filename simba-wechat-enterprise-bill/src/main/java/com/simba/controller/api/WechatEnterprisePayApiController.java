package com.simba.controller.api;

import java.io.IOException;

import org.apache.http.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simba.controller.form.CardTransferForm;
import com.simba.controller.form.LooseMoneyTransferForm;
import com.simba.enterprise.pay.model.card.CardReq;
import com.simba.enterprise.pay.model.loosemoney.LooseMoneyReq;
import com.simba.enterprise.pay.util.send.WxEnterprisePayUtil;
import com.simba.framework.util.json.JsonResult;

/**
 * 微信企业支付api接口Controller
 * 
 * @author caozhejun
 *
 */
@RestController
@RequestMapping("/wechatEnterprisePayApi")
public class WechatEnterprisePayApiController {

	private WxEnterprisePayUtil wxEnterprisePayUtil;

	/**
	 * 企业给用户转账到零钱
	 * 
	 * @param looseMoneyTransferForm
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	@RequestMapping("/transfersLooseMoney")
	public JsonResult transfersLooseMoney(LooseMoneyTransferForm looseMoneyTransferForm) throws ParseException, IOException {
		LooseMoneyReq looseMoneyReq = new LooseMoneyReq();
		looseMoneyReq.setAmount(looseMoneyTransferForm.getAmount());
		looseMoneyReq.setCheck_name(looseMoneyTransferForm.getCheck_name());
		looseMoneyReq.setDesc(looseMoneyTransferForm.getDesc());
		looseMoneyReq.setDevice_info(looseMoneyTransferForm.getDevice_info());
		looseMoneyReq.setOpenid(looseMoneyTransferForm.getOpenid());
		looseMoneyReq.setPartner_trade_no(looseMoneyTransferForm.getPartner_trade_no());
		looseMoneyReq.setRe_user_name(looseMoneyTransferForm.getRe_user_name());
		looseMoneyReq.setSpbill_create_ip(looseMoneyTransferForm.getSpbill_create_ip());

		return new JsonResult(wxEnterprisePayUtil.transfersLooseMoney(looseMoneyReq), "", 200);
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

		return new JsonResult(wxEnterprisePayUtil.searchLooseMoney(partner_trade_no), "", 200);
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
		CardReq cardReq = new CardReq();
		cardReq.setPartner_trade_no(cardTransferForm.getPartner_trade_no());
		cardReq.setAmount(cardTransferForm.getAmount());
		cardReq.setBank_code(cardTransferForm.getBank_code());
		cardReq.setDesc(cardTransferForm.getDesc());
		return new JsonResult(wxEnterprisePayUtil.transfersCard(cardReq), "", 200);
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

		return new JsonResult(wxEnterprisePayUtil.searchCard(partner_trade_no), "", 200);
	}

}
