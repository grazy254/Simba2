package com.simba.service.impl;

import com.simba.cache.RedisUtil;
import com.simba.dao.DayAmountDao;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.DayAmount;
import com.simba.model.TotalDayAmountBean;
import com.simba.model.other.RedisKey;
import com.simba.service.DayAmountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class DayAmountServiceImpl implements DayAmountService {

    private static final Log logger = LogFactory.getLog(DayAmountServiceImpl.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DayAmountService dayAmountService;

    @PostConstruct
    private void init() {
        if (redisUtil.get(RedisKey.DAY_AMOUNT) == null) {
            redisUtil.set(RedisKey.DAY_AMOUNT, new HashMap<Integer, Integer>());
        }
        logger.info("短信用量定时器开启");
    }

    @Autowired
    private DayAmountDao dayAmountDao;

    @Override
    public void add(DayAmount dayAmount) {
        dayAmountDao.add(dayAmount);
    }

    @Override
    public void delete(Long id) {
        dayAmountDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public DayAmount get(Long id) {
        return dayAmountDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> page(Pager page) {
        return dayAmountDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return dayAmountDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countBy(String field, Object value) {
        return dayAmountDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        dayAmountDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> listAll() {
        return dayAmountDao.listAll();
    }

    @Override
    public void update(DayAmount dayAmount) {
        dayAmountDao.update(dayAmount);
    }

    @Override
    public void batchDelete(List<Long> idList) {
        for (Long id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DayAmount getBy(String field, Object value) {
        return dayAmountDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public DayAmount getByAnd(String field1, Object value1, String field2, Object value2) {
        return dayAmountDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public DayAmount getByOr(String field1, Object value1, String field2, Object value2) {
        return dayAmountDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> listBy(String field, Object value) {
        return dayAmountDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> listByAnd(String field1, Object value1, String field2, Object value2) {
        return dayAmountDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> listByOr(String field1, Object value1, String field2, Object value2) {
        return dayAmountDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> pageBy(String field, Object value, Pager page) {
        return dayAmountDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return dayAmountDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return dayAmountDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public DayAmount getLatest() {
        return dayAmountDao.getLatest();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TotalDayAmountBean> getSendAmountEachDay(Date startTime, Date endTime) {
        return dayAmountDao.getTotalAmountList(startTime, endTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DayAmount> getSendAmountEachDay(Date startTime, Date endTime, int projectId) {
        return dayAmountDao.getProjectAmountList(startTime, endTime, projectId);
    }

    private Date getDate(Date date, int offset) {
        /* 获取后一天 */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, offset); // offset=1 后一天 ; offset=-1 前一天 ;
        Date yesterDay = calendar.getTime();
        /* 格式化,干掉时分秒*/
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        String temp = myformat.format(yesterDay);
        Date yesterDayFormat = null;
        try {
            yesterDayFormat = myformat.parse(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yesterDayFormat;
    }

    /**
     * 获取前一天
     *
     * @param day
     * @return
     */
    private Date getYesterday(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return calendar.getTime();
    }


    /**
     * 每天的1点执行, 保存当天的用量, 并将计数器清零
     *
     * @return
     */
    @Scheduled(cron = "0 0 1 * * ?")
    private void countDayMsg() {
        boolean isLock = redisUtil.tryLock(RedisKey.TIMERLOCK_REDIS_KEY, 60);
        if (isLock) {
            Map<Integer, Integer> projectIdToAmount = (Map<Integer, Integer>) redisUtil.get(RedisKey.DAY_AMOUNT);
            for (Integer projectId : projectIdToAmount.keySet()) {
                DayAmount newDayAmount = new DayAmount();
                newDayAmount.setAmount(projectIdToAmount.get(projectId));
                newDayAmount.setDayDate(getYesterday(DateUtil.getTime()));
                newDayAmount.setProjectId(projectId);
                dayAmountService.add(newDayAmount);
            }
            // 清0
            redisUtil.set(RedisKey.DAY_AMOUNT, new HashMap<Integer, Integer>());
        }
    }

}
