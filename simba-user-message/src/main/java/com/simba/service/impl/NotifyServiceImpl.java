package com.simba.service.impl;

import com.simba.dao.NotifyDao;
import com.simba.dao.NotifyUserDao;
import com.simba.dao.SmartUserDao;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Notify;
import com.simba.model.NotifyUser;
import com.simba.model.SmartUser;
import com.simba.service.NotifyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 通知表 Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class NotifyServiceImpl implements NotifyService {

    private static Log logger = LogFactory.getLog(NotifyServiceImpl.class);

    private static int UN_READ = 0;
    private static int ALREADY_READ = 1;


    @Autowired
    private NotifyDao notifyDao;

    @Autowired
    private NotifyUserDao notifyUserDao;

    @Autowired
    private SmartUserDao smartUserDao;

    @Override
    public void add(Notify notify) {
        notify.setCreateTime(DateUtil.getTime());
        notifyDao.add(notify);
    }

    @Override
    public void delete(Long id) {
        List<NotifyUser> notifyUserList = notifyUserDao.listBy("notifyId", id);
        for (NotifyUser notifyUser : notifyUserList) {
            notifyUserDao.delete(notifyUser.getId());
        }
        notifyDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Notify get(Long id) {
        return notifyDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> page(Pager page) {
        return notifyDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return notifyDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countBy(String field, Object value) {
        return notifyDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        notifyDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> listAll() {
        return notifyDao.listAll();
    }

    @Override
    public void update(Notify notify) {
        notifyDao.update(notify);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        for (Long id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Notify getBy(String field, Object value) {
        return notifyDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public Notify getByAnd(String field1, Object value1, String field2, Object value2) {
        return notifyDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Notify getByOr(String field1, Object value1, String field2, Object value2) {
        return notifyDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> listBy(String field, Object value) {
        return notifyDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> listByAnd(String field1, Object value1, String field2, Object value2) {
        return notifyDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> listByOr(String field1, Object value1, String field2, Object value2) {
        return notifyDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> pageBy(String field, Object value, Pager page) {
        return notifyDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return notifyDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Notify> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return notifyDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    public void sendNotify(String title, String content, Long[] smartUserIds, int type) {
        Notify notify = new Notify();
        notify.setCreateTime(DateUtil.getTime());
        notify.setTitle(title);
        notify.setContent(content);
        notify.setType(type);
        long newId = notifyDao.add(notify);
        Notify newNotify = notifyDao.get(newId);
        NotifyUser notifyUser = new NotifyUser();
        notifyUser.setStatus(UN_READ);
        notifyUser.setNotifyId(newNotify.getId());
        notifyUser.setReadTime(new Date());
        for (Long id : smartUserIds) {
            notifyUser.setSmartUserId(id);
            notifyUserDao.add(notifyUser);
        }
        logger.info("发送通知到ID为" + Arrays.toString(smartUserIds) + "的用户");
    }

    @Override
    public void sendNotify2AllUser(String title, String content, int type) {
        List<SmartUser> users = smartUserDao.listAll();
        Long[] userIds = new Long[users.size()];
        for (int i = 0; i < users.size(); i++) {
            userIds[i] = users.get(i).getId();
        }
        sendNotify(title, content, userIds, type);
    }

    @Override
    public List<Notify> pullNotify(Long smartUserId, int status) {
        List<NotifyUser> notifyUsers = notifyUserDao.listByAnd("smartUserId", smartUserId, "status", status);
        Set<Notify> notifySet = new HashSet<>();
        for (NotifyUser notifyUser : notifyUsers) {
            notifySet.add(notifyDao.get(notifyUser.getNotifyId()));
        }
        return new ArrayList<>(notifySet);
    }

    @Override
    public List<Notify> pullNotify(Long smartUserId) {
        List<NotifyUser> notifyUsers = notifyUserDao.listBy("smartUserId", smartUserId);
        Set<Notify> notifySet = new HashSet<>();
        for (NotifyUser notifyUser : notifyUsers) {
            notifySet.add(notifyDao.get(notifyUser.getNotifyId()));
        }
        return new ArrayList<>(notifySet);
    }

    @Override
    public void setNotifyRead(Long smartUserId, Long notifyId) {
        NotifyUser notifyUser = notifyUserDao.getByAnd("smartUserId", smartUserId, "notifyId", notifyId);
        notifyUser.setStatus(ALREADY_READ);
        notifyUser.setReadTime(new Date());
        notifyUserDao.update(notifyUser);
    }

    @Override
    public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
        notifyDao.deleteByAnd(field1, value1, field2, value2);
    }

    @Override
    public void deleteByOr(String field1, Object value1, String field2, Object value2) {
        notifyDao.deleteByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByAnd(String field1, Object value1, String field2, Object value2) {
        return notifyDao.countByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByOr(String field1, Object value1, String field2, Object value2) {
        return notifyDao.countByOr(field1, value1, field2, value2);
    }
}
