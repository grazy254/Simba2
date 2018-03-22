package com.simba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.SendMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.SendMessage;
import com.simba.model.enums.SendMessageType;
import com.simba.model.form.SendMessageSearchForm;
import com.simba.model.wx.msg.Article;
import com.simba.model.wx.msg.Image;
import com.simba.model.wx.msg.ImageMsg;
import com.simba.model.wx.msg.MpNews;
import com.simba.model.wx.msg.MpNewsMsg;
import com.simba.model.wx.msg.Music;
import com.simba.model.wx.msg.MusicMsg;
import com.simba.model.wx.msg.News;
import com.simba.model.wx.msg.NewsMsg;
import com.simba.model.wx.msg.Text;
import com.simba.model.wx.msg.TextMsg;
import com.simba.model.wx.msg.Video;
import com.simba.model.wx.msg.VideoMsg;
import com.simba.model.wx.msg.Voice;
import com.simba.model.wx.msg.VoiceMsg;
import com.simba.service.SendMessageService;
import com.simba.util.send.SendMessageWxUtil;

/**
 * 发消息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class SendMessageServiceImpl implements SendMessageService {

	@Autowired
	private SendMessageDao sendMessageDao;

	@Autowired
	private SendMessageWxUtil sendMessageWxUtil;

	@Override
	public void add(SendMessage sendMessage) {
		sendMessage.setCreateTime(new Date());
		sendToWx(sendMessage);
		sendMessageDao.add(sendMessage);
	}

	private void sendToWx(SendMessage sendMessage) {
		String type = sendMessage.getType();
		if (type.equals(SendMessageType.TEXT.getName())) {
			sendTextMessage(sendMessage);
		} else if (type.equals(SendMessageType.IMAGE.getName())) {
			sendImageMessage(sendMessage);
		} else if (type.equals(SendMessageType.VOICE.getName())) {
			sendVoiceMessage(sendMessage);
		} else if (type.equals(SendMessageType.VIDEO.getName())) {
			sendVideoMessage(sendMessage);
		} else if (type.equals(SendMessageType.MUSIC.getName())) {
			sendMusicMessage(sendMessage);
		} else if (type.equals(SendMessageType.NEWS.getName())) {
			sendNewsMessage(sendMessage);
		} else if (type.equals(SendMessageType.MPNEWS.getName())) {
			sendMpNewsMessage(sendMessage);
		} else {
			throw new RuntimeException("类型错误");
		}
	}

	private void sendMpNewsMessage(SendMessage sendMessage) {
		MpNewsMsg msg = new MpNewsMsg();
		msg.setTouser(sendMessage.getOpenid());
		MpNews mpnews = new MpNews();
		mpnews.setMedia_id(sendMessage.getMediaId());
		msg.setMpnews(mpnews);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendNewsMessage(SendMessage sendMessage) {
		NewsMsg msg = new NewsMsg();
		msg.setTouser(sendMessage.getOpenid());
		News news = new News();
		List<Article> articles = new ArrayList<>();
		String newsContent = sendMessage.getNews();
		String[] cs = newsContent.split("@~@");
		for (String content : cs) {
			if (StringUtils.isEmpty(content)) {
				continue;
			}
			String[] a = content.split("&~&");
			Article article = new Article();
			article.setTitle(a[0]);
			article.setDescription(a[1]);
			article.setUrl(a[2]);
			article.setPicurl(a[3]);
			articles.add(article);
		}
		news.setArticles(articles);
		msg.setNews(news);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendMusicMessage(SendMessage sendMessage) {
		MusicMsg msg = new MusicMsg();
		msg.setTouser(sendMessage.getOpenid());
		Music music = new Music();
		music.setDescription(sendMessage.getDescritption());
		music.setHqmusicurl(sendMessage.getHqMusicUrl());
		music.setMusicurl(sendMessage.getMusicUrl());
		music.setThumb_media_id(sendMessage.getThumbMediaId());
		music.setTitle(sendMessage.getTitle());
		msg.setMusic(music);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendVideoMessage(SendMessage sendMessage) {
		VideoMsg msg = new VideoMsg();
		msg.setTouser(sendMessage.getOpenid());
		Video video = new Video();
		video.setDescription(sendMessage.getDescritption());
		video.setTitle(sendMessage.getTitle());
		video.setMedia_id(sendMessage.getMediaId());
		video.setThumb_media_id(sendMessage.getThumbMediaId());
		msg.setVideo(video);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendVoiceMessage(SendMessage sendMessage) {
		VoiceMsg msg = new VoiceMsg();
		msg.setTouser(sendMessage.getOpenid());
		Voice voice = new Voice();
		voice.setMedia_id(sendMessage.getMediaId());
		msg.setVoice(voice);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendImageMessage(SendMessage sendMessage) {
		ImageMsg msg = new ImageMsg();
		msg.setTouser(sendMessage.getOpenid());
		Image image = new Image();
		image.setMedia_id(sendMessage.getMediaId());
		msg.setImage(image);
		sendMessage.setJson(sendMessageWxUtil.send(msg));
	}

	private void sendTextMessage(SendMessage sendMessage) {
		TextMsg textMsg = new TextMsg();
		Text text = new Text();
		text.setContent(sendMessage.getContent());
		textMsg.setText(text);
		textMsg.setTouser(sendMessage.getOpenid());
		sendMessage.setJson(sendMessageWxUtil.send(textMsg));
	}

	@Override
	public void delete(Long id) {
		sendMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SendMessage get(Long id) {
		return sendMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> page(Pager page) {
		return sendMessageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return sendMessageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return sendMessageDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		sendMessageDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> listAll() {
		return sendMessageDao.listAll();
	}

	@Override
	public void update(SendMessage sendMessage) {
		sendMessageDao.update(sendMessage);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public SendMessage getBy(String field, Object value) {
		return sendMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public SendMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return sendMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public SendMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return sendMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> listBy(String field, Object value) {
		return sendMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return sendMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return sendMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> pageBy(String field, Object value, Pager page) {
		return sendMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return sendMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SendMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return sendMessageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public int count(SendMessageSearchForm searchForm) {
		return sendMessageDao.count(searchForm);
	}

	@Override
	public List<SendMessage> page(Pager pager, SendMessageSearchForm searchForm) {
		return sendMessageDao.page(pager, searchForm);
	}

}
