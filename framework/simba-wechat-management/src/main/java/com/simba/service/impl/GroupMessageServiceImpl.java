package com.simba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.GroupMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.GroupMessage;
import com.simba.model.enums.GroupMessageType;
import com.simba.model.enums.SendStatus;
import com.simba.model.form.GroupMessageSearchForm;
import com.simba.model.wx.group.GroupResult;
import com.simba.model.wx.group.GroupStatus;
import com.simba.model.wx.group.filter.Filter;
import com.simba.model.wx.group.filter.GroupImage;
import com.simba.model.wx.group.openid.GroupText;
import com.simba.model.wx.group.openid.MpVideo;
import com.simba.model.wx.msg.Image;
import com.simba.model.wx.msg.MpNews;
import com.simba.model.wx.msg.Text;
import com.simba.model.wx.msg.Voice;
import com.simba.service.GroupMessageService;
import com.simba.util.send.GroupMessageWxUtil;
import com.simba.util.send.PreviewGroupMessageWxUtil;
import com.simba.util.send.SendGroupMessageByOpenIDWxUtil;
import com.simba.util.send.SendGroupMessageByTagWxUtil;

/**
 * 群发消息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class GroupMessageServiceImpl implements GroupMessageService {

	@Autowired
	private GroupMessageDao groupMessageDao;

	@Autowired
	private GroupMessageWxUtil groupMessageWxUtil;

	@Autowired
	private SendGroupMessageByOpenIDWxUtil sendGroupMessageByOpenIDWxUtil;

	@Autowired
	private SendGroupMessageByTagWxUtil sendGroupMessageByTagWxUtil;

	@Autowired
	private PreviewGroupMessageWxUtil previewGroupMessageWxUtil;

	@Override
	public void add(GroupMessage groupMessage) {
		if (groupMessage.getWxTagId() == null) {
			groupMessage.setWxTagId(0);
		}
		groupMessage.setCreateTime(new Date());
		sendGroupMessageToWx(groupMessage);
		groupMessageDao.add(groupMessage);
	}

	/**
	 * 群发消息到微信
	 * 
	 * @param groupMessage
	 */
	private void sendGroupMessageToWx(GroupMessage groupMessage) {
		String type = groupMessage.getType();
		GroupResult result = null;
		boolean sendOpenids = true;
		if (groupMessage.getIsAll() == 1 || (groupMessage.getWxTagId() != null && groupMessage.getWxTagId() > 0)) {
			sendOpenids = false;
		}
		if (GroupMessageType.TEXT.getName().equals(type)) {
			if (sendOpenids) {
				result = sendTextByOpenids(groupMessage);
			} else {
				result = sendTextByFilter(groupMessage);
			}
		} else if (GroupMessageType.IMAGE.getName().equals(type)) {
			if (sendOpenids) {
				result = sendImageByOpenids(groupMessage);
			} else {
				result = sendImageByFilter(groupMessage);
			}
		} else if (GroupMessageType.VOICE.getName().equals(type)) {
			if (sendOpenids) {
				result = sendVoiceByOpenids(groupMessage);
			} else {
				result = sendVoiceByFilter(groupMessage);
			}
		} else if (GroupMessageType.VIDEO.getName().equals(type)) {
			if (sendOpenids) {
				result = sendVideoByOpenids(groupMessage);
			} else {
				result = sendVideoByFilter(groupMessage);
			}
		} else if (GroupMessageType.NEWS.getName().equals(type)) {
			if (sendOpenids) {
				result = sendNewsByOpenids(groupMessage);
			} else {
				result = sendNewsByFilter(groupMessage);
			}
		} else {
			throw new RuntimeException("类型错误");
		}
		groupMessage.setJson(result.getJson());
		groupMessage.setStatus(SendStatus.SENDED.getId());
		groupMessage.setMsgId(result.getMsg_id() + "");
		groupMessage.setMsgDataId(result.getMsg_data_id() + "");
	}

	private GroupResult sendNewsByFilter(GroupMessage groupMessage) {
		com.simba.model.wx.group.filter.GroupMpNews msg = new com.simba.model.wx.group.filter.GroupMpNews();
		Filter filter = setFilter(groupMessage);
		msg.setFilter(filter);
		MpNews mpnews = new MpNews();
		mpnews.setMedia_id(groupMessage.getMediaId());
		msg.setMpnews(mpnews);
		return sendGroupMessageByTagWxUtil.send(msg);
	}

	private GroupResult sendNewsByOpenids(GroupMessage groupMessage) {
		com.simba.model.wx.group.openid.GroupMpNews msg = new com.simba.model.wx.group.openid.GroupMpNews();
		msg.setTouser(setToUsers(groupMessage));
		MpNews mpnews = new MpNews();
		mpnews.setMedia_id(groupMessage.getMediaId());
		msg.setMpnews(mpnews);
		return sendGroupMessageByOpenIDWxUtil.send(msg);
	}

	private GroupResult sendVideoByFilter(GroupMessage groupMessage) {
		com.simba.model.wx.group.filter.GroupVideo msg = new com.simba.model.wx.group.filter.GroupVideo();
		Filter filter = setFilter(groupMessage);
		msg.setFilter(filter);
		Image mpvideo = new Image();
		mpvideo.setMedia_id(groupMessage.getMediaId());
		msg.setMpvideo(mpvideo);
		return sendGroupMessageByTagWxUtil.send(msg);
	}

	private GroupResult sendVideoByOpenids(GroupMessage groupMessage) {
		com.simba.model.wx.group.openid.GroupVideo msg = new com.simba.model.wx.group.openid.GroupVideo();
		msg.setTouser(setToUsers(groupMessage));
		MpVideo mpvideo = new MpVideo();
		mpvideo.setMedia_id(groupMessage.getMediaId());
		mpvideo.setDescription(mpvideo.getDescription());
		mpvideo.setTitle(mpvideo.getTitle());
		msg.setMpvideo(mpvideo);
		return sendGroupMessageByOpenIDWxUtil.send(msg);
	}

	private GroupResult sendVoiceByFilter(GroupMessage groupMessage) {
		com.simba.model.wx.group.filter.GroupVoice msg = new com.simba.model.wx.group.filter.GroupVoice();
		Filter filter = setFilter(groupMessage);
		msg.setFilter(filter);
		Voice voice = new Voice();
		voice.setMedia_id(groupMessage.getMediaId());
		msg.setVoice(voice);
		return sendGroupMessageByTagWxUtil.send(msg);
	}

	private GroupResult sendVoiceByOpenids(GroupMessage groupMessage) {
		com.simba.model.wx.group.openid.GroupVoice msg = new com.simba.model.wx.group.openid.GroupVoice();
		msg.setTouser(setToUsers(groupMessage));
		Voice voice = new Voice();
		voice.setMedia_id(groupMessage.getMediaId());
		msg.setVoice(voice);
		return sendGroupMessageByOpenIDWxUtil.send(msg);
	}

	private GroupResult sendImageByOpenids(GroupMessage groupMessage) {
		com.simba.model.wx.group.openid.GroupImage msg = new com.simba.model.wx.group.openid.GroupImage();
		msg.setTouser(setToUsers(groupMessage));
		Image image = new Image();
		image.setMedia_id(groupMessage.getMediaId());
		msg.setImage(image);
		return sendGroupMessageByOpenIDWxUtil.send(msg);
	}

	private GroupResult sendImageByFilter(GroupMessage groupMessage) {
		GroupImage msg = new GroupImage();
		Image image = new Image();
		image.setMedia_id(groupMessage.getMediaId());
		msg.setImage(image);
		Filter filter = setFilter(groupMessage);
		msg.setFilter(filter);
		return sendGroupMessageByTagWxUtil.send(msg);
	}

	private GroupResult sendTextByFilter(GroupMessage groupMessage) {
		com.simba.model.wx.group.filter.GroupText msg = new com.simba.model.wx.group.filter.GroupText();
		Text text = new Text();
		text.setContent(groupMessage.getContent());
		msg.setText(text);
		Filter filter = setFilter(groupMessage);
		msg.setFilter(filter);
		return sendGroupMessageByTagWxUtil.send(msg);
	}

	private Filter setFilter(GroupMessage groupMessage) {
		Filter filter = new Filter();
		if (groupMessage.getIsAll() != null && groupMessage.getIsAll() == 1) {
			filter.setIs_to_all(true);
		} else {
			filter.setIs_to_all(false);
			filter.setTag_id(groupMessage.getWxTagId());
		}
		return filter;
	}

	private GroupResult sendTextByOpenids(GroupMessage groupMessage) {
		GroupText msg = new GroupText();
		Text text = new Text();
		text.setContent(groupMessage.getContent());
		msg.setText(text);
		msg.setTouser(setToUsers(groupMessage));
		return sendGroupMessageByOpenIDWxUtil.send(msg);
	}

	private List<String> setToUsers(GroupMessage groupMessage) {
		List<String> users = new ArrayList<>();
		for (String openid : groupMessage.getOpenids().split(",")) {
			if (StringUtils.isNotEmpty(openid)) {
				users.add(openid);
			}
		}
		return users;
	}

	@Override
	public void delete(Long id) {
		groupMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public GroupMessage get(Long id) {
		return groupMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> page(Pager page) {
		return groupMessageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return groupMessageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return groupMessageDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		groupMessageDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> listAll() {
		return groupMessageDao.listAll();
	}

	@Override
	public void update(GroupMessage groupMessage) {
		groupMessageDao.update(groupMessage);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public GroupMessage getBy(String field, Object value) {
		return groupMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public GroupMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return groupMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public GroupMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return groupMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> listBy(String field, Object value) {
		return groupMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return groupMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return groupMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> pageBy(String field, Object value, Pager page) {
		return groupMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return groupMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GroupMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return groupMessageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public int count(GroupMessageSearchForm searchForm) {
		return groupMessageDao.count(searchForm);
	}

	@Override
	public List<GroupMessage> page(Pager pager, GroupMessageSearchForm searchForm) {
		return groupMessageDao.page(pager, searchForm);
	}

	@Override
	public void checkStatus() {
		List<GroupMessage> list = groupMessageDao.listBy("status", SendStatus.SENDED.getId());
		list.forEach((msg) -> {
			String msgId = msg.getMsgId();
			GroupStatus status = groupMessageWxUtil.getStatus(msgId);
			if ("SEND_SUCCESS".equals(status.getMsg_status())) {
				msg.setStatus(SendStatus.SUCCESS.getId());
				groupMessageDao.update(msg);
			}
		});
	}

	@Override
	public void preview(GroupMessage groupMessage, String previewOpenid) {
		String type = groupMessage.getType();
		if (GroupMessageType.TEXT.getName().equals(type)) {
			sendPreviewText(groupMessage, previewOpenid);
		} else if (GroupMessageType.IMAGE.getName().equals(type)) {
			sendPreviewImage(groupMessage, previewOpenid);
		} else if (GroupMessageType.VOICE.getName().equals(type)) {
			sendPreviewVoice(groupMessage, previewOpenid);
		} else if (GroupMessageType.VIDEO.getName().equals(type)) {
			sendPreviewVideo(groupMessage, previewOpenid);
		} else if (GroupMessageType.NEWS.getName().equals(type)) {
			sendPreviewNews(groupMessage, previewOpenid);
		} else {
			throw new RuntimeException("类型错误");
		}
	}

	private void sendPreviewNews(GroupMessage groupMessage, String previewOpenid) {
		com.simba.model.wx.group.preview.GroupMpNews msg = new com.simba.model.wx.group.preview.GroupMpNews();
		msg.setTouser(previewOpenid);
		MpNews mpnews = new MpNews();
		mpnews.setMedia_id(groupMessage.getMediaId());
		msg.setMpnews(mpnews);
		previewGroupMessageWxUtil.send(msg);
	}

	private void sendPreviewVideo(GroupMessage groupMessage, String previewOpenid) {
		com.simba.model.wx.group.preview.GroupVideo msg = new com.simba.model.wx.group.preview.GroupVideo();
		msg.setTouser(previewOpenid);
		Image mpvideo = new Image();
		mpvideo.setMedia_id(groupMessage.getMediaId());
		msg.setMpvideo(mpvideo);
		previewGroupMessageWxUtil.send(msg);
	}

	private void sendPreviewVoice(GroupMessage groupMessage, String previewOpenid) {
		com.simba.model.wx.group.preview.GroupVoice msg = new com.simba.model.wx.group.preview.GroupVoice();
		msg.setTouser(previewOpenid);
		Voice voice = new Voice();
		voice.setMedia_id(groupMessage.getMediaId());
		msg.setVoice(voice);
		previewGroupMessageWxUtil.send(msg);
	}

	private void sendPreviewImage(GroupMessage groupMessage, String previewOpenid) {
		com.simba.model.wx.group.preview.GroupImage msg = new com.simba.model.wx.group.preview.GroupImage();
		msg.setTouser(previewOpenid);
		Image image = new Image();
		image.setMedia_id(groupMessage.getMediaId());
		msg.setImage(image);
		previewGroupMessageWxUtil.send(msg);
	}

	private void sendPreviewText(GroupMessage groupMessage, String previewOpenid) {
		com.simba.model.wx.group.preview.GroupText msg = new com.simba.model.wx.group.preview.GroupText();
		msg.setTouser(previewOpenid);
		Text text = new Text();
		text.setContent(groupMessage.getContent());
		msg.setText(text);
		previewGroupMessageWxUtil.send(msg);
	}

}
