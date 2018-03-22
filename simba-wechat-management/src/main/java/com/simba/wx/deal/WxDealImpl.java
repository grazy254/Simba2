package com.simba.wx.deal;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.simba.dao.FansDao;
import com.simba.dao.TagFansDao;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.interfaces.DealInterface;
import com.simba.model.AutoReply;
import com.simba.model.Device;
import com.simba.model.Fans;
import com.simba.model.ReceiveEvent;
import com.simba.model.ReceiveMessage;
import com.simba.model.SendMessage;
import com.simba.model.enums.AutoReplyType;
import com.simba.model.wx.receive.deviceEvent.DeviceEvent;
import com.simba.model.wx.receive.deviceEvent.DeviceEventResp;
import com.simba.model.wx.receive.event.BaseEvent;
import com.simba.model.wx.receive.event.GroupMessageEvent;
import com.simba.model.wx.receive.event.LocationEvent;
import com.simba.model.wx.receive.event.MenuEvent;
import com.simba.model.wx.receive.event.ReportLocationEvent;
import com.simba.model.wx.receive.event.ScanCodeEvent;
import com.simba.model.wx.receive.event.SendPhotoEvent;
import com.simba.model.wx.receive.event.TemplateEvent;
import com.simba.model.wx.receive.event.TicketEvent;
import com.simba.model.wx.receive.event.VerifyFailEvent;
import com.simba.model.wx.receive.event.VerifySuccessEvent;
import com.simba.model.wx.receive.msg.ImageMessage;
import com.simba.model.wx.receive.msg.LinkMessage;
import com.simba.model.wx.receive.msg.LocationMessage;
import com.simba.model.wx.receive.msg.TextMessage;
import com.simba.model.wx.receive.msg.VideoMessage;
import com.simba.model.wx.receive.msg.VoiceMessage;
import com.simba.model.wx.user.User;
import com.simba.model.wxHardware.send.BindForce;
import com.simba.service.AutoReplyService;
import com.simba.service.DeviceBindService;
import com.simba.service.DeviceService;
import com.simba.service.ReceiveEventService;
import com.simba.service.ReceiveMessageService;
import com.simba.service.SendMessageService;
import com.simba.util.send.BindWxUtil;
import com.simba.util.send.MediaWxUtil;
import com.simba.util.send.UserWxUtil;

/**
 * 处理微信公众号接收到微信服务器的消息和事件
 * 
 * @author caozhejun
 *
 */
public class WxDealImpl implements DealInterface {

	private static final Log logger = LogFactory.getLog(WxDealImpl.class);

	private static final String connectStatus = "1";

	@Override
	public void text(TextMessage msg, String xml) {
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setContent(msg.getContent());
		message.setMsgId(msg.getMsgId());
		message.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	private void dealAutoReply(String openid, int replyType) {
		AutoReplyService service = ApplicationContextUtil.getBean(AutoReplyService.class);
		List<AutoReply> list = service.listBy("type", replyType);
		if (list.size() > 0) {
			AutoReply reply = list.get(0);
			String content = reply.getContent();
			SendMessageService sendMessageService = ApplicationContextUtil.getBean(SendMessageService.class);
			SendMessage sendMessage = buildSendMessage(openid, content);
			sendMessageService.add(sendMessage);
		}
	}

	private SendMessage buildSendMessage(String openid, String content) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setOpenid(openid);
		sendMessage.setAccount("system");
		sendMessage.setContent(content);
		sendMessage.setDescritption("收到用户发送的信息，自动回复");
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
	public void image(ImageMessage msg, String xml) {
		byte[] file = ApplicationContextUtil.getBean(MediaWxUtil.class).downloadTempMedia(msg.getMediaId());
		String fileUrl = null;
		try {
			fileUrl = UploadUtil.getInstance().getUpload().upload(file, msg.getMsgId() + ".jpg", "wx" + msg.getMsgType());
		} catch (Exception e) {
			logger.error("上传微信媒体文件[图片]到阿里云失败", e);
		}
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setMsgId(msg.getMsgId());
		message.setPicUrl(msg.getPicUrl());
		message.setMediaId(msg.getMediaId());
		message.setXml(xml);
		message.setFileUrl(fileUrl);
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	@Override
	public void voice(VoiceMessage msg, String xml) {
		byte[] file = ApplicationContextUtil.getBean(MediaWxUtil.class).downloadTempMedia(msg.getMediaId());
		String fileUrl = null;
		try {
			fileUrl = UploadUtil.getInstance().getUpload().upload(file, msg.getMsgId() + "." + msg.getFormat(), "wx" + msg.getMsgType());
		} catch (Exception e) {
			logger.error("上传微信媒体文件[语音]到阿里云失败", e);
		}
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setMsgId(msg.getMsgId());
		message.setMediaId(msg.getMediaId());
		message.setFormat(msg.getFormat());
		message.setXml(xml);
		message.setFileUrl(fileUrl);
		message.setRecognition(msg.getRecognition());
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	@Override
	public void video(VideoMessage msg, String xml) {
		byte[] file = ApplicationContextUtil.getBean(MediaWxUtil.class).downloadTempMedia(msg.getMediaId());
		byte[] thumbFile = ApplicationContextUtil.getBean(MediaWxUtil.class).downloadTempMedia(msg.getThumbMediaId());
		String fileUrl = null;
		String thumbFileUrl = null;
		try {
			fileUrl = UploadUtil.getInstance().getUpload().upload(file, msg.getMsgId() + ".mp4", "wx" + msg.getMsgType());
			thumbFileUrl = UploadUtil.getInstance().getUpload().upload(thumbFile, msg.getThumbMediaId() + ".mp4", "wx" + msg.getMsgType());
		} catch (Exception e) {
			logger.error("上传微信媒体文件[视频]到阿里云失败", e);
		}
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setMsgId(msg.getMsgId());
		message.setXml(xml);
		message.setFileUrl(fileUrl);
		message.setThumbFileUrl(thumbFileUrl);
		message.setMediaId(msg.getMediaId());
		message.setThumbMediaId(msg.getThumbMediaId());
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	@Override
	public void location(LocationMessage msg, String xml) {
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setMsgId(msg.getMsgId());
		message.setXml(xml);
		message.setLocationX(msg.getX() + "");
		message.setLocationY(msg.getY() + "");
		message.setMessageLabel(msg.getLabel());
		message.setScale(msg.getScale() + "");
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	@Override
	public void link(LinkMessage msg, String xml) {
		long time = msg.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveMessage message = new ReceiveMessage();
		message.setOpenid(msg.getFromUserName());
		message.setCreateTime(createTime);
		message.setType(msg.getMsgType());
		message.setMsgId(msg.getMsgId());
		message.setXml(xml);
		message.setTitle(msg.getTitle());
		message.setDescription(msg.getDescription());
		message.setUrl(msg.getUrl());
		ApplicationContextUtil.getBean(ReceiveMessageService.class).add(message);
		dealAutoReply(msg.getFromUserName(), AutoReplyType.RECEIVEMSG.getId());
	}

	@Override
	public void clickMenu(BaseEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		addUnsubscribeEvent(event, xml, createTime);
	}

	@Override
	public void clickForward(MenuEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		rEvent.setMenuId(event.getMenuId());
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void scanPush(ScanCodeEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		rEvent.setScanResult(event.getScanResult());
		rEvent.setScanType(event.getScanType());
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
		dealQrcode(rEvent.getOpenid(), event.getScanResult());
	}

	/**
	 * 处理扫描的二维码，如果是设备的微信二维码才处理
	 * 
	 * @param openid
	 * @param qrcode
	 */
	private void dealQrcode(String openid, String qrcode) {
		DeviceService deviceService = ApplicationContextUtil.getBean(DeviceService.class);
		List<Device> deviceList = deviceService.listBy("qrcode", qrcode);
		if (deviceList.size() > 0) {
			Device device = deviceList.get(0);
			DeviceBindService deviceBindService = ApplicationContextUtil.getBean(DeviceBindService.class);
			SendMessageService sendMessageService = ApplicationContextUtil.getBean(SendMessageService.class);
			boolean success = deviceBindService.bind(device, openid);
			if (!success) {
				String content = "设备添加失败";
				SendMessage sendMessage = buildSendMessage(openid, content);
				sendMessageService.add(sendMessage);
				return;
			}
			String content = "设备添加成功，请进入设备列表菜单查看";
			SendMessage sendMessage = buildSendMessage(openid, content);
			sendMessageService.add(sendMessage);
			// 发送绑定通知给微信硬件服务器
			BindWxUtil bindWxUtil = ApplicationContextUtil.getBean(BindWxUtil.class);
			BindForce bind = new BindForce();
			bind.setOpenid(openid);
			bind.setDevice_id(device.getWxDeviceId());
			bindWxUtil.bindForce(bind);
		}
	}

	@Override
	public void scanWait(ScanCodeEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		rEvent.setScanResult(event.getScanResult());
		rEvent.setScanType(event.getScanType());
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
		dealQrcode(rEvent.getOpenid(), event.getScanResult());
	}

	@Override
	public void sysPhoto(SendPhotoEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void photoOrAlbum(SendPhotoEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void weixinPhoto(SendPhotoEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void locationSelect(LocationEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void subscribe(TicketEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		addSubscribeEvent(event, xml, time);
		addFans(event);
		dealAutoReply(event.getFromUserName(), AutoReplyType.SUBSCRIBE.getId());
	}

	private void addFans(TicketEvent event) {
		FansDao fansDao = ApplicationContextUtil.getBean(FansDao.class);
		List<Fans> list = fansDao.listBy("openid", event.getFromUserName());
		if (list.size() == 0) {
			Fans fans = new Fans();
			fans.setOpenid(event.getFromUserName());
			UserWxUtil userWxUtil = ApplicationContextUtil.getBean(UserWxUtil.class);
			User wxUser = userWxUtil.getUserInfo(fans.getOpenid());
			fans.setNickname(wxUser.getNickname());
			fans.setRemark(wxUser.getRemark());
			fans.setSex(wxUser.getSex());
			fans.setCity(wxUser.getCity());
			fans.setProvince(wxUser.getProvince());
			fans.setCountry(wxUser.getCountry());
			fans.setHeadimgurl(wxUser.getHeadimgurl());
			fans.setSubscribeTime(new Date(NumberUtils.toLong(wxUser.getSubscribe_time() + "000")));
			fansDao.add(fans);
		}
	}

	private void addSubscribeEvent(TicketEvent event, String xml, long time) {
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		rEvent.setTicket(StringUtils.defaultString(event.getTicket()));
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void unsubscribe(BaseEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		addUnsubscribeEvent(event, xml, createTime);
		FansDao fansDao = ApplicationContextUtil.getBean(FansDao.class);
		List<Fans> list = fansDao.listBy("openid", event.getFromUserName());
		if (list.size() > 0) {
			Fans fans = list.get(0);
			ApplicationContextUtil.getBean(TagFansDao.class).deleteByFansId(fans.getId());
			ApplicationContextUtil.getBean(FansDao.class).deleteByOpenid(event.getFromUserName());
		}
	}

	private void addUnsubscribeEvent(BaseEvent event, String xml, Date createTime) {
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void scan(TicketEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		addSubscribeEvent(event, xml, time);
	}

	@Override
	public void reportLocation(ReportLocationEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		rEvent.setLatitude(event.getLatitude() + "");
		rEvent.setLongitude(event.getLongitude() + "");
		rEvent.setEventPrecision(event.getPrecision() + "");
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void groupMessage(GroupMessageEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void template(TemplateEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void qualificationVerifySuccess(VerifySuccessEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void qualificationVerifyFail(VerifyFailEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void namingVerifySuccess(VerifySuccessEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void namingVerifyFail(VerifyFailEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void annualRenew(VerifySuccessEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public void verifyExpired(VerifySuccessEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setEventKey(event.getEventKey());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
	}

	@Override
	public DeviceEventResp subscribeStatus(DeviceEvent event, String xml) throws Exception {
		DeviceEventResp resp = buildResp(event, xml);
		// 读取设备状态，返回给微信服务器
		String deviceId = event.getDeviceId();
		// 调用设备监控系统，获取设备状态
		DeviceService deviceService = ApplicationContextUtil.getBean(DeviceService.class);
		String status = deviceService.getDeviceStatus(deviceId);
		resp.setDeviceStatus(connectStatus.equals(status) ? "1" : "0");
		return resp;
	}

	@Override
	public DeviceEventResp unsubscribeStatus(DeviceEvent event, String xml) {
		DeviceEventResp resp = buildResp(event, xml);
		resp.setDeviceStatus("0");
		return resp;
	}

	private DeviceEventResp buildResp(DeviceEvent event, String xml) {
		long time = event.getCreateTime();
		time = NumberUtils.toLong(time + "000");
		Date createTime = new Date(time);
		ReceiveEvent rEvent = new ReceiveEvent();
		rEvent.setCreateTime(createTime);
		rEvent.setOpenid(event.getFromUserName());
		rEvent.setType(event.getMsgType());
		rEvent.setEvent(event.getEvent());
		rEvent.setXml(xml);
		ApplicationContextUtil.getBean(ReceiveEventService.class).add(rEvent);
		DeviceEventResp resp = new DeviceEventResp();
		resp.setCreateTime(System.currentTimeMillis() / 1000);
		resp.setFromUserName(event.getToUserName());
		resp.setToUserName(event.getFromUserName());
		resp.setMsgType("device_status");
		resp.setDeviceType(event.getDeviceType());
		resp.setDeviceId(event.getDeviceId());
		return resp;
	}

}
