package com.simba.controller.jobs;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

/**
 * 微信企业支付到卡定时任务
 * 
 * @author caozhejun
 *
 */
@Component
public class WechatEnterprisePayJob {

	@Value("${appID}")
	private String appID;
	
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
		if (StringUtils.isNotEmpty(appID)) {
			
		}
	}
}
