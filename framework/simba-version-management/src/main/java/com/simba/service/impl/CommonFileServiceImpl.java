package com.simba.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.CommonFileDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.CommonFile;
import com.simba.model.form.CommonFileSearchForm;
import com.simba.service.CommonFileService;

/**
 * 通用文件 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class CommonFileServiceImpl implements CommonFileService {

	@Autowired
	private CommonFileDao commonFileDao;

	@Override
	public void add(CommonFile commonFile) {
		commonFileDao.add(commonFile);
	}

	@Override
	public void delete(Integer id) throws IOException, FastdfsException {
		CommonFile commonFile = this.get(id);
		commonFileDao.delete(id);
		UploadUtil.getInstance().getUpload().delete(commonFile.getFileUrl());
	}

	@Override
	@Transactional(readOnly = true)
	public CommonFile get(Integer id) {
		return commonFileDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> page(Pager page) {
		return commonFileDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer count() {
		return commonFileDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer countBy(String field, Object value) {
		return commonFileDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		commonFileDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> listAll() {
		return commonFileDao.listAll();
	}

	@Override
	public void update(CommonFile commonFile) {
		commonFileDao.update(commonFile);
	}

	@Override
	public void batchDelete(List<Integer> idList) throws IOException, FastdfsException {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CommonFile getBy(String field, Object value) {
		return commonFileDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public CommonFile getByAnd(String field1, Object value1, String field2, Object value2) {
		return commonFileDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public CommonFile getByOr(String field1, Object value1, String field2, Object value2) {
		return commonFileDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> listBy(String field, Object value) {
		return commonFileDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> listByAnd(String field1, Object value1, String field2, Object value2) {
		return commonFileDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> listByOr(String field1, Object value1, String field2, Object value2) {
		return commonFileDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> pageBy(String field, Object value, Pager page) {
		return commonFileDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return commonFileDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CommonFile> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return commonFileDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<CommonFile> page(Pager pager, CommonFileSearchForm searchForm) {
		return commonFileDao.page(pager, searchForm);
	}

	@Override
	public Integer count(CommonFileSearchForm searchForm) {
		return commonFileDao.count(searchForm);
	}

	@Override
	public void add(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException {
		String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "commonFile_uploadFile");
		double fileSize = ((double) file.getSize()) / 1024 / 1024;
		commonFile.setFileUrl(fileUrl);
		commonFile.setFileSize(fileSize);
		commonFile.setCreateTime(new Date());
		this.add(commonFile);

	}

	@Override
	public void update(CommonFile commonFile, MultipartFile file) throws IOException, FastdfsException {
		if (file != null && file.getSize() > 0) {
			UploadUtil.getInstance().getUpload().delete(commonFile.getFileUrl());
			String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "commonFile_uploadFile");
			double fileSize = ((double) file.getSize()) / 1024 / 1024;
			commonFile.setFileUrl(fileUrl);
			commonFile.setFileSize(fileSize);
		}
		commonFile.setCreateTime(new Date());
		this.update(commonFile);
	}

}
