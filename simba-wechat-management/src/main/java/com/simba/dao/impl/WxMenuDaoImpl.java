package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.WxMenuDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.WxMenu;

/**
 * 微信菜单 Dao实现类
 * 
 * @author caozj
 *  
 */
@Repository
public class WxMenuDaoImpl implements WxMenuDao {

	@Autowired
	private Jdbc jdbc;

	private static final String table = "wxMenu";

	@Override
	public void add(WxMenu wxMenu) {
		String sql = "insert into " + table + "( text, parentID, orderNo, menuKey, url, type, mediaId, appid, pagepath) values(?,?,?,?,?,?,?,?,?)";
		jdbc.updateForBoolean(sql, wxMenu.getText(),wxMenu.getParentID(),wxMenu.getOrderNo(),wxMenu.getMenuKey(),wxMenu.getUrl(),wxMenu.getType(),wxMenu.getMediaId(),wxMenu.getAppid(),wxMenu.getPagepath());
	}

	@Override
	public void update(WxMenu wxMenu) {
		String sql = "update " + table + " set  text = ? , parentID = ? , orderNo = ? , menuKey = ? , url = ? , type = ? , mediaId = ? , appid = ? , pagepath = ?  where id = ?  ";
		jdbc.updateForBoolean(sql,wxMenu.getText(),wxMenu.getParentID(),wxMenu.getOrderNo(),wxMenu.getMenuKey(),wxMenu.getUrl(),wxMenu.getType(),wxMenu.getMediaId(),wxMenu.getAppid(),wxMenu.getPagepath(), wxMenu.getId());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from " + table + " where id = ? ";
		jdbc.updateForBoolean(sql, id);
	}

	@Override
	public List<WxMenu> page(Pager page) {
		String sql = "select * from " + table+ " order by orderNo";
		return jdbc.queryForPage(sql, WxMenu.class, page);
	}

	@Override
	public List<WxMenu> listAll(){
		String sql = "select * from " + table+" order by orderNo";
		return jdbc.queryForList(sql, WxMenu.class);
	}

	@Override
	public int count(){
		String sql = "select count(*) from " + table;
		return jdbc.queryForInt(sql); 
	}

	@Override
	public WxMenu get(Integer id) {
		String sql = "select * from " + table + " where id = ? ";
		return jdbc.query(sql, WxMenu.class, id);
	}
	
	@Override
	public WxMenu getBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? ";
		return jdbc.query(sql, WxMenu.class, value);
	}

	@Override
	public WxMenu getByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
		return jdbc.query(sql, WxMenu.class, value1, value2);
	}

	@Override
	public WxMenu getByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
		return jdbc.query(sql, WxMenu.class, value1, value2);
	}

	@Override
	public List<WxMenu> listBy(String field, Object value) {
		String sql = "select * from " + table + " where " + field + " = ? order by orderNo";
		return jdbc.queryForList(sql, WxMenu.class, value);
	}

	@Override
	public List<WxMenu> listByAnd(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by orderNo";
		return jdbc.queryForList(sql, WxMenu.class, value1, value2);
	}

	@Override
	public List<WxMenu> listByOr(String field1, Object value1, String field2, Object value2) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by orderNo";
		return jdbc.queryForList(sql, WxMenu.class, value1, value2);
	}

	@Override
	public List<WxMenu> pageBy(String field, Object value, Pager page) {
		String sql = "select * from " + table + " where " + field + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value);
		return jdbc.queryForPage(sql, WxMenu.class, page, param);
	}

	@Override
	public List<WxMenu> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, WxMenu.class, page, param);
	}

	@Override
	public List<WxMenu> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? order by orderNo";
		StatementParameter param = new StatementParameter();
		param.set(value1);
		param.set(value2);
		return jdbc.queryForPage(sql, WxMenu.class, page, param);
	}
	
	@Override
	public int countBy(String field, Object value) {
		String sql = "select count(*) from " + table + " where " + field + " = ? ";
		return jdbc.queryForInt(sql, value);
	}

}
