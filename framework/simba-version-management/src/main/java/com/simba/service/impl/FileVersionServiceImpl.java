package com.simba.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.FileVersionDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.FileVersion;
import com.simba.service.FileVersionService;

/**
 * 文件版本管理 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class FileVersionServiceImpl implements FileVersionService {

	@Autowired
	private FileVersionDao fileVersionDao;

	@Override
	public void add(FileVersion fileVersion) {
		fileVersionDao.add(fileVersion);
	}

	@Override
	public void delete(Integer id) throws IOException, FastdfsException {
		FileVersion fileVersion = this.get(id);
		fileVersionDao.delete(id);
		UploadUtil.getInstance().getUpload().delete(fileVersion.getFileUrl());
	}

	@Override
	@Transactional(readOnly = true)
	public FileVersion get(Integer id) {
		return fileVersionDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> page(Pager page) {
		return fileVersionDao.page(page);

	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return fileVersionDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return fileVersionDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		fileVersionDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> listAll() {
		return fileVersionDao.listAll();
	}

	@Override
	public void update(FileVersion fileVersion) {
		fileVersionDao.update(fileVersion);
	}

	@Override
	public void batchDelete(List<Integer> idList) throws IOException, FastdfsException {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public FileVersion getBy(String field, Object value) {
		return fileVersionDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public FileVersion getByAnd(String field1, Object value1, String field2, Object value2) {
		return fileVersionDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public FileVersion getByOr(String field1, Object value1, String field2, Object value2) {
		return fileVersionDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> listBy(String field, Object value) {
		return fileVersionDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> listByAnd(String field1, Object value1, String field2, Object value2) {
		return fileVersionDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> listByOr(String field1, Object value1, String field2, Object value2) {
		return fileVersionDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> pageBy(String field, Object value, Pager page) {
		return fileVersionDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return fileVersionDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<FileVersion> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return fileVersionDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void add(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException {
		String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "version_uploadFile");
		double fileSize = ((double) file.getSize()) / 1024 / 1024;
		fileVersion.setFileUrl(fileUrl);
		fileVersion.setFileSize(fileSize);
		fileVersion.setCreateTime(new Date());
		this.add(fileVersion);
	}

	@Override
	public void update(FileVersion fileVersion, MultipartFile file) throws IOException, FastdfsException {
		if (file != null && file.getSize() > 0) {
			UploadUtil.getInstance().getUpload().delete(fileVersion.getFileUrl());
			String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "version_uploadFile");
			double fileSize = ((double) file.getSize()) / 1024 / 1024;
			fileVersion.setFileUrl(fileUrl);
			fileVersion.setFileSize(fileSize);
		}
		fileVersion.setCreateTime(new Date());
		this.update(fileVersion);
	}

	@Override
	public FileVersion getNewest(int typeId) {
		return fileVersionDao.getNewest(typeId);
	}

}
