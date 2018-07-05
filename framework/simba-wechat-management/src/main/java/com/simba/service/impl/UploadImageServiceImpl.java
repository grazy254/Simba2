package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.UploadImageDao;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.UploadImage;
import com.simba.model.form.UploadImageSearchForm;
import com.simba.service.UploadImageService;
import com.simba.util.send.UploadWxUtil;

/**
 * 上传图片 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UploadImageServiceImpl implements UploadImageService {

	@Autowired
	private UploadImageDao uploadImageDao;

	@Autowired
	private UploadWxUtil uploadWxUtil;

	@Override
	public void add(UploadImage uploadImage) {
		uploadImageDao.add(uploadImage);
	}

	@Override
	public void delete(Long id) throws IOException, FastdfsException {
		UploadImage uploadImage = this.get(id);
		UploadUtil.getInstance().getUpload().delete(uploadImage.getSourceUrl());
		uploadImageDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadImage get(Long id) {
		return uploadImageDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> page(Pager page) {
		return uploadImageDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return uploadImageDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return uploadImageDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		uploadImageDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> listAll() {
		return uploadImageDao.listAll();
	}

	@Override
	public void update(UploadImage uploadImage) {
		uploadImageDao.update(uploadImage);
	}

	@Override
	public void batchDelete(List<Long> idList) throws IOException, FastdfsException {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UploadImage getBy(String field, Object value) {
		return uploadImageDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadImage getByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadImageDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadImage getByOr(String field1, Object value1, String field2, Object value2) {
		return uploadImageDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> listBy(String field, Object value) {
		return uploadImageDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> listByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadImageDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> listByOr(String field1, Object value1, String field2, Object value2) {
		return uploadImageDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> pageBy(String field, Object value, Pager page) {
		return uploadImageDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadImageDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadImage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadImageDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void add(UploadImage uploadImage, MultipartFile file) throws IOException, FastdfsException {
		String fileUrl = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "wx_uploadImage");
		uploadImage.setSourceUrl(fileUrl);
		uploadImage.setCreateTime(new Date());
		String tempFile = SystemUtil.getTempDir() + "/" + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		file.transferTo(new File(tempFile));
		String url = uploadWxUtil.uploadImage(tempFile);
		uploadImage.setWxUrl(url);
		this.add(uploadImage);
	}

	@Override
	public List<UploadImage> page(Pager pager, UploadImageSearchForm searchForm) {
		return uploadImageDao.page(pager, searchForm);
	}

	@Override
	public int count(UploadImageSearchForm searchForm) {
		return uploadImageDao.count(searchForm);
	}

}
