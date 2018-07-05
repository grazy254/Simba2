package com.simba.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.FastdfsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.simba.dao.TempMediaDao;
import com.simba.framework.util.common.SystemUtil;
import com.simba.framework.util.jdbc.Pager;
import com.simba.framework.util.upload.UploadUtil;
import com.simba.model.TempMedia;
import com.simba.model.form.TempMediaSearchForm;
import com.simba.model.wx.media.UploadTempMediaResult;
import com.simba.service.TempMediaService;
import com.simba.util.send.MediaWxUtil;

/**
 * 临时素材 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TempMediaServiceImpl implements TempMediaService {

	@Autowired
	private TempMediaDao tempMediaDao;

	@Autowired
	private MediaWxUtil mediaWxUtil;

	private static final int timeout = 3 * 24 * 3600 * 1000;

	@Override
	public void add(TempMedia tempMedia) {
		tempMediaDao.add(tempMedia);
	}

	@Override
	public void delete(Long id) {
		tempMediaDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public TempMedia get(Long id) {
		return tempMediaDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> page(Pager page) {
		return tempMediaDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return tempMediaDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return tempMediaDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		tempMediaDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> listAll() {
		return tempMediaDao.listAll();
	}

	@Override
	public void update(TempMedia tempMedia) {
		tempMediaDao.update(tempMedia);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TempMedia getBy(String field, Object value) {
		return tempMediaDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public TempMedia getByAnd(String field1, Object value1, String field2, Object value2) {
		return tempMediaDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public TempMedia getByOr(String field1, Object value1, String field2, Object value2) {
		return tempMediaDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> listBy(String field, Object value) {
		return tempMediaDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tempMediaDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> listByOr(String field1, Object value1, String field2, Object value2) {
		return tempMediaDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> pageBy(String field, Object value, Pager page) {
		return tempMediaDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tempMediaDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TempMedia> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tempMediaDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void add(TempMedia tempMedia, MultipartFile file) throws IOException, FastdfsException {
		tempMedia.setCreateTime(new Date());
		String url = UploadUtil.getInstance().getUpload().upload(file.getBytes(), file.getOriginalFilename(), "wxtempmedia");
		tempMedia.setFileUrl(url);
		String tempFile = SystemUtil.getTempDir() + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
		file.transferTo(new File(tempFile));
		UploadTempMediaResult result = mediaWxUtil.uploadTempMedia(tempFile, tempMedia.getType());
		tempMedia.setMediaId(result.getMedia_id());
		if (StringUtils.isEmpty(result.getMedia_id())) {
			tempMedia.setMediaId(result.getThumb_media_id());
		}
		this.add(tempMedia);
		FileUtils.deleteQuietly(new File(tempFile));
	}

	@Override
	public int count(TempMediaSearchForm searchForm) {
		return tempMediaDao.count(searchForm);
	}

	@Override
	public List<TempMedia> page(Pager pager, TempMediaSearchForm searchForm) {
		return tempMediaDao.page(pager, searchForm);
	}

	@Override
	public void clearInvalidMedia() throws IOException, FastdfsException {
		Date date = new Date(System.currentTimeMillis() - timeout);
		List<TempMedia> list = tempMediaDao.listBefore(date);
		for (TempMedia temp : list) {
			UploadUtil.getInstance().getUpload().delete(temp.getFileUrl());
		}
		if (list.size() > 0) {
			tempMediaDao.deleteBefore(date);
		}
	}

}
