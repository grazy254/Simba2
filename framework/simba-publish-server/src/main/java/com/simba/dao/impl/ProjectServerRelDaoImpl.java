package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectServerRelDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ProjectServerRel;

/**
 * 项目绑定部署的服务器 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ProjectServerRelDaoImpl implements ProjectServerRelDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "projectServerRel";

	@Override
	public void add(ProjectServerRel projectServerRel) {
		String sql = "insert into " + table + "( projectId, serverId) values(?,?)";
		jdbc.updateForBoolean(sql, projectServerRel.getProjectId(),projectServerRel.getServerId());
	}

	@Override
	public void update(ProjectServerRel projectServerRel) {
		String sql = "update " + table + " set  projectId = ? , serverId = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,projectServerRel.getProjectId(),projectServerRel.getServerId(), projectServerRel.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ProjectServerRel> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ProjectServerRel.class, page);
	}

	@Override
	public List<ProjectServerRel> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ProjectServerRel.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public ProjectServerRel get(int id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ProjectServerRel.class, id);
	}
	
	@Override
	public ProjectServerRel getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ProjectServerRel.class, value);
	}

	@Override
	public ProjectServerRel getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ProjectServerRel.class, value1, value2);
	}

	@Override
	public ProjectServerRel getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ProjectServerRel.class, value1, value2);
	}

	@Override
	public List<ProjectServerRel> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ProjectServerRel.class, value);
	}

	@Override
	public List<ProjectServerRel> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectServerRel.class, value1, value2);
	}

	@Override
	public List<ProjectServerRel> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectServerRel.class, value1, value2);
	}

	@Override
	public List<ProjectServerRel> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ProjectServerRel.class, page, param);
	}

	@Override
	public List<ProjectServerRel> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectServerRel.class, page, param);
	}

	@Override
	public List<ProjectServerRel> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectServerRel.class, page, param);
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
	public int countByOr(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
	}
	
	@Override
	public int countByAnd(String field1, Object value1, String field2, Object value2){
		String sql = "select count(*) from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForInt(sql, value1, value2);
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
