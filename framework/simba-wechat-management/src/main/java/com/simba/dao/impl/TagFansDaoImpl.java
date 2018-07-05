package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.TagFansDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.TagFans;

/**
 * Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class TagFansDaoImpl implements TagFansDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "tagFans";

	@Override
	public void add(TagFans tagFans) {
		String sql = "insert into " + table + "( tagId, fansId) values(?,?)";
		jdbc.updateForBoolean(sql, tagFans.getTagId(), tagFans.getFansId());
	}

	@Override
	public void update(TagFans tagFans) {
		String sql = "update " + table + " set  tagId = ? , fansId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, tagFans.getTagId(), tagFans.getFansId(), tagFans.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<TagFans> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, TagFans.class, page);
	}

	@Override
	public List<TagFans> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, TagFans.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public TagFans get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, TagFans.class, id);
	}

	@Override
	public TagFans getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, TagFans.class, value);
	}

	@Override
	public TagFans getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, TagFans.class, value1, value2);
	}

	@Override
	public TagFans getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, TagFans.class, value1, value2);
	}

	@Override
	public List<TagFans> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, TagFans.class, value);
	}

	@Override
	public List<TagFans> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, TagFans.class, value1, value2);
	}

	@Override
	public List<TagFans> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, TagFans.class, value1, value2);
	}

	@Override
	public List<TagFans> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, TagFans.class, page, param);
	}

	@Override
	public List<TagFans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TagFans.class, page, param);
	}

	@Override
	public List<TagFans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, TagFans.class, page, param);
	}

	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

	@Override
	public void deleteByFansId(int fansId) {
		String sql = "delete from " + table + " where fansId = ? ";
		jdbc.updateForBoolean(sql, fansId);
	}

	@Override
	public void deleteByTagId(Integer tagId) {
		String sql = "delete from " + table + " where tagId = ? ";
		jdbc.updateForBoolean(sql, tagId);
	}

}
