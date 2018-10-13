package com.simba.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TempMediaDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.TempMedia;
import com.simba.model.form.TempMediaSearchForm;

/**
 * 临时素材 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class TempMediaDaoImpl implements TempMediaDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tempMedia";

	@Override
	public void add(TempMedia tempMedia) {
		String sql = "insert into " + table + "( name, type, fileUrl, mediaId, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, tempMedia.getName(), tempMedia.getType(), tempMedia.getFileUrl(), tempMedia.getMediaId(), tempMedia.getCreateTime());
	}

	@Override
	public void update(TempMedia tempMedia) {
		String sql = "update " + table + " set  name = ? , type = ? , fileUrl = ? , mediaId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, tempMedia.getName(), tempMedia.getType(), tempMedia.getFileUrl(), tempMedia.getMediaId(), tempMedia.getCreateTime(), tempMedia.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TempMedia> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, TempMedia.class, page);
	}

	@Override
	public List<TempMedia> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, TempMedia.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public TempMedia get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TempMedia.class, id);
	}

	@Override
	public TempMedia getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TempMedia.class, value);
	}

	@Override
	public TempMedia getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TempMedia.class, value1, value2);
	}

	@Override
	public TempMedia getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TempMedia.class, value1, value2);
	}

	@Override
	public List<TempMedia> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, TempMedia.class, value);
	}

	@Override
	public List<TempMedia> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, TempMedia.class, value1, value2);
	}

	@Override
	public List<TempMedia> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ?order by createTime desc ";
		return jdbc.queryForList(sql, TempMedia.class, value1, value2);
	}

	@Override
	public List<TempMedia> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TempMedia.class, page, param);
	}

	@Override
	public List<TempMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TempMedia.class, page, param);
	}

	@Override
	public List<TempMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TempMedia.class, page, param);
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
	public int count(TempMediaSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, TempMediaSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getType())) {
			sql += " and type = ? ";
			param.setString(searchForm.getType());
		}
		if (StringUtils.isNotEmpty(searchForm.getMediaId())) {
			sql += " and mediaId = ? ";
			param.setString(searchForm.getMediaId());
		}
		if (StringUtils.isNotEmpty(searchForm.getName())) {
			sql += " and name like '%" + searchForm.getName() + "%'";
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
	public List<TempMedia> page(Pager pager, TempMediaSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, TempMedia.class, pager, param);
	}

	@Override
	public List<TempMedia> listBefore(Date date) {
		String sql = "select * from " + table + " where createTime < ? ";
		return jdbc.queryForList(sql, TempMedia.class, date);
	}

	@Override
	public void deleteBefore(Date date) {
		String sql = "delete from " + table + " where createTime < ? ";
		jdbc.updateForBoolean(sql, date);
	}

}
