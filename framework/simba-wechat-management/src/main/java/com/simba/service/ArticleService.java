package com.simba.service;

import java.io.IOException;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.web.multipart.MultipartFile;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Article;
import com.simba.model.form.ArticleSearchForm;

/**
 * 图文内容 Service
 * 
 * @author caozj
 * 
 */
public interface ArticleService {

	void add(Article article);

	void update(Article article);

	void delete(Long id);

	List<Article> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<Article> page(Pager page);

	Article get(Long id);

	void batchDelete(List<Long> idList);

	Article getBy(String field, Object value);

	Article getByAnd(String field1, Object value1, String field2, Object value2);

	Article getByOr(String field1, Object value1, String field2, Object value2);

	List<Article> listBy(String field, Object value);

	List<Article> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Article> listByOr(String field1, Object value1, String field2, Object value2);

	List<Article> pageBy(String field, Object value, Pager page);

	List<Article> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Article> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<Article> page(Pager pager, ArticleSearchForm searchForm);

	int count(ArticleSearchForm searchForm);

	void add(Article article, MultipartFile file) throws IOException, FastdfsException;

	void update(Article article, MultipartFile file) throws IOException, FastdfsException;

}
