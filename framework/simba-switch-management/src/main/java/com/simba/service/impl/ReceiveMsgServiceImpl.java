package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.ReceiveDealTypeDao;
import com.simba.dao.ReceiveMsgDao;
import com.simba.framework.util.applicationcontext.ApplicationContextUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.interfaces.ReceiveDealInterface;
import com.simba.model.ReceiveDealType;
import com.simba.model.ReceiveMsg;
import com.simba.model.form.ReceiveMsgSearchForm;
import com.simba.service.ReceiveMsgService;

/**
 * 接收消息 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class ReceiveMsgServiceImpl implements ReceiveMsgService {

	private static final Log logger = LogFactory.getLog(ReceiveMsgServiceImpl.class);

	@Autowired
	private ReceiveDealTypeDao deceiveDealTypeDao;

	@Autowired
	private ReceiveMsgDao receiveMsgDao;

	@Resource
	private TaskExecutor taskExecutor;

	@Override
	public Object add(ReceiveMsg receiveMsg) {
		logger.info("================接收到需要转发的消息=========================================" + receiveMsg.toString());
		Object result = null;
		ReceiveDealType receiveDealType = deceiveDealTypeDao.getBy("name", receiveMsg.getType());
		logger.info("================接收到需要转发的消息类型=========================================" + receiveDealType.toString());
		String beanID = receiveDealType.getBeanId();
		ReceiveDealInterface rdi = (ReceiveDealInterface) ApplicationContextUtil.getBean(beanID);
		if (receiveDealType.getSync() == 1) {
			result = rdi.deal(receiveMsg, receiveDealType);
		} else {
			taskExecutor.execute(() -> {
				rdi.deal(receiveMsg, receiveDealType);
			});
		}
		receiveMsg.setCreateTime(new Date());
		receiveMsgDao.add(receiveMsg);
		return result;
	}

	@Override
	public void delete(Long id) {
		receiveMsgDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMsg get(Long id) {
		return receiveMsgDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> page(Pager page) {
		return receiveMsgDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return receiveMsgDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return receiveMsgDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		receiveMsgDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> listAll() {
		return receiveMsgDao.listAll();
	}

	@Override
	public void update(ReceiveMsg receiveMsg) {
		receiveMsgDao.update(receiveMsg);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMsg getBy(String field, Object value) {
		return receiveMsgDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMsg getByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveMsgDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ReceiveMsg getByOr(String field1, Object value1, String field2, Object value2) {
		return receiveMsgDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> listBy(String field, Object value) {
		return receiveMsgDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> listByAnd(String field1, Object value1, String field2, Object value2) {
		return receiveMsgDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> listByOr(String field1, Object value1, String field2, Object value2) {
		return receiveMsgDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> pageBy(String field, Object value, Pager page) {
		return receiveMsgDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveMsgDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ReceiveMsg> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return receiveMsgDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<ReceiveMsg> page(Pager pager, ReceiveMsgSearchForm searchForm) {
		return receiveMsgDao.page(pager, searchForm);
	}

	@Override
	public Long count(ReceiveMsgSearchForm searchForm) {
		return receiveMsgDao.count(searchForm);
	}

}
