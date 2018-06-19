package com.simba.jobs;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

import com.simba.service.AliPayBillService;

/**
 * 定时更新微信支付订单定时器
 * 
 * @author caozhejun
 *
 */
@Component
public class AliPayPayJob {

	@Autowired
	private AliPayBillService aliPayBillService;

	/**
	 * 查询未完成的订单，更新其状态
	 * 
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @throws DOMException
	 */
	@Scheduled(cron = "0 0/2 * * * *")
	public void checkUnfinishOrder() throws DOMException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		aliPayBillService.checkUnfinishOrder();
	}
}
