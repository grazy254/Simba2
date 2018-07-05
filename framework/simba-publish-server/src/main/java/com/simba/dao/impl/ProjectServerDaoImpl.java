package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.ProjectServerDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.ProjectServer;

/**
 * 服务器 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class ProjectServerDaoImpl implements ProjectServerDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "projectServer";

	@Override
	public void add(ProjectServer projectServer) {
		String sql = "insert into " + table + "( name, ip, port) values(?,?,?)";
		jdbc.updateForBoolean(sql, projectServer.getName(),projectServer.getIp(),projectServer.getPort());
	}

	@Override
	public void update(ProjectServer projectServer) {
		String sql = "update " + table + " set  name = ? , ip = ? , port = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,projectServer.getName(),projectServer.getIp(),projectServer.getPort(), projectServer.getId());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<ProjectServer> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, ProjectServer.class, page);
	}

	@Override
	public List<ProjectServer> listAll(){
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, ProjectServer.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public ProjectServer get(int id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, ProjectServer.class, id);
	}
	
	@Override
	public ProjectServer getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, ProjectServer.class, value);
	}

	@Override
	public ProjectServer getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, ProjectServer.class, value1, value2);
	}

	@Override
	public ProjectServer getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, ProjectServer.class, value1, value2);
	}

	@Override
	public List<ProjectServer> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, ProjectServer.class, value);
	}

	@Override
	public List<ProjectServer> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectServer.class, value1, value2);
	}

	@Override
	public List<ProjectServer> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, ProjectServer.class, value1, value2);
	}

	@Override
	public List<ProjectServer> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, ProjectServer.class, page, param);
	}

	@Override
	public List<ProjectServer> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectServer.class, page, param);
	}

	@Override
	public List<ProjectServer> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, ProjectServer.class, page, param);
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
