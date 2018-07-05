package com.simba.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.UploadVideoDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.UploadVideo;
import com.simba.model.form.UploadVideoSearchForm;
import com.simba.model.wx.upload.UploadResult;
import com.simba.model.wx.upload.Video;
import com.simba.service.UploadVideoService;
import com.simba.util.send.UploadWxUtil;

/**
 * 上传视频 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class UploadVideoServiceImpl implements UploadVideoService {

	@Autowired
	private UploadVideoDao uploadVideoDao;

	@Autowired
	private UploadWxUtil uploadWxUtil;

	@Override
	public void add(UploadVideo uploadVideo) {
		uploadVideo.setCreateTime(new Date());
		String targetMediaId = uploadVideoToWx(uploadVideo);
		uploadVideo.setTargetMediaId(targetMediaId);
		uploadVideoDao.add(uploadVideo);
	}

	private String uploadVideoToWx(UploadVideo uploadVideo) {
		Video video = new Video();
		video.setDescription(uploadVideo.getDescription());
		video.setMedia_id(uploadVideo.getMediaId());
		video.setTitle(uploadVideo.getTitle());
		UploadResult result = uploadWxUtil.uploadVideo(video);
		return result.getMedia_id();
	}

	@Override
	public void delete(Long id) {
		uploadVideoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadVideo get(Long id) {
		return uploadVideoDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> page(Pager page) {
		return uploadVideoDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return uploadVideoDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return uploadVideoDao.countBy(field, value);
	}

	@Override
	public void deleteBy(String field, Object value) {
		uploadVideoDao.deleteBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> listAll() {
		return uploadVideoDao.listAll();
	}

	@Override
	public void update(UploadVideo uploadVideo) {
		uploadVideoDao.update(uploadVideo);
	}

	@Override
	public void batchDelete(List<Long> idList) {
		for (Long id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UploadVideo getBy(String field, Object value) {
		return uploadVideoDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadVideo getByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadVideoDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public UploadVideo getByOr(String field1, Object value1, String field2, Object value2) {
		return uploadVideoDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> listBy(String field, Object value) {
		return uploadVideoDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> listByAnd(String field1, Object value1, String field2, Object value2) {
		return uploadVideoDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> listByOr(String field1, Object value1, String field2, Object value2) {
		return uploadVideoDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> pageBy(String field, Object value, Pager page) {
		return uploadVideoDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadVideoDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UploadVideo> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return uploadVideoDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public List<UploadVideo> page(Pager pager, UploadVideoSearchForm searchForm) {
		return uploadVideoDao.page(pager, searchForm);
	}

	@Override
	public int count(UploadVideoSearchForm searchForm) {
		return uploadVideoDao.count(searchForm);
	}

}
