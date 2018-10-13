package com.simba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ArticleDao;
import com.simba.dao.UploadNewsDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Article;
import com.simba.model.UploadNews;
import com.simba.model.form.UploadNewsSearchForm;
import com.simba.model.wx.upload.NewsArticle;
import com.simba.model.wx.upload.NewsArticles;
import com.simba.model.wx.upload.UploadResult;
import com.simba.service.UploadNewsService;
import com.simba.util.send.UploadWxUtil;

/**
 * 上传图文 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UploadNewsServiceImpl implements UploadNewsService {

	@Autowired
	private UploadNewsDao uploadNewsDao;

	@Autowired
	private UploadWxUtil uploadWxUtil;

	@Autowired
	private ArticleDao articleDao;

	@Override
	public void add(UploadNews uploadNews) {
		uploadNews.setCreateTime(new Date());
		String mediaId = uploadNewsTowx(uploadNews);
		uploadNews.setMediaId(mediaId);
		uploadNewsDao.add(uploadNews);
	}

	private String uploadNewsTowx(UploadNews uploadNews) {
		String articles = uploadNews.getArticles();
		String[] ids = articles.split(",");
		List<NewsArticle> articleList = new ArrayList<>(ids.length);
		for (String articleId : ids) {
			if (StringUtils.isEmpty(articleId)) {
				continue;
			}
			Article article = articleDao.get(NumberUtils.toLong(articleId));
			NewsArticle na = new NewsArticle();
			na.setAuthor(article.getAuthor());
			na.setContent(article.getContent());
			na.setContent_source_url(article.getContentSourceUrl());
			na.setDigest(article.getDigest());
			na.setShow_cover_pic(article.getShowCoverPic());
			na.setThumb_media_id(article.getThumbMediaId());
			na.setTitle(article.getTitle());
			articleList.add(na);
		}
		NewsArticles newsArticles = new NewsArticles();
		newsArticles.setArticles(articleList);
		UploadResult result = uploadWxUtil.uploadNewsArticles(newsArticles);
		return result.getMedia_id();
	}

	@Override
	public void delete(Long id) {
		uploadNewsDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadNews get(Long id) {
		return uploadNewsDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> page(Pager page) {
		return uploadNewsDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return uploadNewsDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return uploadNewsDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		uploadNewsDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> listAll() {
		return uploadNewsDao.listAll();
	}

	@Override
	public void update(UploadNews uploadNews) {
		uploadNewsDao.update(uploadNews);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UploadNews getBy(String field, Object value) {
		return uploadNewsDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadNews getByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadNewsDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadNews getByOr(String field1, Object value1, String field2, Object value2) {
		return uploadNewsDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> listBy(String field, Object value) {
		return uploadNewsDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> listByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadNewsDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> listByOr(String field1, Object value1, String field2, Object value2) {
		return uploadNewsDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> pageBy(String field, Object value, Pager page) {
		return uploadNewsDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadNewsDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadNews> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadNewsDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<UploadNews> page(Pager pager, UploadNewsSearchForm searchForm) {
		return uploadNewsDao.page(pager, searchForm);
	}

	@Override
	public int count(UploadNewsSearchForm searchForm) {
		return uploadNewsDao.count(searchForm);
	}

}
