package com.simba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.controller.form.ShortMsgSearchForm;
import com.simba.controller.vo.ShortMessageVo;
import com.simba.dao.ShortMessageDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ShortMessage;
import com.simba.model.enums.SendStatus;
import com.simba.service.MsgProjectService;
import com.simba.service.ShortMessageService;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class ShortMessageServiceImpl implements ShortMessageService {

	@Autowired
	private ShortMessageDao shortMessageDao;

	@Autowired
	private MsgProjectService projectService;

	@Override
	public void add(ShortMessage shortMessage) {
		shortMessageDao.add(shortMessage);
	}

	@Override
	public void delete(Long id) {
		shortMessageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ShortMessage get(Long id) {
		return shortMessageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> page(Pager page) {
		return shortMessageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> page(Pager page, ShortMsgSearchForm msgSearchForm) {
		return shortMessageDao.page(page, msgSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count(ShortMsgSearchForm msgSearchForm) {
		return shortMessageDao.count(msgSearchForm);
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return shortMessageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Long countBy(String field, Object value) {
		return shortMessageDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		shortMessageDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> listAll() {
		return shortMessageDao.listAll();
	}

	@Override
	public void update(ShortMessage shortMessage) {
		shortMessageDao.update(shortMessage);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ShortMessage getBy(String field, Object value) {
		return shortMessageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public ShortMessage getByAnd(String field1, Object value1, String field2, Object value2) {
		return shortMessageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public ShortMessage getByOr(String field1, Object value1, String field2, Object value2) {
		return shortMessageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> listBy(String field, Object value) {
		return shortMessageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return shortMessageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> listByOr(String field1, Object value1, String field2, Object value2) {
		return shortMessageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> pageBy(String field, Object value, Pager page) {
		return shortMessageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return shortMessageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return shortMessageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessageVo> pageVo(Pager page) {
		List<ShortMessageVo> listVo = new ArrayList<>();
		List<ShortMessage> listMsg = shortMessageDao.page(page);
		for (ShortMessage message : listMsg) {
			ShortMessageVo messageVo = new ShortMessageVo();
			messageVo.setValue(message.getValue());
			messageVo.setId(message.getId());
			messageVo.setTemplateId(message.getTemplateId());
			messageVo.setMobile(message.getMobile());
			messageVo.setSendDate(message.getSendDate());
			messageVo.setProjectName(projectService.get(message.getProjectId()).getName());
			messageVo.setStatus(SendStatus.getDescById(message.getStatus()));
			messageVo.setPlatform("ali".equals(message.getPlatform()) ? "阿里" : "极光");
			messageVo.setMessageId(message.getMessageId());
			listVo.add(messageVo);
		}
		return listVo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ShortMessageVo> pageVo(Pager page, ShortMsgSearchForm msgSearchForm) {
		List<ShortMessageVo> listVo = new ArrayList<>();
		List<ShortMessage> listMsg = shortMessageDao.page(page, msgSearchForm);
		for (ShortMessage message : listMsg) {
			ShortMessageVo messageVo = new ShortMessageVo();
			messageVo.setValue(message.getValue());
			messageVo.setId(message.getId());
			messageVo.setTemplateId(message.getTemplateId());
			messageVo.setMobile(message.getMobile());
			messageVo.setSendDate(message.getSendDate());
			messageVo.setProjectName(projectService.get(message.getProjectId()).getName());
			messageVo.setStatus(SendStatus.getDescById(message.getStatus()));
			messageVo.setPlatform("ali".equals(message.getPlatform()) ? "阿里" : "极光");
			messageVo.setMessageId(message.getMessageId());
			listVo.add(messageVo);
		}
		return listVo;
	}

}
