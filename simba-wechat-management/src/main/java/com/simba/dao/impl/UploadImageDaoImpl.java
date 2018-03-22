package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.UploadImageDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UploadImage;
import com.simba.model.form.UploadImageSearchForm;

/**
 * 上传图片 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class UploadImageDaoImpl implements UploadImageDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "uploadImage";

	@Override
	public void add(UploadImage uploadImage) {
		String sql = "insert into " + table + "( name, sourceUrl, wxUrl, createTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, uploadImage.getName(), uploadImage.getSourceUrl(), uploadImage.getWxUrl(), uploadImage.getCreateTime());
	}

	@Override
	public void update(UploadImage uploadImage) {
		String sql = "update " + table + " set  name = ? , sourceUrl = ? , wxUrl = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, uploadImage.getName(), uploadImage.getSourceUrl(), uploadImage.getWxUrl(), uploadImage.getCreateTime(), uploadImage.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UploadImage> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, UploadImage.class, page);
	}

	@Override
	public List<UploadImage> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, UploadImage.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public UploadImage get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UploadImage.class, id);
	}

	@Override
	public UploadImage getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UploadImage.class, value);
	}

	@Override
	public UploadImage getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UploadImage.class, value1, value2);
	}

	@Override
	public UploadImage getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UploadImage.class, value1, value2);
	}

	@Override
	public List<UploadImage> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadImage.class, value);
	}

	@Override
	public List<UploadImage> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadImage.class, value1, value2);
	}

	@Override
	public List<UploadImage> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, UploadImage.class, value1, value2);
	}

	@Override
	public List<UploadImage> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UploadImage.class, page, param);
	}

	@Override
	public List<UploadImage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadImage.class, page, param);
	}

	@Override
	public List<UploadImage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadImage.class, page, param);
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
	public List<UploadImage> page(Pager pager, UploadImageSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, UploadImage.class, pager, param);
	}

	private String buildCondition(String sql, UploadImageSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
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
	public int count(UploadImageSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

}
