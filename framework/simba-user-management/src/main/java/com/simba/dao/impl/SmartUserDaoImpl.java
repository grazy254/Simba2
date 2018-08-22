package com.simba.dao.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.simba.dao.SmartUserDao;
import com.simba.framework.util.jdbc.Jdbc;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.jdbc.StatementParameter;
import com.simba.model.SmartUser;
import com.simba.model.form.SmartUserSearchForm;

/**
 * 用户 Dao实现类
 * 
 * @author caozj
 * 
 */
@Repository
public class SmartUserDaoImpl implements SmartUserDao {

    @Autowired
    private Jdbc jdbc;

    private static final String table = "smartUser";

    @Override
    public long add(SmartUser smartUser) {
        String sql = "insert into " + table
                + "( account, name, email, telNo, password, createTime, status,sex,groupId,headPic) values(?,?,?,?,?,?,?,?,?,?)";
        Number id = jdbc.updateForGeneratedKey(sql, smartUser.getAccount(), smartUser.getName(),
                smartUser.getEmail(), smartUser.getTelNo(), smartUser.getPassword(),
                smartUser.getCreateTime(), smartUser.getStatus(),smartUser.getSex(),smartUser.getGroupId(),smartUser.getHeadPic());
        return id.longValue();
    }

    @Override
    public void update(SmartUser smartUser) {
        String sql = "update " + table
                + " set  account = ? , name = ? , email = ? , telNo = ? , password = ? , createTime = ? , status = ? , sex = ? , groupId = ?, headPic = ?  where id = ?  ";
        jdbc.updateForBoolean(sql, smartUser.getAccount(), smartUser.getName(),
                smartUser.getEmail(), smartUser.getTelNo(), smartUser.getPassword(),
                smartUser.getCreateTime(), smartUser.getStatus(), smartUser.getSex(),
                smartUser.getGroupId(), smartUser.getHeadPic(),smartUser.getId());
    }

    @Override
    public void updateNoPwdTime(SmartUser smartUser) {
        String sql = "update " + table
                + " set  account = ? , name = ? , email = ? , telNo = ?  where id = ?  ";
        jdbc.updateForBoolean(sql, smartUser.getAccount(), smartUser.getName(),
                smartUser.getEmail(), smartUser.getTelNo(), smartUser.getId());
    }

    @Override
    public boolean updatePassword(String account, String password) {
        String sql = "update " + table + " set  password = ? where account = ?  ";
        return jdbc.updateForBoolean(sql, password, account);
    }

    @Override
    public boolean updatePasswordWithUserId(long userId, String password) {
        String sql = "update " + table + " set  password = ? where id = ?  ";
        return jdbc.updateForBoolean(sql, password, userId);
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from " + table + " where id = ? ";
        jdbc.updateForBoolean(sql, id);
    }

    @Override
    public void resetPwd(String defaultPwd, Long id) {

        String sql = "update " + table + " set  password = ?  where id = ?  ";
        jdbc.updateForBoolean(sql, defaultPwd, id);
    }

    @Override
    public List<SmartUser> page(Pager page) {
        String sql = "select * from " + table;
        return jdbc.queryForPage(sql, SmartUser.class, page);
    }

    @Override
    public List<SmartUser> listAll() {
        String sql = "select * from " + table;
        return jdbc.queryForList(sql, SmartUser.class);
    }

    @Override
    public Long count() {
        String sql = "select count(*) from " + table;
        return jdbc.queryForLong(sql);
    }

    @Override
    public SmartUser get(Long id) {
        String sql = "select * from " + table + " where id = ? ";
        return jdbc.query(sql, SmartUser.class, id);
    }

    @Override
    public SmartUser getBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.query(sql, SmartUser.class, value);
    }

    @Override
    public SmartUser getByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.query(sql, SmartUser.class, value1, value2);
    }

    @Override
    public SmartUser getByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.query(sql, SmartUser.class, value1, value2);
    }

    @Override
    public List<SmartUser> listBy(String field, Object value) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        return jdbc.queryForList(sql, SmartUser.class, value);
    }

    @Override
    public List<SmartUser> listByAnd(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        return jdbc.queryForList(sql, SmartUser.class, value1, value2);
    }

    @Override
    public List<SmartUser> listByOr(String field1, Object value1, String field2, Object value2) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        return jdbc.queryForList(sql, SmartUser.class, value1, value2);
    }

    @Override
    public List<SmartUser> pageBy(String field, Object value, Pager page) {
        String sql = "select * from " + table + " where " + field + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value);
        return jdbc.queryForPage(sql, SmartUser.class, page, param);
    }

    @Override
    public List<SmartUser> pageByAnd(String field1, Object value1, String field2, Object value2,
            Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? and " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, SmartUser.class, page, param);
    }

    @Override
    public List<SmartUser> pageByOr(String field1, Object value1, String field2, Object value2,
            Pager page) {
        String sql = "select * from " + table + " where " + field1 + " = ? or " + field2 + " = ? ";
        StatementParameter param = new StatementParameter();
        param.set(value1);
        param.set(value2);
        return jdbc.queryForPage(sql, SmartUser.class, page, param);
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
    public Long count(SmartUserSearchForm searchForm) {
        String sql = "select count(*) from " + table;
        StatementParameter param = new StatementParameter();
        sql = buildCondition(sql, searchForm, param);
        return jdbc.queryForLong(sql, param);
    }

    @Override
    public List<SmartUser> page(Pager pager, SmartUserSearchForm searchForm) {
        String sql = "select * from " + table;
        StatementParameter param = new StatementParameter();
        sql = buildCondition(sql, searchForm, param);
        sql += " order by createTime desc";
        return jdbc.queryForPage(sql, SmartUser.class, pager, param);
    }

    private String buildCondition(String sql, SmartUserSearchForm searchForm,
            StatementParameter param) {
        sql += " where 1=1 ";
        if (StringUtils.isNotEmpty(searchForm.getAccount())) {
            sql += " and account like '%" + searchForm.getAccount() + "%' ";
        }
        if (StringUtils.isNotEmpty(searchForm.getName())) {
            sql += " and name like '%" + searchForm.getName() + "%' ";
        }
        if (StringUtils.isNotEmpty(searchForm.getEmail())) {
            sql += " and email like '%" + searchForm.getEmail() + "%' ";
        }
        if (StringUtils.isNotEmpty(searchForm.getTelNo())) {
            sql += " and telNo like '%" + searchForm.getTelNo() + "%' ";
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
