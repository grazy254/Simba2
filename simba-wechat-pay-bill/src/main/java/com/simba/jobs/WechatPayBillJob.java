package com.simba.jobs;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.service.PayBillService;

/**
 * 下载对账单定时器
 * 
 * @author caozhejun
 *
 */
@Component
public class WechatPayBillJob {

	@Autowired
	private PayBillService payBillService;

	@Value("${appID}")
	private String appID;

	/**
	 * 下载微信支付对账单进行数据检查
	 * 
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	@Scheduled(cron = "0 10 12 * * *")
	public void checkUnfinishOrder() throws IOException {
		if (StringUtils.isNotEmpty(appID)) {
			payBillService.checkBill();
		}
	}
}
