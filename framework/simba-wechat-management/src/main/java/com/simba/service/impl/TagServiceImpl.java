package com.simba.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.FansDao;
import com.simba.dao.TagDao;
import com.simba.dao.TagFansDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Fans;
import com.simba.model.Tag;
import com.simba.model.TagFans;
import com.simba.model.wx.tag.BatchTag;
import com.simba.model.wx.tag.TagContent;
import com.simba.model.wx.tag.TagResult;
import com.simba.service.TagService;
import com.simba.util.send.TagWxUtil;

/**
 * 标签 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	@Autowired
	private FansDao fansDao;

	@Autowired
	private TagWxUtil TagWxUtil;

	@Autowired
	private TagFansDao tagFansDao;

	@Override
	public void add(Tag tag) {
		TagResult result = TagWxUtil.create(tag.getName());
		tag.setWxTagId(NumberUtils.toInt(result.getTag().getId() + ""));
		tagDao.add(tag);
	}

	@Override
	public void delete(Integer id) {
		int count = tagFansDao.countBy("tagId", id);
		if (count > 0) {
			throw new RuntimeException("标签下有粉丝不能删除，请先清空标签下的粉丝");
		}
		Tag tag = tagDao.get(id);
		TagWxUtil.delete(tag.getWxTagId());
		tagDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag get(Integer id) {
		return tagDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> page(Pager page) {
		return tagDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return tagDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return tagDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> listAll() {
		return tagDao.listAll();
	}

	@Override
	public void update(Tag tag) {
		tagDao.update(tag);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Tag getBy(String field, Object value) {
		return tagDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag getByAnd(String field1, Object value1, String field2, Object value2) {
		return tagDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Tag getByOr(String field1, Object value1, String field2, Object value2) {
		return tagDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> listBy(String field, Object value) {
		return tagDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> listByAnd(String field1, Object value1, String field2, Object value2) {
		return tagDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> listByOr(String field1, Object value1, String field2, Object value2) {
		return tagDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> pageBy(String field, Object value, Pager page) {
		return tagDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return tagDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tag> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return tagDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Override
	public void updateName(Tag tag) {
		Tag oldTag = tagDao.get(tag.getId());
		if (tag.getName().equals(oldTag.getName())) {
			throw new RuntimeException("标签名没有修改");
		}
		TagContent tagContent = new TagContent();
		tagContent.setId(new Long(oldTag.getWxTagId()));
		tagContent.setName(tag.getName());
		TagWxUtil.update(tagContent);
		tagDao.updateName(tag);
	}

	@Override
	public void batchClearFans(List<Integer> tagIdList) {
		tagIdList.forEach((tagId) -> {
			clearFans(tagId);
		});
	}

	private void clearFans(Integer tagId) {
		Tag tag = tagDao.get(tagId);
		long wxTagId = new Long(tag.getWxTagId());
		List<TagFans> tagFansList = tagFansDao.listBy("tagId", tagId);
		tagFansList.forEach((tagFans) -> {
			int fansId = tagFans.getFansId();
			Fans fans = fansDao.get(fansId);
			String openid = fans.getOpenid();
			List<String> openids = new ArrayList<>(1);
			openids.add(openid);
			BatchTag batchTag = new BatchTag();
			batchTag.setOpenid_list(openids);
			batchTag.setTagid(wxTagId);
			TagWxUtil.batchCancelTag(batchTag);
		});
		tagFansDao.deleteByTagId(tagId);
	}

}
