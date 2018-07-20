package com.simba.service;

import java.util.List;

import com.simba.controller.form.AliTemplateForm;
import com.simba.controller.form.JpushTemplateForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.mobile.message.model.MsgType;
import com.simba.model.MsgTemplate;
import com.simba.model.enums.AuditStatus;
import com.simba.service.bean.EntryPlatform;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface MsgTemplateService {

	void add(MsgTemplate template);

	void update(MsgTemplate template);

	void delete(Integer id) throws APIConnectionException, APIRequestException;

	List<MsgTemplate> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<MsgTemplate> page(Pager page);

	MsgTemplate get(Integer id);
	
	void batchDelete(List<Integer> idList) throws APIConnectionException, APIRequestException;

	MsgTemplate getBy(String field, Object value);

	MsgTemplate getByAnd(String field1, Object value1, String field2, Object value2);

	MsgTemplate getByOr(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> listBy(String field, Object value);

	List<MsgTemplate> listByAnd(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> listByOr(String field1, Object value1, String field2, Object value2);

	List<MsgTemplate> pageBy(String field, Object value, Pager page);

	List<MsgTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<MsgTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

    /** 获取任意一个有效的平台+对应平台的真实模板Id
	 *  若两者都有, 则优先返回极光模板
     * @param selfId
     * @return
     */
    EntryPlatform getOnePlatformTemplateId(String selfId);

    String getPlatformTemplateId(String selfId, MsgType msgType);

    void addJpush(JpushTemplateForm template) throws APIConnectionException, APIRequestException;

    void addAli(AliTemplateForm template);

	AuditStatus checkStatus(int templateId) throws APIConnectionException, APIRequestException;

	void updateJpushTemplatesStatus(List<MsgTemplate> templates) throws APIConnectionException, APIRequestException;

	void updateJpushAllTemplatesStatus() throws APIConnectionException, APIRequestException;

	void deleteJpushTemplate(int jpushTemplateId) throws APIConnectionException, APIRequestException;

}
