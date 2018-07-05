package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ArticleDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Article;
import com.simba.model.form.ArticleSearchForm;

/**
 * 图文内容 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "article";

	@Override
	public void add(Article article) {
		String sql = "insert into " + table + "( title, thumbMediaId, author, digest, showCoverPic, content, contentSourceUrl, createTime,type) values(?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, article.getTitle(), article.getThumbMediaId(), article.getAuthor(), article.getDigest(), article.getShowCoverPic(), article.getContent(),
				article.getContentSourceUrl(), article.getCreateTime(), article.getType());
	}

	@Override
	public void update(Article article) {
		String sql = "update " + table
				+ " set  title = ? , thumbMediaId = ? , author = ? , digest = ? , showCoverPic = ? , content = ? , contentSourceUrl = ? , createTime = ? , type = ? where id = ?  ";
		jdbc.updateForBoolean(sql, article.getTitle(), article.getThumbMediaId(), article.getAuthor(), article.getDigest(), article.getShowCoverPic(), article.getContent(),
				article.getContentSourceUrl(), article.getCreateTime(), article.getType(), article.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Article> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Article.class, page);
	}

	@Override
	public List<Article> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Article.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public Article get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Article.class, id);
	}

	@Override
	public Article getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Article.class, value);
	}

	@Override
	public Article getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Article.class, value1, value2);
	}

	@Override
	public Article getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Article.class, value1, value2);
	}

	@Override
	public List<Article> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Article.class, value);
	}

	@Override
	public List<Article> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Article.class, value1, value2);
	}

	@Override
	public List<Article> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Article.class, value1, value2);
	}

	@Override
	public List<Article> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Article.class, page, param);
	}

	@Override
	public List<Article> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Article.class, page, param);
	}

	@Override
	public List<Article> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Article.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

	@Override
	public List<Article> page(Pager pager, ArticleSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, Article.class, pager, param);
	}

	@Override
	public int count(ArticleSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, ArticleSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getType() != null && searchForm.getType() > 0) {
			sql += " and type = ? ";
			param.setInt(searchForm.getType());
		}
		if (StringUtils.isNotEmpty(searchForm.getTitle())) {
			sql += " and title like '%" + searchForm.getTitle() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getAuthor())) {
			sql += " and author like '%" + searchForm.getAuthor() + "%'";
		}
		if (StringUtils.isNotEmpty(searchForm.getStartTime())) {
			sql += " and createTime > ? ";
			param.setString(searchForm.getStartTime());
		}
		if (StringUtils.isNotEmpty(searchForm.getEndTime())) {
			sql += " and createTime < ? ";
			param.setString(searchForm.getEndTime());
		}
		return sql;
	}

}
