package com.simba.msg.util;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alicom.mns.tools.DefaultAlicomMessagePuller;
import com.alicom.mns.tools.MessageListener;
import com.aliyun.mns.model.Message;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import com.simba.exception.SimbaException;
import com.simba.framework.util.common.StringUtil;
import com.simba.framework.util.json.FastJsonUtil;
import com.simba.msg.interfaces.DealAliMsgCallback;
import com.simba.msg.model.SearchForm;
import com.simba.msg.model.SmsReport;
import com.simba.msg.model.SmsUp;

/**
 * 使用阿里云的短信服务发送手机短信的工具类
 * 
 * @author caozhejun
 *
 */
@Component
public class AliMsgService {

	private static final Log logger = LogFactory.getLog(AliMsgService.class);

	@Value("${aliyun.accessKeyId}")
	private String accessId;

	@Value("${aliyun.accessKeySecret}")
	private String accessKeySecret;

	@Value("${aliyun.msg.sign}")
	private String sign;

	@Value("${aliyun.sms.report.queue.name}")
	private String repoertQueue;

	@Value("${aliyun.sms.up.queue.name}")
	private String upQueue;

	private IAcsClient acsClient;

	@Autowired(required = false)
	private DealAliMsgCallback callback;

	private DefaultAlicomMessagePuller puller;

	private boolean enabled = false;

	public boolean isEnabled() {
		return enabled;
	}

	@PostConstruct
	private void init() throws ClientException, ParseException, XPathExpressionException {
		if (StringUtils.isEmpty(accessId) || StringUtils.isEmpty(accessKeySecret) || StringUtils.isEmpty(sign)) {
			return;
		}
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient需要的几个参数
		final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
		// 初始化ascClient,暂时不支持多region（请勿修改）
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessId, accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		acsClient = new DefaultAcsClient(profile);
		// 处理阿里云短信服务回调
		dealCallback();
		enabled = true;
	}

	/**
	 * 处理阿里云短信服务回调
	 * 
	 * @throws ParseException
	 * @throws ClientException
	 */
	private void dealCallback() throws ClientException, ParseException {
		if (callback != null) {
			puller = new DefaultAlicomMessagePuller();
			dealReport();
			dealUp();
		}
	}

	/**
	 * 处理短信回执消息
	 * 
	 * @throws ParseException
	 * @throws ClientException
	 */
	private void dealUp() throws ClientException, ParseException {
		if (StringUtils.isEmpty(upQueue)) {
			return;
		}
		MessageListener upListener = new MessageListener() {
			@SuppressWarnings("unchecked")
			public boolean dealMessage(Message message) {
				SmsUp up = new SmsUp();
				Gson gson = new Gson();
				Map<String, Object> contentMap = gson.fromJson(message.getMessageBodyAsString(), HashMap.class);
				up.setContent((String) contentMap.get("content"));
				up.setDest_code((String) contentMap.get("dest_code"));
				up.setPhone_number((String) contentMap.get("phone_number"));
				up.setSend_time((String) contentMap.get("send_time"));
				up.setSequence_id((Double) contentMap.get("sequence_id"));
				callback.dealUp(up);
				return true;
			}
		};
		puller.startReceiveMsg(accessId, accessKeySecret, "SmsUp", upQueue, upListener);
	}

	/**
	 * 处理上行短信消息
	 * 
	 * @throws ParseException
	 * @throws ClientException
	 */
	private void dealReport() throws ClientException, ParseException {
		if (StringUtils.isEmpty(repoertQueue)) {
			return;
		}
		MessageListener reportListener = new MessageListener() {
			@SuppressWarnings("unchecked")
			public boolean dealMessage(Message message) {
				SmsReport report = new SmsReport();
				Gson gson = new Gson();
				Map<String, Object> contentMap = gson.fromJson(message.getMessageBodyAsString(), HashMap.class);
				String phoneNumber = (String) contentMap.get("phone_number");
				Boolean success = (Boolean) contentMap.get("success");
				String bizId = (String) contentMap.get("biz_id");
				String outId = (String) contentMap.get("out_id");
				String sendTime = (String) contentMap.get("send_time");
				String reportTime = (String) contentMap.get("report_time");
				String errCode = (String) contentMap.get("err_code");
				String errMsg = (String) contentMap.get("err_msg");
				report.setPhone_number(phoneNumber);
				report.setSuccess(success);
				report.setBiz_id(bizId);
				report.setOut_id(outId);
				report.setSend_time(sendTime);
				report.setReport_time(reportTime);
				report.setErr_code(errCode);
				report.setErr_msg(errMsg);
				callback.dealReport(report);
				return true;
			}
		};
		puller.startReceiveMsg(accessId, accessKeySecret, "SmsReport", repoertQueue, reportListener);
	}

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNo
	 *            接收短信的手机号
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 * @throws ClientException
	 * @throws ServerException
	 */
	public String send(String mobileNo, String code, Map<String, String> params) throws ServerException, ClientException {
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(mobileNo);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(sign);
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(code);
		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
		request.setTemplateParam(FastJsonUtil.toJson(params));
		// 可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		// request.setOutId("yourOutId");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			// 请求成功
			logger.info("发送手机短信成功:[" + mobileNo + "][code:" + code + "]");
			return sendSmsResponse.getBizId();
		} else {
			throw new SimbaException("发送手机短信失败:[" + mobileNo + "][code:" + code + "][" + sendSmsResponse.getMessage() + "][" + sendSmsResponse.getCode() + "]");
		}
	}

	/**
	 * 发送手机短信
	 * 
	 * @param mobileNoList
	 *            接收短信的手机号列表
	 * @param code
	 *            阿里云短信模板编码
	 * @param params
	 *            模板中的参数
	 * @throws ClientException
	 * @throws ServerException
	 */
	public String send(List<String> mobileNoList, String code, Map<String, String> params) throws ServerException, ClientException {
		String mobileNos = StringUtil.join(mobileNoList, ",");
		return send(mobileNos, code, params);
	}

	/**
	 * 短信发送记录查询
	 * 
	 * @param form
	 * @return
	 * @throws ClientException
	 * @throws ServerException
	 */
	public QuerySendDetailsResponse search(SearchForm form) throws ServerException, ClientException {
		// 组装请求对象
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
		// 必填-号码
		request.setPhoneNumber(form.getPhoneNumber());
		// 可选-调用发送短信接口时返回的BizId
		request.setBizId(form.getBizId());
		// 必填-短信发送的日期 支持30天内记录查询（可查其中一天的发送数据），格式yyyyMMdd
		request.setSendDate(form.getSendDate());
		// 必填-页大小
		request.setPageSize(form.getPageSize());
		// 必填-当前页码从1开始计数
		request.setCurrentPage(form.getCurrentPage());
		// hint 此处可能会抛出异常，注意catch
		QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
		// 获取返回结果
		if (querySendDetailsResponse.getCode() != null && querySendDetailsResponse.getCode().equals("OK")) {
			// 代表请求成功
			logger.info("短信发送记录查询成功");
			return querySendDetailsResponse;
		} else {
			throw new SimbaException("短信发送记录查询失败:" + form.toString() + "[" + querySendDetailsResponse.getCode() + "," + querySendDetailsResponse.getMessage() + "]");
		}
	}
}
