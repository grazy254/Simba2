package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ActivityDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.Activity;

/**
 * 活动 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ActivityDaoImpl implements ActivityDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "activity";

	@Override
	public void add(Activity activity) {
		String sql = "insert into " + table + "( activityID, name, description, ownerID, point, startTime, endTime, createTime, updateTime) values(?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, activity.getActivityID(),activity.getName(),activity.getDescription(),activity.getOwnerID(),activity.getPoint(),activity.getStartTime(),activity.getEndTime(),activity.getCreateTime(),activity.getUpdateTime());
	}

	@Override
	public void update(Activity activity) {
		String sql = "update " + table + " set  activityID = ? , name = ? , description = ? , ownerID = ? , point = ? , startTime = ? , endTime = ? , createTime = ? , updateTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,activity.getActivityID(),activity.getName(),activity.getDescription(),activity.getOwnerID(),activity.getPoint(),activity.getStartTime(),activity.getEndTime(),activity.getCreateTime(),activity.getUpdateTime(), activity.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<Activity> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, Activity.class, page);
	}

	@Override
	public List<Activity> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, Activity.class);
	}

	@Override
	public Long count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForLong(sql); 
	}

	@Override
	public Activity get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, Activity.class, id);
	}
	
	@Override
	public Activity getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, Activity.class, value);
	}

	@Override
	public Activity getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, Activity.class, value1, value2);
	}

	@Override
	public Activity getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, Activity.class, value1, value2);
	}

	@Override
	public List<Activity> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, Activity.class, value);
	}

	@Override
	public List<Activity> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, Activity.class, value1, value2);
	}

	@Override
	public List<Activity> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, Activity.class, value1, value2);
	}

	@Override
	public List<Activity> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, Activity.class, page, param);
	}

	@Override
	public List<Activity> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Activity.class, page, param);
	}

	@Override
	public List<Activity> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, Activity.class, page, param);
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
