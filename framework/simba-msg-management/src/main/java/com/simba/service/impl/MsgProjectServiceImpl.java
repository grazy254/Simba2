package com.simba.service.impl;

import com.simba.dao.MsgProjectDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.MsgProject;
import com.simba.service.MsgProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class MsgProjectServiceImpl implements MsgProjectService {

    @Autowired
    private MsgProjectDao projectDao;

    @Override
    public void add(MsgProject project) {
        projectDao.add(project);
    }

    @Override
    public void delete(Integer id) {
        projectDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgProject get(Integer id) {
        return projectDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> page(Pager page) {
        return projectDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return projectDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countBy(String field, Object value) {
        return projectDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        projectDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> listAll() {
        return projectDao.listAll();
    }

    @Override
    public void update(MsgProject project) {
        projectDao.update(project);
    }

    @Override
    public void batchDelete(List<Integer> idList) {
        for (Integer id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MsgProject getBy(String field, Object value) {
        return projectDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgProject getByAnd(String field1, Object value1, String field2, Object value2) {
        return projectDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgProject getByOr(String field1, Object value1, String field2, Object value2) {
        return projectDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> listBy(String field, Object value) {
        return projectDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> listByAnd(String field1, Object value1, String field2, Object value2) {
        return projectDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> listByOr(String field1, Object value1, String field2, Object value2) {
        return projectDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> pageBy(String field, Object value, Pager page) {
        return projectDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return projectDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgProject> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return projectDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public String getProjectKeyBySelfId(String id) {
        MsgProject project = listBy("id", Integer.valueOf(id)).get(0);
        String key = null;
        if (project != null) {
            key = project.getProjectKey();
        }
        return key;
    }
}
