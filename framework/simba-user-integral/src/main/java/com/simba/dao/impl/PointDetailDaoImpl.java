package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.PointDetailDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.PointDetail;

/**
 * null Dao实现类
 * 
 * @author lilei
 *  
 */
@Repository
public class PointDetailDaoImpl implements PointDetailDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "pointDetail";

	@Override
	public void add(PointDetail pointDetail) {
		String sql = "insert into " + table + "( userID, activityID, point, createTime, expireTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, pointDetail.getUserID(),pointDetail.getActivityID(),pointDetail.getPoint(),pointDetail.getCreateTime(),pointDetail.getExpireTime());
	}

	@Override
	public void update(PointDetail pointDetail) {
		String sql = "update " + table + " set  userID = ? , activityID = ? , point = ? , createTime = ? , expireTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,pointDetail.getUserID(),pointDetail.getActivityID(),pointDetail.getPoint(),pointDetail.getCreateTime(),pointDetail.getExpireTime(), pointDetail.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<PointDetail> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, PointDetail.class, page);
	}

	@Override
	public List<PointDetail> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, PointDetail.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public PointDetail get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, PointDetail.class, id);
	}
	
	@Override
	public PointDetail getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, PointDetail.class, value);
	}

	@Override
	public PointDetail getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, PointDetail.class, value1, value2);
	}

	@Override
	public PointDetail getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, PointDetail.class, value1, value2);
	}

	@Override
	public List<PointDetail> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, PointDetail.class, value);
	}

	@Override
	public List<PointDetail> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, PointDetail.class, value1, value2);
	}

	@Override
	public List<PointDetail> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, PointDetail.class, value1, value2);
	}

	@Override
	public List<PointDetail> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, PointDetail.class, page, param);
	}

	@Override
	public List<PointDetail> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PointDetail.class, page, param);
	}

	@Override
	public List<PointDetail> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, PointDetail.class, page, param);
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
