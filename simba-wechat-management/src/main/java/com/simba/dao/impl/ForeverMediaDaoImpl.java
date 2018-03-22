package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ForeverMediaDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ForeverMedia;
import com.simba.model.form.ForeverMediaSearchForm;

/**
 * 永久素材 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class ForeverMediaDaoImpl implements ForeverMediaDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "foreverMedia";

	@Override
	public void add(ForeverMedia foreverMedia) {
		String sql = "insert into " + table + "( mediaId, articles, type, fileUrl, title, introduction, imageUrl, createTime,name) values(?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, foreverMedia.getMediaId(), foreverMedia.getArticles(), foreverMedia.getType(), foreverMedia.getFileUrl(), foreverMedia.getTitle(), foreverMedia.getIntroduction(),
				foreverMedia.getImageUrl(), foreverMedia.getCreateTime(), foreverMedia.getName());
	}

	@Override
	public void update(ForeverMedia foreverMedia) {
		String sql = "update " + table + " set  mediaId = ? , articles = ? , type = ? , fileUrl = ? , title = ? , introduction = ? , imageUrl = ? , createTime = ? , name = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, foreverMedia.getMediaId(), foreverMedia.getArticles(), foreverMedia.getType(), foreverMedia.getFileUrl(), foreverMedia.getTitle(), foreverMedia.getIntroduction(),
				foreverMedia.getImageUrl(), foreverMedia.getCreateTime(), foreverMedia.getName(), foreverMedia.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ForeverMedia> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, ForeverMedia.class, page);
	}

	@Override
	public List<ForeverMedia> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, ForeverMedia.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public ForeverMedia get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ForeverMedia.class, id);
	}

	@Override
	public ForeverMedia getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ForeverMedia.class, value);
	}

	@Override
	public ForeverMedia getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ForeverMedia.class, value1, value2);
	}

	@Override
	public ForeverMedia getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ForeverMedia.class, value1, value2);
	}

	@Override
	public List<ForeverMedia> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ForeverMedia.class, value);
	}

	@Override
	public List<ForeverMedia> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ForeverMedia.class, value1, value2);
	}

	@Override
	public List<ForeverMedia> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, ForeverMedia.class, value1, value2);
	}

	@Override
	public List<ForeverMedia> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ForeverMedia.class, page, param);
	}

	@Override
	public List<ForeverMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ForeverMedia.class, page, param);
	}

	@Override
	public List<ForeverMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ForeverMedia.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public List<ForeverMedia> page(Pager pager, ForeverMediaSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, ForeverMedia.class, pager, param);
	}

	private String buildCondition(String sql, ForeverMediaSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getName())) {
			sql += " and name like '%" + searchForm.getName() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and type = ? ";
			param.setString(searchForm.getType());
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

	@Override
	public int count(ForeverMediaSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

}
