package com.simba.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.controller.form.AliTemplateForm;
import com.simba.controller.form.JpushTemplateForm;
import com.simba.dao.MsgTemplateDao;
import com.simba.framework.util.date.DateUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.jpush.msg.util.JpushMsgUtil;
import com.simba.mobile.message.model.MsgType;
import com.simba.model.MsgTemplate;
import com.simba.model.enums.AuditStatus;
import com.simba.service.MsgTemplateService;
import com.simba.service.bean.EntryPlatform;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;

/**
 * Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class MsgTemplateServiceImpl implements MsgTemplateService {

    private static final int TEMP_TYPE_VERIFY = 1;
    private static final int TEMP_TYPE_NOTIFY = 2;
    private static final int TEMP_TYPE_AD = 3;

    private static final int AUDITING = 2;

    private static final Log logger = LogFactory.getLog(MsgTemplateServiceImpl.class);

    @Autowired
    private MsgTemplateDao templateDao;

    @Autowired
    private JpushMsgUtil jpushMsgUtil;

    @Override
    public void add(MsgTemplate template) {
        templateDao.add(template);
    }

    @Override
    public void delete(Integer id) throws APIConnectionException, APIRequestException {
        String jpushTempId = get(id).getJpushTemplateId();
        if (!StringUtils.isEmpty(jpushTempId)) {
            deleteJpushTemplate(Integer.valueOf(jpushTempId));
        }
        templateDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgTemplate get(Integer id) {
        return templateDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> page(Pager page) {
        return templateDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return templateDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countBy(String field, Object value) {
        return templateDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        templateDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> listAll() {
        return templateDao.listAll();
    }

    @Override
    public void update(MsgTemplate template) {
        try {
            int id = jpushMsgUtil.updateTemplate(Integer.valueOf(template.getJpushTemplateId()), template.getContent(), TEMP_TYPE_NOTIFY, "");
            template.setJpushTemplateId(String.valueOf(id));
            template.setStatusJpush(AUDITING);
            templateDao.update(template);
        } catch (APIConnectionException | APIRequestException e) {
            logger.error("极光模板更新失败", e);
        }
    }

    @Override
    public void batchDelete(List<Integer> idList) throws APIConnectionException, APIRequestException {
        for (Integer id : idList) {
            this.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public MsgTemplate getBy(String field, Object value) {
        return templateDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgTemplate getByAnd(String field1, Object value1, String field2, Object value2) {
        return templateDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public MsgTemplate getByOr(String field1, Object value1, String field2, Object value2) {
        return templateDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> listBy(String field, Object value) {
        return templateDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> listByAnd(String field1, Object value1, String field2, Object value2) {
        return templateDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> listByOr(String field1, Object value1, String field2, Object value2) {
        return templateDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> pageBy(String field, Object value, Pager page) {
        return templateDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return templateDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MsgTemplate> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return templateDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public EntryPlatform getOnePlatformTemplateId(String selfId) {
        MsgTemplate template = listBy("selfId", selfId).get(0);
        String aliId = template.getAliTemplateId();
        String jiGuangId = template.getJpushTemplateId();
        EntryPlatform entryPlatform = new EntryPlatform();
        if (jiGuangId != null) {
            entryPlatform.setTemplateId(jiGuangId);
            entryPlatform.setPlatformType(MsgType.JPUSH);
            return entryPlatform;
        } else if (aliId != null) {
            entryPlatform.setTemplateId(aliId);
            entryPlatform.setPlatformType(MsgType.ALI);
            return entryPlatform;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public String getPlatformTemplateId(String selfId, MsgType msgType) {
        MsgTemplate template = listBy("selfId", selfId).get(0);
        String realId = null;
        switch (msgType) {
            case ALI:
                realId = template.getAliTemplateId();
                break;
            case JPUSH:
                realId = template.getJpushTemplateId();
                break;
            default:
                return null;
        }
        return realId;
    }

    @Override
    public void addJpush(JpushTemplateForm templateJpush) throws APIConnectionException, APIRequestException {
        List<MsgTemplate> list = listBy("selfId", templateJpush.getSelfId());
        int templateId = jpushMsgUtil.createTemplate(templateJpush.getContent(), TEMP_TYPE_NOTIFY, "");
        if (list.size() == 0) {
            MsgTemplate template = new MsgTemplate();
            template.setName(templateJpush.getName());
            template.setSelfId(templateJpush.getSelfId());
            template.setContent(templateJpush.getContent());
            template.setJpushTemplateId(String.valueOf(templateId));
            template.setAliTemplateId("");
            template.setCreateTime(DateUtil.getTime());
            template.setStatusJpush(AuditStatus.AUDITING.getId());
            template.setStatusAli(AuditStatus.NONE.getId());
            add(template);
        } else {
            MsgTemplate oldTemplate = list.get(0);
            oldTemplate.setJpushTemplateId(String.valueOf(templateId));
            oldTemplate.setStatusJpush(AuditStatus.AUDITING.getId());
            oldTemplate.setContent(templateJpush.getContent());
            oldTemplate.setName(templateJpush.getName());
            update(oldTemplate);
        }
    }

    @Override
    public void addAli(AliTemplateForm templateAli) {
        List<MsgTemplate> list = listBy("selfId", templateAli.getSelfId());
        if (list.size() == 0) {
            MsgTemplate template = new MsgTemplate();
            template.setName(templateAli.getName());
            template.setSelfId(templateAli.getSelfId());
            template.setContent(templateAli.getContent());
            template.setAliTemplateId(templateAli.getAliTemplateId());
            template.setJpushTemplateId("");
            template.setStatusAli(templateAli.getStatusAli());
            template.setStatusJpush(AuditStatus.NONE.getId());
            template.setCreateTime(DateUtil.getTime());
            add(template);
        } else {
            MsgTemplate oldTemplate = list.get(0);
            oldTemplate.setAliTemplateId(templateAli.getAliTemplateId());
            oldTemplate.setStatusAli(templateAli.getStatusAli());
            oldTemplate.setContent(templateAli.getContent());
            oldTemplate.setName(templateAli.getName());
            update(oldTemplate);
        }
    }

    @Override
    public AuditStatus checkStatus(int templateId) throws APIConnectionException, APIRequestException {
        AuditStatus status = null;
        switch (jpushMsgUtil.checkTemplateStatus(templateId)) {
            case 0:
                status = AuditStatus.AUDITING;
                break;
            case 1:
                status = AuditStatus.APPROVAL;
                break;
            case 2:
                status = AuditStatus.UNAPPROVAL;
                break;
            default:
        }
        return status;
    }

    @Override
    public void updateJpushTemplatesStatus(List<MsgTemplate> templates) throws APIConnectionException, APIRequestException {
        for (MsgTemplate template : templates) {
            int status = template.getStatusJpush();
            if (status == AuditStatus.AUDITING.getId()) {
                AuditStatus newStatus = checkStatus(Integer.valueOf(template.getJpushTemplateId()));
                if (newStatus.getId() != AuditStatus.AUDITING.getId()) {
                    logger.info(template.getName() + "短信模板" + newStatus.AUDITING.getDescription());
                    template.setStatusJpush(newStatus.getId());
                    update(template);
                }
            }
        }
    }

    @Override
    public void updateJpushAllTemplatesStatus() throws APIConnectionException, APIRequestException {
        List<MsgTemplate> templates = listAll();
        ;
        updateJpushTemplatesStatus(templates);
    }

    @Override
    public void deleteJpushTemplate(int jpushTemplateId) throws APIConnectionException, APIRequestException {
        jpushMsgUtil.deleteTemplate(jpushTemplateId);
    }

}
