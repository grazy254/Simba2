package com.simba.mobile.message.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.exception.SimbaException;
import com.simba.jpush.msg.model.SendMsgModel;
import com.simba.jpush.msg.util.JpushMsgUtil;
import com.simba.mobile.message.interfaces.SendMsgInterface;
import com.simba.mobile.message.model.MsgType;

/**
 * 极光短信发送手机短信
 * 
 * @author caozhejun
 *
 */
@Component
public class JpsuhSendMsg implements SendMsgInterface {

	private static final Log logger = LogFactory.getLog(JpsuhSendMsg.class);

	@Autowired
	private JpushMsgUtil jpushMsgUtil;

	@Override
	public MsgType getMsgType() {
		return MsgType.JPUSH;
	}

	@Override
	public String send(String mobileNo, String code, Map<String, String> params) {
		try {
			return jpushMsgUtil.sendTemplateSMS(mobileNo, NumberUtils.toInt(code), params);
		} catch (Exception e) {
			logger.error("使用极光短信发送手机短信失败", e);
			throw new SimbaException("使用 极光短信发送手机短信失败" + mobileNo);
		}
	}

	@Override
	public String send(List<String> mobileNoList, String code, Map<String, String> params) {
		List<SendMsgModel> senders = new ArrayList<>(mobileNoList.size());
		mobileNoList.forEach((String mobileNo) -> {
			SendMsgModel model = new SendMsgModel();
			model.setMobile(mobileNo);
			model.setValues(params);
			senders.add(model);
		});
		try {
			jpushMsgUtil.sendBatchTemplateSMS(NumberUtils.toInt(code), senders);
			return StringUtils.EMPTY;
		} catch (Exception e) {
			logger.error("使用极光短信发送手机短信失败", e);
			throw new SimbaException("使用极光短信发送手机短信失败" + mobileNoList.toString());
		}
	}

	@Override
	public boolean isEnabled() {
		return jpushMsgUtil.isEnabled();
	}

}
