package com.simba.service.impl;

import com.simba.dao.MsgBlacklistDao;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgBlacklist;
import com.simba.service.MsgBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class MsgBlacklistServiceImpl implements MsgBlacklistService {

    @Autowired
    private MsgBlacklistDao blacklistDao;

    @Override
    public void add(MsgBlacklist blacklist) {
        blacklist.setCreateTime(DateUtil.getTime());
        blacklistDao.add(blacklist);
    }

    @Override
    public void delete(Integer id) {
        blacklistDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgBlacklist get(Integer id) {
        return blacklistDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> page(Pager page) {
        return blacklistDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return blacklistDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countBy(String field, Object value) {
        return blacklistDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        blacklistDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> listAll() {
        return blacklistDao.listAll();
    }

    @Override
    public void update(MsgBlacklist blacklist) {
        blacklistDao.update(blacklist);
    }

    @Override
    public void batchDelete(List<Integer> idList) {
        for (Integer id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MsgBlacklist getBy(String field, Object value) {
        return blacklistDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgBlacklist getByAnd(String field1, Object value1, String field2, Object value2) {
        return blacklistDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgBlacklist getByOr(String field1, Object value1, String field2, Object value2) {
        return blacklistDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> listBy(String field, Object value) {
        return blacklistDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> listByAnd(String field1, Object value1, String field2, Object value2) {
        return blacklistDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> listByOr(String field1, Object value1, String field2, Object value2) {
        return blacklistDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> pageBy(String field, Object value, Pager page) {
        return blacklistDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return blacklistDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgBlacklist> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return blacklistDao.pageByOr(field1, value1, field2, value2, page);
    }

    /** 获取其中属于黑名单中的手机号
     * @param mobileList
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<String> filterBlacklist(List<String> mobileList) {
        List<String> blackList = new ArrayList<>();
        for (String mobileNo : mobileList) {
            List<MsgBlacklist> result = listBy("mobile", mobileNo);
            if (result.size() > 0) {
                blackList.add(mobileNo);
            }
        }
        return blackList;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isDuplicated(String mobile) {
        int listSize = listBy("mobile", mobile).size();
        if (listSize > 0) {
            return true;
        } else {
            return false;
        }
    }

}
