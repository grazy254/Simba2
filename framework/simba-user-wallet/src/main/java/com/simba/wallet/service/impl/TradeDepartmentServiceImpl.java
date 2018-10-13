package com.simba.wallet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.simba.exception.BussException;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.dao.TradeDepartmentDao;
import com.simba.wallet.model.TradeDepartment;
import com.simba.wallet.service.TradeAccountService;
import com.simba.wallet.service.TradeDepartmentService;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 收款部门 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TradeDepartmentServiceImpl implements TradeDepartmentService {

    @Autowired
    private TradeDepartmentDao tradeDepartmentDao;

    @Autowired
    private TradeAccountService tradeAccountService;

    @Override
    @Transactional
    public void add(TradeDepartment tradeDepartment) throws Exception {
        tradeDepartmentDao.add(tradeDepartment);
    }

    @Override
    public void delete(Long id) {
        tradeDepartmentDao.delete(id);
    }

    @Override
    @Transactional
    public void delete(String deptNO) {
        tradeAccountService.closeAccount(deptNO, TradeUserType.DEPARTMENT);
        tradeDepartmentDao.deleteBy("deptNO", deptNO);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDepartment get(Long id) {
        return tradeDepartmentDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> page(Pager page) {
        return tradeDepartmentDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return tradeDepartmentDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countBy(String field, Object value) {
        return tradeDepartmentDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        tradeDepartmentDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> listAll() {
        return tradeDepartmentDao.listAll();
    }

    @Override
    public void update(TradeDepartment tradeDepartment) {
        tradeDepartmentDao.update(tradeDepartment);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        for (Long id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDepartment getBy(String field, Object value) {
        return tradeDepartmentDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDepartment getByAnd(String field1, Object value1, String field2, Object value2) {
        return tradeDepartmentDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public TradeDepartment getByOr(String field1, Object value1, String field2, Object value2) {
        return tradeDepartmentDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> listBy(String field, Object value) {
        return tradeDepartmentDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> listByAnd(String field1, Object value1, String field2,
            Object value2) {
        return tradeDepartmentDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> listByOr(String field1, Object value1, String field2,
            Object value2) {
        return tradeDepartmentDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> pageBy(String field, Object value, Pager page) {
        return tradeDepartmentDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> pageByAnd(String field1, Object value1, String field2,
            Object value2, Pager page) {
        return tradeDepartmentDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TradeDepartment> pageByOr(String field1, Object value1, String field2,
            Object value2, Pager page) {
        return tradeDepartmentDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
        tradeDepartmentDao.deleteByAnd(field1, value1, field2, value2);
    }

    @Override
    public void deleteByOr(String field1, Object value1, String field2, Object value2) {
        tradeDepartmentDao.deleteByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByAnd(String field1, Object value1, String field2, Object value2) {
        return tradeDepartmentDao.countByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByOr(String field1, Object value1, String field2, Object value2) {
        return tradeDepartmentDao.countByOr(field1, value1, field2, value2);
    }

    @Override
    public TradeDepartment get(String deptNO) {
        TradeDepartment tradeDepartment = tradeDepartmentDao.getBy("deptNO", deptNO);
        if (tradeDepartment == null) {
            throw new BussException("交易部门不存在");
        }
        return tradeDepartment;
    }

}
