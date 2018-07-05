package com.simba.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.ArticleDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Article;
import com.simba.model.ForeverMedia;
import com.simba.model.TempMedia;
import com.simba.model.enums.ArticleType;
import com.simba.model.enums.ForeverMediaType;
import com.simba.model.enums.MediaType;
import com.simba.model.form.ArticleSearchForm;
import com.simba.service.ArticleService;
import com.simba.service.ForeverMediaService;
import com.simba.service.TempMediaService;

/**
 * 图文内容 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private ForeverMediaService foreverMediaService;

	@Autowired
	private TempMediaService tempMediaService;

	@Override
	public void add(Article article) {
		article.setCreateTime(new Date());
		articleDao.add(article);
	}

	@Override
	public void delete(Long id) {
		articleDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Article get(Long id) {
		return articleDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> page(Pager page) {
		return articleDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return articleDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return articleDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		articleDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> listAll() {
		return articleDao.listAll();
	}

	@Override
	public void update(Article article) {
		article.setCreateTime(new Date());
		articleDao.update(article);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Article getBy(String field, Object value) {
		return articleDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Article getByAnd(String field1, Object value1, String field2, Object value2) {
		return articleDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Article getByOr(String field1, Object value1, String field2, Object value2) {
		return articleDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> listBy(String field, Object value) {
		return articleDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> listByAnd(String field1, Object value1, String field2, Object value2) {
		return articleDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> listByOr(String field1, Object value1, String field2, Object value2) {
		return articleDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> pageBy(String field, Object value, Pager page) {
		return articleDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return articleDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Article> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return articleDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<Article> page(Pager pager, ArticleSearchForm searchForm) {
		return articleDao.page(pager, searchForm);
	}

	@Override
	public int count(ArticleSearchForm searchForm) {
		return articleDao.count(searchForm);
	}

	@Override
	public void add(Article article, MultipartFile file) throws IOException, FastdfsException {
		dealMedia(article, file);
		this.add(article);
	}

	@Override
	public void update(Article article, MultipartFile file) throws IOException, FastdfsException {
		dealMedia(article, file);
		this.update(article);
	}

	private void dealMedia(Article article, MultipartFile file) throws IOException, FastdfsException {
		if (file == null || file.getSize() == 0) {
			return;
		}
		int type = article.getType();
		if (type == ArticleType.TEMP.getId()) {
			TempMedia media = new TempMedia();
			media.setName(StringUtils.EMPTY);
			media.setType(ForeverMediaType.IMAGE.getName());
			tempMediaService.add(media, file);
			article.setThumbMediaId(media.getMediaId());
		} else if (type == ArticleType.FOREVER.getId()) {
			ForeverMedia media = new ForeverMedia();
			media.setName(StringUtils.EMPTY);
			media.setArticles(StringUtils.EMPTY);
			media.setIntroduction(StringUtils.EMPTY);
			media.setTitle(StringUtils.EMPTY);
			media.setType(MediaType.IMAGE.getName());
			foreverMediaService.add(media, file);
			article.setThumbMediaId(media.getMediaId());
		}
	}

}
