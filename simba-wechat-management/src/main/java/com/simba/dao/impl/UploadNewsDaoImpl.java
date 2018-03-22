package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.UploadNewsDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UploadNews;
import com.simba.model.form.UploadNewsSearchForm;

/**
 * 上传图文 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class UploadNewsDaoImpl implements UploadNewsDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "uploadNews";

	@Override
	public void add(UploadNews uploadNews) {
		String sql = "insert into " + table + "( name, articles, mediaId,  createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, uploadNews.getName(), uploadNews.getArticles(), uploadNews.getMediaId(), uploadNews.getCreateTime());
	}

	@Override
	public void update(UploadNews uploadNews) {
		String sql = "update " + table + " set  name = ? , articles = ? , mediaId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, uploadNews.getName(), uploadNews.getArticles(), uploadNews.getMediaId(), uploadNews.getCreateTime(), uploadNews.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UploadNews> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, UploadNews.class, page);
	}

	@Override
	public List<UploadNews> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, UploadNews.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public UploadNews get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UploadNews.class, id);
	}

	@Override
	public UploadNews getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UploadNews.class, value);
	}

	@Override
	public UploadNews getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UploadNews.class, value1, value2);
	}

	@Override
	public UploadNews getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UploadNews.class, value1, value2);
	}

	@Override
	public List<UploadNews> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadNews.class, value);
	}

	@Override
	public List<UploadNews> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadNews.class, value1, value2);
	}

	@Override
	public List<UploadNews> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadNews.class, value1, value2);
	}

	@Override
	public List<UploadNews> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UploadNews.class, page, param);
	}

	@Override
	public List<UploadNews> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadNews.class, page, param);
	}

	@Override
	public List<UploadNews> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadNews.class, page, param);
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
	public List<UploadNews> page(Pager pager, UploadNewsSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, UploadNews.class, pager, param);
	}

	@Override
	public int count(UploadNewsSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, UploadNewsSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getName())) {
			sql += " and name like '%" + searchForm.getName() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getMediaId())) {
			sql += " and mediaId = ? ";
			param.setString(searchForm.getMediaId());
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
