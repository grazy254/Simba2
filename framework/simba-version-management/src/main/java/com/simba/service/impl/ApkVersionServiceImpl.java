package com.simba.service.impl;

import com.simba.dao.ApkVersionDao;
import com.simba.framework.util.common.XmlUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.ApkVersion;
import com.simba.service.ApkVersionService;
import com.simba.util.ApkUtil;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import util.AxmlUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * apk管理 Service实现类
 *
 * @author caozj
 */
@Service
@Transactional
public class ApkVersionServiceImpl implements ApkVersionService {

    @Autowired
    private ApkVersionDao apkVersionDao;

    @Override
    public void add(ApkVersion apkVersion) {
        apkVersionDao.add(apkVersion);
    }

    @Override
    public void add(ApkVersion apkVersion, MultipartFile file) throws Exception {
        apkVersion.setVersion(ApkUtil.getApkVersion(new ByteArrayInputStream(file.getBytes())));
        String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "version_uploadFile");
        try {
            double fileSize = ((double) file.getSize()) / 1024 / 1024;
            apkVersion.setTypeId(0);
            apkVersion.setFileUrl(fileUrl);
            apkVersion.setFileSize(fileSize);
            apkVersion.setCreateTime(new Date());
            this.add(apkVersion);
        } catch (Exception e) {
            UploadUtil.getInstance().getUpload().delete(fileUrl);
            throw new RuntimeException("上传失败", e);
        }

    }

    @Override
    public void delete(Integer id) throws IOException, FastdfsException {
        ApkVersion apkVersion = this.get(id);
        apkVersionDao.delete(id);
        UploadUtil.getInstance().getUpload().delete(apkVersion.getFileUrl());
    }

    @Override
    @Transactional(readOnly = true)
    public ApkVersion get(Integer id) {
        return apkVersionDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> page(Pager page) {
        return apkVersionDao.page(page);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer count() {
        return apkVersionDao.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countBy(String field, Object value) {
        return apkVersionDao.countBy(field, value);
    }

    @Override
    public void deleteBy(String field, Object value) {
        apkVersionDao.deleteBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> listAll() {
        return apkVersionDao.listAll();
    }

    @Override
    public void update(ApkVersion apkVersion) {
        apkVersionDao.update(apkVersion);
    }

    @Override
    public void batchDelete(List<Integer> idList) throws IOException, FastdfsException {
        for (Integer id : idList) {
            this.delete(id);
        }
    }

    @Override
    public void update(ApkVersion apkVersion, MultipartFile file) throws Exception {
        if (file != null && file.getSize() > 0) {
            apkVersion.setVersion(ApkUtil.getApkVersion(new ByteArrayInputStream(file.getBytes())));
            UploadUtil.getInstance().getUpload().delete(apkVersion.getFileUrl());
            String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "version_uploadFile");
            double fileSize = ((double) file.getSize()) / 1024 / 1024;
            apkVersion.setFileUrl(fileUrl);
            apkVersion.setFileSize(fileSize);
        }
        apkVersion.setCreateTime(new Date());
        this.update(apkVersion);
    }


    @Override
    @Transactional(readOnly = true)
    public ApkVersion getBy(String field, Object value) {
        return apkVersionDao.getBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public ApkVersion getByAnd(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.getByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public ApkVersion getByOr(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.getByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> listBy(String field, Object value) {
        return apkVersionDao.listBy(field, value);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.listByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> listByOr(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.listByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> pageBy(String field, Object value, Pager page) {
        return apkVersionDao.pageBy(field, value, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
        return apkVersionDao.pageByAnd(field1, value1, field2, value2, page);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApkVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
        return apkVersionDao.pageByOr(field1, value1, field2, value2, page);
    }

    @Override
    public void deleteByAnd(String field1, Object value1, String field2, Object value2) {
        apkVersionDao.deleteByAnd(field1, value1, field2, value2);
    }

    @Override
    public void deleteByOr(String field1, Object value1, String field2, Object value2) {
        apkVersionDao.deleteByOr(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countByAnd(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.countByAnd(field1, value1, field2, value2);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countByOr(String field1, Object value1, String field2, Object value2) {
        return apkVersionDao.countByOr(field1, value1, field2, value2);
    }

    @Override
    public ApkVersion getNewest(int typeId) {
        return apkVersionDao.getNewest(typeId);
    }
}
