package com.simba.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simba.dao.MsgTemplateDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.MsgTemplate;

/**
 * 短信模板 Dao实现类
 *
 * @author caozj
 */
@Repository
public class MsgTemplateDaoImpl implements MsgTemplateDao {

    @Autowired
    private Jdbc jdbc;

    private static final String table = "template";

    @Override
    public void add(MsgTemplate template) {
        String sql = "insert into " + table + "( name, content, createTime, statusAli, statusJpush, aliTemplateId, jpushTemplateId, selfId) values(?,?,?,?,?,?,?,?)";
        jdbc.updateForBoolean(sql, template.getName(), template.getContent(), template.getCreateTime(), template.getStatusAli(), template.getStatusJpush(), template.getAliTemplateId(), template.getJpushTemplateId(), template.getSelfId());
    }

    @Override
    public void update(MsgTemplate template) {
        String sql = "update " + table + " set  name = ? , content = ? , createTime = ? , statusAli = ? , statusJpush = ?,  aliTemplateId = ? , jpushTemplateId = ? , selfId = ?  where id = ?  ";
        jdbc.updateForBoolean(sql, template.getName(), template.getContent(), template.getCreateTime(), template.getStatusAli(), template.getStatusJpush(), template.getAliTemplateId(), template.getJpushTemplateId(), template.getSelfId(), template.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from " + table + " where id = ? ";
        jdbc.updateForBoolean(sql, id);
    }

    @Override
    public List<MsgTemplate> page(Pager page) {
        String sql = "select * from " + table;
        return jdbc.queryForPage(sql, MsgTemplate.class, page);
    }

    @Override
    public List<MsgTemplate> listAll() {
        String sql = "select * from " + table;
        return jdbc.queryForList(sql, MsgTemplate.class);
    }

    @Override
    public Integer count() {
        String sql = "select count(*) from " + table;
        return jdbc.queryForInt(sql);
    }

    @Override
    public MsgTemplate get(Integer id) {
        String sql = "select * from " + table + " where id = ? ";
        return jdbc.query(sql, MsgTemplate.class, id);
    }

    @Override
    public MsgTemplate getBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.query(sql, MsgTemplate.class, value);
    }

    @Override
    public MsgTemplate getByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.query(sql, MsgTemplate.class, value1, value2);
    }

    @Override
    public MsgTemplate getByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.query(sql, MsgTemplate.class, value1, value2);
    }

    @Override
    public List<MsgTemplate> listBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.queryForList(sql, MsgTemplate.class, value);
    }

    @Override
    public List<MsgTemplate> listByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.queryForList(sql, MsgTemplate.class, value1, value2);
    }

    @Override
    public List<MsgTemplate> listByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.queryForList(sql, MsgTemplate.class, value1, value2);
    }

    @Override
    public List<MsgTemplate> pageBy(String field, Object value, Pager page) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value);
        return jdbc.queryForPage(sql, MsgTemplate.class, page, param);
    }

    @Override
    public List<MsgTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, MsgTemplate.class, page, param);
    }

    @Override
    public List<MsgTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, MsgTemplate.class, page, param);
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
