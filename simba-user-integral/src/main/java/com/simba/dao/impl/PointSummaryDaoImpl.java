package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.PointSummaryDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.PointSummary;

/**
 * null Dao实现类
 * 
 * @author lilei
 *  
 */
@Repository
public class PointSummaryDaoImpl implements PointSummaryDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "pointSummary";

	@Override
	public void add(PointSummary pointSummary) {
		String sql = "insert into " + table + "( userID, point, createTime, updateTime) values(?,?,?,?)";
		jdbc.updateForBoolean(sql, pointSummary.getUserID(),pointSummary.getPoint(),pointSummary.getCreateTime(),pointSummary.getUpdateTime());
	}

	@Override
	public void update(PointSummary pointSummary) {
		String sql = "update " + table + " set  userID = ? , point = ? , createTime = ? , updateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,pointSummary.getUserID(),pointSummary.getPoint(),pointSummary.getCreateTime(),pointSummary.getUpdateTime(), pointSummary.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<PointSummary> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, PointSummary.class, page);
	}

	@Override
	public List<PointSummary> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, PointSummary.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public PointSummary get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, PointSummary.class, id);
	}
	
	@Override
	public PointSummary getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, PointSummary.class, value);
	}

	@Override
	public PointSummary getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, PointSummary.class, value1, value2);
	}

	@Override
	public PointSummary getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, PointSummary.class, value1, value2);
	}

	@Override
	public List<PointSummary> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, PointSummary.class, value);
	}

	@Override
	public List<PointSummary> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, PointSummary.class, value1, value2);
	}

	@Override
	public List<PointSummary> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, PointSummary.class, value1, value2);
	}

	@Override
	public List<PointSummary> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, PointSummary.class, page, param);
	}

	@Override
	public List<PointSummary> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PointSummary.class, page, param);
	}

	@Override
	public List<PointSummary> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PointSummary.class, page, param);
	}
	
	@Override
	public Long countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForLong(sql, value);
	}
	
	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}


	@Override
	public Long countByOr(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}
	
	@Override
	public Long countByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForLong(sql, value1, value2);
	}
	
	@Override
	public void deleteByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
	
	@Override
	public void deleteByOr(String field1, Object value1, String field2, Object value2){
		String sql = "delete from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		jdbc.updateForBoolean(sql, value1, value2);
	}
}
