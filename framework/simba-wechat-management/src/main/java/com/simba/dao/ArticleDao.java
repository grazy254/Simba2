package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Article;
import com.simba.model.form.ArticleSearchForm;

/**
 * 图文内容 Dao
 * 
 * @author caozj
 * 
 */
public interface ArticleDao {

	void add(Article article);

	void update(Article article);

	void delete(Long id);

	List<Article> listAll();

	int count();

	int countBy(String field, Object value);

	void deleteBy(String field, Object value);

	List<Article> page(Pager page);

	Article get(Long id);

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

}
