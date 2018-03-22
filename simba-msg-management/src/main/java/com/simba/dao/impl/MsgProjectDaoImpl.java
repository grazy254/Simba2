package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.MsgProjectDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.MsgProject;

/**
 * 项目 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class MsgProjectDaoImpl implements MsgProjectDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "project";

	@Override
	public void add(MsgProject project) {
		String sql = "insert into " + table + "( name, projectKey, ip, threshold, limitNum, email, mobile) values(?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, project.getName(),project.getProjectKey(),project.getIp(),project.getThreshold(),project.getLimitNum(),project.getEmail(),project.getMobile());
	}

	@Override
	public void update(MsgProject project) {
		String sql = "update " + table + " set  name = ? , projectKey = ? , ip = ? , threshold = ? , limitNum = ? , email = ? , mobile = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,project.getName(),project.getProjectKey(),project.getIp(),project.getThreshold(),project.getLimitNum(),project.getEmail(),project.getMobile(), project.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<MsgProject> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, MsgProject.class, page);
	}

	@Override
	public List<MsgProject> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, MsgProject.class);
	}

	@Override
	public Integer count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public MsgProject get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, MsgProject.class, id);
	}
	
	@Override
	public MsgProject getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, MsgProject.class, value);
	}

	@Override
	public MsgProject getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, MsgProject.class, value1, value2);
	}

	@Override
	public MsgProject getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, MsgProject.class, value1, value2);
	}

	@Override
	public List<MsgProject> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, MsgProject.class, value);
	}

	@Override
	public List<MsgProject> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, MsgProject.class, value1, value2);
	}

	@Override
	public List<MsgProject> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, MsgProject.class, value1, value2);
	}

	@Override
	public List<MsgProject> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, MsgProject.class, page, param);
	}

	@Override
	public List<MsgProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, MsgProject.class, page, param);
	}

	@Override
	public List<MsgProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, MsgProject.class, page, param);
	}
	
	@Override
	public Integer countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}
	
	@Override
	public void deleteBy(String field, Object value) {
		String sql = "delete from " + table + " where " + field + " = ? ";
		jdbc.updateForBoolean(sql, value);
	}

}
