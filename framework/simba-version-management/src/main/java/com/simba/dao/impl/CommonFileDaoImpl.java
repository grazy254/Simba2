package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.CommonFileDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.CommonFile;
import com.simba.model.form.CommonFileSearchForm;

/**
 * 通用文件 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class CommonFileDaoImpl implements CommonFileDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "commonFile";

	@Override
	public void add(CommonFile commonFile) {
		String sql = "insert into " + table + "( name, typeId, fileUrl, fileSize, description, createTime, extProps) values(?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, commonFile.getName(), commonFile.getTypeId(), commonFile.getFileUrl(), commonFile.getFileSize(), commonFile.getDescription(), commonFile.getCreateTime(),
				commonFile.getExtProps());
	}

	@Override
	public void update(CommonFile commonFile) {
		String sql = "update " + table + " set  name = ? , typeId = ? , fileUrl = ? , fileSize = ? , description = ? , createTime = ? , extProps = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, commonFile.getName(), commonFile.getTypeId(), commonFile.getFileUrl(), commonFile.getFileSize(), commonFile.getDescription(), commonFile.getCreateTime(),
				commonFile.getExtProps(), commonFile.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<CommonFile> page(Pager page) {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForPage(sql, CommonFile.class, page);
	}

	@Override
	public List<CommonFile> listAll() {
		String sql = "select * from " + table + " order by createTime desc";
		return jdbc.queryForList(sql, CommonFile.class);
	}

	@Override
	public Integer count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public CommonFile get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, CommonFile.class, id);
	}

	@Override
	public CommonFile getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, CommonFile.class, value);
	}

	@Override
	public CommonFile getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, CommonFile.class, value1, value2);
	}

	@Override
	public CommonFile getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, CommonFile.class, value1, value2);
	}

	@Override
	public List<CommonFile> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CommonFile.class, value);
	}

	@Override
	public List<CommonFile> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CommonFile.class, value1, value2);
	}

	@Override
	public List<CommonFile> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		return jdbc.queryForList(sql, CommonFile.class, value1, value2);
	}

	@Override
	public List<CommonFile> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, CommonFile.class, page, param);
	}

	@Override
	public List<CommonFile> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, CommonFile.class, page, param);
	}

	@Override
	public List<CommonFile> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by createTime desc";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, CommonFile.class, page, param);
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

	@Override
	public List<CommonFile> page(Pager pager, CommonFileSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, CommonFile.class, pager, param);
	}

	@Override
	public Integer count(CommonFileSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	private String buildCondition(String sql, CommonFileSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (searchForm.getTypeId() != null && searchForm.getTypeId() > 0) {
			sql += " and typeId = ? ";
			param.setInt(searchForm.getTypeId());
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

}
