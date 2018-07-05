package com.simba.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.UploadVideoDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.UploadVideo;
import com.simba.model.form.UploadVideoSearchForm;

/**
 * 上传视频 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class UploadVideoDaoImpl implements UploadVideoDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "uploadVideo";

	@Override
	public void add(UploadVideo uploadVideo) {
		String sql = "insert into " + table + "( title, description, mediaId, targetMediaId, createTime) values(?,?,?,?,?)";
		jdbc.updateForBoolean(sql, uploadVideo.getTitle(), uploadVideo.getDescription(), uploadVideo.getMediaId(), uploadVideo.getTargetMediaId(), uploadVideo.getCreateTime());
	}

	@Override
	public void update(UploadVideo uploadVideo) {
		String sql = "update " + table + " set  title = ? , description = ? , mediaId = ? , targetMediaId = ? , createTime = ?  where id = ?  ";
		jdbc.updateForBoolean(sql, uploadVideo.getTitle(), uploadVideo.getDescription(), uploadVideo.getMediaId(), uploadVideo.getTargetMediaId(), uploadVideo.getCreateTime(), uploadVideo.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<UploadVideo> page(Pager page) {
		String sql = "select * from " + table;
		return jdbc.queryForPage(sql, UploadVideo.class, page);
	}

	@Override
	public List<UploadVideo> listAll() {
		String sql = "select * from " + table;
		return jdbc.queryForList(sql, UploadVideo.class);
	}

	@Override
	public int count() {
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql);
	}

	@Override
	public UploadVideo get(Long id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, UploadVideo.class, id);
	}

	@Override
	public UploadVideo getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, UploadVideo.class, value);
	}

	@Override
	public UploadVideo getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, UploadVideo.class, value1, value2);
	}

	@Override
	public UploadVideo getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, UploadVideo.class, value1, value2);
	}

	@Override
	public List<UploadVideo> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.queryForList(sql, UploadVideo.class, value);
	}

	@Override
	public List<UploadVideo> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.queryForList(sql, UploadVideo.class, value1, value2);
	}

	@Override
	public List<UploadVideo> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.queryForList(sql, UploadVideo.class, value1, value2);
	}

	@Override
	public List<UploadVideo> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, UploadVideo.class, page, param);
	}

	@Override
	public List<UploadVideo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadVideo.class, page, param);
	}

	@Override
	public List<UploadVideo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, UploadVideo.class, page, param);
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
	public int count(UploadVideoSearchForm searchForm) {
		String sql = "select count(*) from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		return jdbc.queryForInt(sql, param);
	}

	@Override
	public List<UploadVideo> page(Pager pager, UploadVideoSearchForm searchForm) {
		String sql = "select * from " + table;
		StatementParameter param = new StatementParameter();
		sql = buildCondition(sql, searchForm, param);
		sql += " order by createTime desc";
		return jdbc.queryForPage(sql, UploadVideo.class, pager, param);
	}

	private String buildCondition(String sql, UploadVideoSearchForm searchForm, StatementParameter param) {
		sql += " where 1=1 ";
		if (StringUtils.isNotEmpty(searchForm.getTitle())) {
			sql += " and title like '%" + searchForm.getTitle() + "%' ";
		}
		if (StringUtils.isNotEmpty(searchForm.getMediaId())) {
			sql += " and mediaId = ? ";
			param.setString(searchForm.getMediaId());
		}
		if (StringUtils.isNotEmpty(searchForm.getTargetMediaId())) {
			sql += " and targetMediaId = ? ";
			param.setString(searchForm.getTargetMediaId());
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
