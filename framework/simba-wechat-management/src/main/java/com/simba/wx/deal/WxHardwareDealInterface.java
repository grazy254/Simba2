package com.simba.wx.deal;

import java.util.Date;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.interfaces.HardwareDealInterface;
import com.simba.model.Device;
import com.simba.model.ReceiveEvent;
import com.simba.model.SendMessage;
import com.simba.model.wxHardware.receive.BindRequestEvent;
import com.simba.model.wxHardware.receive.BindResponseEvent;
import com.simba.model.wxHardware.receive.DeviceRequestMsg;
import com.simba.model.wxHardware.receive.DeviceResponseMsg;
import com.simba.service.DeviceBindService;
import com.simba.service.DeviceService;
import com.simba.service.ReceiveEventService;
import com.simba.service.SendMessageService;

public class WxHardwareDealInterface implements HardwareDealInterface {

	@Override
	public DeviceResponseMsg text(DeviceRequestMsg request, String json) {
		return null;
	}

	@Override
	public BindResponseEvent bind(BindRequestEvent request, String json) {
		long time = request.getCreate_time();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(request.getOpen_id());
		rEvent.setType(request.getMsg_type());
		rEvent.setEvent("bindDevice");
		rEvent.setEventKey(request.getDevice_id());
		rEvent.setXml(json);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
		SendMessageService sendMessageService = ApplicationContextUtil.getBean(SendMessageService.class);
		DeviceService deviceService = ApplicationContextUtil.getBean(DeviceService.class);
		DeviceBindService deviceBindService = ApplicationContextUtil.getBean(DeviceBindService.class);
		Device device = deviceService.getBy("wxDeviceId", request.getDevice_id());
		deviceBindService.bind(device, request.getOpen_id());
		String content = "设备添加成功，请进入设备列表菜单查看";
		SendMessage sendMessage = buildSendMessage(request.getOpen_id(), content);
		sendMessageService.add(sendMessage);
		return buildBindResponse(request);
	}

	private SendMessage buildSendMessage(String openid, String content) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setOpenid(openid);
		sendMessage.setAccount("system");
		sendMessage.setContent(content);
		sendMessage.setDescritption("用户扫描绑定设备");
		sendMessage.setType("text");
		sendMessage.setHqMusicUrl(StringUtils.EMPTY);
		sendMessage.setMediaId(StringUtils.EMPTY);
		sendMessage.setMusicUrl(StringUtils.EMPTY);
		sendMessage.setNews(StringUtils.EMPTY);
		sendMessage.setThumbMediaId(StringUtils.EMPTY);
		sendMessage.setTitle(StringUtils.EMPTY);
		return sendMessage;
	}

	@Override
	public BindResponseEvent unbind(BindRequestEvent request, String json) {
		long time = request.getCreate_time();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(request.getOpen_id());
		rEvent.setType(request.getMsg_type());
		rEvent.setEvent("unbindDevice");
		rEvent.setEventKey(request.getDevice_id());
		rEvent.setXml(json);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
		DeviceBindService service = ApplicationContextUtil.getBean(DeviceBindService.class);
		SendMessageService sendMessageService = ApplicationContextUtil.getBean(SendMessageService.class);
		service.unbind(request.getOpen_id(), request.getDevice_id());
		String content = "设备解除绑定成功";
		SendMessage sendMessage = buildSendMessage(request.getOpen_id(), content);
		sendMessageService.add(sendMessage);
		return buildBindResponseEvent(request);
	}

	private BindResponseEvent buildBindResponse(BindRequestEvent request) {
		BindResponseEvent resp = new BindResponseEvent();
		resp.setContent(StringUtils.EMPTY);
		resp.setOpenID(request.getOpen_id());
		resp.setCreateTime(System.currentTimeMillis() / 1000);
		resp.setDeviceID(request.getDevice_id());
		resp.setDeviceType(request.getDevice_type());
		resp.setMsgId(request.getMsg_id());
		resp.setMsgType(request.getMsg_type());
		resp.setSessionID(request.getSession_id());
		return resp;
	}

	private BindResponseEvent buildBindResponseEvent(BindRequestEvent request) {
		BindResponseEvent resp = new BindResponseEvent();
		resp.setContent(StringUtils.EMPTY);
		resp.setOpenID(request.getOpen_id());
		resp.setCreateTime(System.currentTimeMillis() / 1000);
		resp.setDeviceID(request.getDevice_id());
		resp.setDeviceType(request.getDevice_type());
		resp.setMsgId(request.getMsg_id());
		resp.setMsgType(request.getMsg_type());
		resp.setSessionID(request.getSession_id());
		return resp;
	}
}
