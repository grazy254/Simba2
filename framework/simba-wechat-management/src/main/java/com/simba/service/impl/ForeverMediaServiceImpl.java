package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.ArticleDao;
import com.simba.dao.ForeverMediaDao;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.Article;
import com.simba.model.ForeverMedia;
import com.simba.model.form.ForeverMediaSearchForm;
import com.simba.model.wx.media.UploadMediaResult;
import com.simba.model.wx.media.UploadResult;
import com.simba.model.wx.upload.NewsArticle;
import com.simba.model.wx.upload.NewsArticles;
import com.simba.service.ForeverMediaService;
import com.simba.util.send.MediaWxUtil;

/**
 * 永久素材 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ForeverMediaServiceImpl implements ForeverMediaService {

	@Autowired
	private ForeverMediaDao foreverMediaDao;

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private MediaWxUtil mediaWxUtil;

	@Override
	public void add(ForeverMedia foreverMedia) {
		foreverMediaDao.add(foreverMedia);
	}

	@Override
	public void delete(Long id) throws IOException, FastdfsException {
		ForeverMedia media = this.get(id);
		String mediaId = media.getMediaId();
		mediaWxUtil.deleteMedia(mediaId);
		String fileUrl = media.getFileUrl();
		if (StringUtils.isNotEmpty(fileUrl)) {
			UploadUtil.getInstance().getUpload().delete(fileUrl);
		}
		foreverMediaDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ForeverMedia get(Long id) {
		return foreverMediaDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> page(Pager page) {
		return foreverMediaDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return foreverMediaDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return foreverMediaDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> listAll() {
		return foreverMediaDao.listAll();
	}

	@Override
	public void update(ForeverMedia foreverMedia) {
		foreverMediaDao.update(foreverMedia);
	}

	@Override
	public void batchDelete(List<Long> idList) throws IOException, FastdfsException {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ForeverMedia getBy(String field, Object value) {
		return foreverMediaDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ForeverMedia getByAnd(String field1, Object value1, String field2, Object value2) {
		return foreverMediaDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ForeverMedia getByOr(String field1, Object value1, String field2, Object value2) {
		return foreverMediaDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> listBy(String field, Object value) {
		return foreverMediaDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> listByAnd(String field1, Object value1, String field2, Object value2) {
		return foreverMediaDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> listByOr(String field1, Object value1, String field2, Object value2) {
		return foreverMediaDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> pageBy(String field, Object value, Pager page) {
		return foreverMediaDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return foreverMediaDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ForeverMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return foreverMediaDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<ForeverMedia> page(Pager pager, ForeverMediaSearchForm searchForm) {
		return foreverMediaDao.page(pager, searchForm);
	}

	@Override
	public int count(ForeverMediaSearchForm searchForm) {
		return foreverMediaDao.count(searchForm);
	}

	@Override
	public void add(ForeverMedia foreverMedia, MultipartFile file) throws IOException, FastdfsException {
		foreverMedia.setCreateTime(new Date());
		String type = foreverMedia.getType();
		if (type.equals("news")) {
			dealNewsMedia(foreverMedia);
		} else if (type.equals("video")) {
			dealVideoMedia(foreverMedia, file);
		} else {
			dealOtherMedia(foreverMedia, file, type);
		}
		this.add(foreverMedia);
	}

	private void dealNewsMedia(ForeverMedia foreverMedia) {
		String articles = foreverMedia.getArticles();
		NewsArticles newsArticles = new NewsArticles();
		List<NewsArticle> list = new ArrayList<>();
		for (String articleId : articles.split(",")) {
			if (StringUtils.isEmpty(articleId)) {
				continue;
			}
			Article article = articleDao.get(NumberUtils.toLong(articleId));
			NewsArticle newsArticle = buildNewsArticle(article);
			list.add(newsArticle);
		}
		newsArticles.setArticles(list);
		UploadResult result = mediaWxUtil.addNewsMedia(newsArticles);
		foreverMedia.setMediaId(result.getMedia_id());
	}

	private NewsArticle buildNewsArticle(Article article) {
		NewsArticle newsArticle = new NewsArticle();
		newsArticle.setAuthor(article.getAuthor());
		newsArticle.setContent(article.getContent());
		newsArticle.setContent_source_url(article.getContentSourceUrl());
		newsArticle.setDigest(article.getDigest());
		newsArticle.setShow_cover_pic(article.getShowCoverPic());
		newsArticle.setThumb_media_id(article.getThumbMediaId());
		newsArticle.setTitle(article.getTitle());
		return newsArticle;
	}

	private void dealOtherMedia(ForeverMedia foreverMedia, MultipartFile file, String type) throws IOException, FastdfsException {
		String url = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "wxforevermedia");
		foreverMedia.setFileUrl(url);
		String tempFile = SystemUtil.getTempDir() + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
		file.transferTo(new File(tempFile));
		UploadMediaResult result = mediaWxUtil.addOtherMedia(tempFile, type);
		foreverMedia.setMediaId(result.getMedia_id());
		foreverMedia.setImageUrl(result.getUrl());
	}

	private void dealVideoMedia(ForeverMedia foreverMedia, MultipartFile file) throws IOException, FastdfsException {
		String url = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "wxforevermedia");
		foreverMedia.setFileUrl(url);
		String tempFile = SystemUtil.getTempDir() + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
		file.transferTo(new File(tempFile));
		UploadMediaResult result = mediaWxUtil.addVideoMedia(tempFile, foreverMedia.getTitle(), foreverMedia.getIntroduction());
		foreverMedia.setMediaId(result.getMedia_id());
	}

}
