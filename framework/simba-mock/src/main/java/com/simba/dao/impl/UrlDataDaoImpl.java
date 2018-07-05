package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.UrlDataDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UrlData;

/**
 * Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class UrlDataDaoImpl implements UrlDataDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "urlData";

	@Override
	public void add(UrlData urlData) {
		String sql = "insert into " + table + "( projectId, url, data,description) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, urlData.getProjectId(), urlData.getUrl(), urlData.getData(), urlData.getDescription());
	}

	@Override
	public void update(UrlData urlData) {
		String sql = "update " + table + " set  projectId = ? , url = ? , data = ? ,description = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, urlData.getProjectId(), urlData.getUrl(), urlData.getData(), urlData.getDescription(), urlData.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UrlData> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, UrlData.class, page);
	}

	@Override
	public List<UrlData> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, UrlData.class);
	}

	@Override
	public int count(Integer projectId) {
		return countBy("projectId", projectId);
	}

	@Override
	public UrlData get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UrlData.class, id);
	}

	@Override
	public UrlData getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UrlData.class, value);
	}

	@Override
	public UrlData getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UrlData.class, value1, value2);
	}

	@Override
	public UrlData getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UrlData.class, value1, value2);
	}

	@Override
	public List<UrlData> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, UrlData.class, value);
	}

	@Override
	public List<UrlData> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, UrlData.class, value1, value2);
	}

	@Override
	public List<UrlData> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, UrlData.class, value1, value2);
	}

	@Override
	public List<UrlData> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UrlData.class, page, param);
	}

	@Override
	public List<UrlData> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UrlData.class, page, param);
	}

	@Override
	public List<UrlData> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UrlData.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteByProjectId(int projectId) {
		String sql = "delete from " + table + " where projectId = ? ";
		jdbc.updateForBoolean(sql, projectId);
	}

}
