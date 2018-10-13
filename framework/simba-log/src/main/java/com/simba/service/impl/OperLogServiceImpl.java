package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.OperLogDao;
import com.simba.framework.util.common.ServerUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.ip.util.IpUtil;
import com.simba.model.OperLog;
import com.simba.model.form.OperLogSearchForm;
import com.simba.service.OperLogService;

/**
 * 操作日志 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class OperLogServiceImpl implements OperLogService {

	@Autowired
	private OperLogDao operLogDao;

	@Autowired
	private IpUtil ipUtil;

	@Resource
	private TaskExecutor taskExecutor;

	@Override
	public void add(OperLog operLog) {
		operLog.setCreateTime(new Date());
		operLogDao.add(operLog);
	}

	@Override
	public void delete(Long id) {
		operLogDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLog get(Long id) {
		return operLogDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> page(Pager page) {
		return operLogDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return operLogDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return operLogDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		operLogDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> listAll() {
		return operLogDao.listAll();
	}

	@Override
	public void update(OperLog operLog) {
		operLogDao.update(operLog);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public OperLog getBy(String field, Object value) {
		return operLogDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLog getByAnd(String field1, Object value1, String field2, Object value2) {
		return operLogDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public OperLog getByOr(String field1, Object value1, String field2, Object value2) {
		return operLogDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> listBy(String field, Object value) {
		return operLogDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> listByAnd(String field1, Object value1, String field2, Object value2) {
		return operLogDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> listByOr(String field1, Object value1, String field2, Object value2) {
		return operLogDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> pageBy(String field, Object value, Pager page) {
		return operLogDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return operLogDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OperLog> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return operLogDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<OperLog> page(Pager pager, OperLogSearchForm searchForm) {
		return operLogDao.page(pager, searchForm);
	}

	@Override
	public Long count(OperLogSearchForm searchForm) {
		return operLogDao.count(searchForm);
	}

	@Override
	public void add(HttpServletRequest request, String content, boolean async) {
		if (async) {
			taskExecutor.execute(() -> {
				addLog(request, content);
			});
		} else {
			addLog(request, content);
		}
	}

	private void addLog(HttpServletRequest request, String content) {
		String ip = ServerUtil.getProxyIp(request);
		String address = StringUtils.EMPTY;
		if (StringUtils.isNotEmpty(ip)) {
			address = ipUtil.getAdress(ip).toString();
		} else {
			ip = StringUtils.EMPTY;
		}
		String account = (String) request.getSession().getAttribute("sessAccount");
		OperLog operLog = new OperLog();
		operLog.setAccount(StringUtils.defaultString(account));
		operLog.setAddress(address);
		operLog.setContent(content);
		operLog.setIp(ip);
		this.add(operLog);
	}

}
