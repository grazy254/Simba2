package com.simba.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.simba.dao.BlacklistDao;
import com.simba.dao.FansDao;
import com.simba.dao.TagDao;
import com.simba.dao.TagFansDao;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Blacklist;
import com.simba.model.Fans;
import com.simba.model.Tag;
import com.simba.model.TagFans;
import com.simba.model.form.FansSearchForm;
import com.simba.model.wx.tag.BatchTag;
import com.simba.model.wx.tag.ListTagContent;
import com.simba.model.wx.tag.ListTagResult;
import com.simba.model.wx.user.Openids;
import com.simba.model.wx.user.User;
import com.simba.model.wx.user.UserList;
import com.simba.service.FansService;
import com.simba.util.send.TagWxUtil;
import com.simba.util.send.UserWxUtil;

/**
 * 粉丝 Service实现类
 * 
 * @author caozj
 * 
 */
@Service
@Transactional
public class FansServiceImpl implements FansService {

	private static final Log logger = LogFactory.getLog(FansServiceImpl.class);

	@Autowired
	private FansDao fansDao;

	@Autowired
	private UserWxUtil userWxUtil;

	@Autowired
	private TagWxUtil tagWxUtil;

	@Autowired
	private TagFansDao tagFansDao;

	@Autowired
	private TagDao tagDao;

	@Autowired
	private BlacklistDao blacklistDao;

	@Override
	public void add(Fans fans) {
		fansDao.add(fans);
	}

	@Override
	public void delete(Integer id) {
		fansDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Fans get(Integer id) {
		return fansDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> page(Pager page) {
		return fansDao.page(page);
	}

	@Override
	@Transactional(readOnly = true)
	public int count() {
		return fansDao.count();
	}

	@Override
	@Transactional(readOnly = true)
	public int countBy(String field, Object value) {
		return fansDao.countBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> listAll() {
		return fansDao.listAll();
	}

	@Override
	public void update(Fans fans) {
		fansDao.update(fans);
	}

	@Override
	public void batchDelete(List<Integer> idList) {
		for (Integer id : idList) {
			this.delete(id);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Fans getBy(String field, Object value) {
		return fansDao.getBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public Fans getByAnd(String field1, Object value1, String field2, Object value2) {
		return fansDao.getByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public Fans getByOr(String field1, Object value1, String field2, Object value2) {
		return fansDao.getByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> listBy(String field, Object value) {
		return fansDao.listBy(field, value);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> listByAnd(String field1, Object value1, String field2, Object value2) {
		return fansDao.listByAnd(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> listByOr(String field1, Object value1, String field2, Object value2) {
		return fansDao.listByOr(field1, value1, field2, value2);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> pageBy(String field, Object value, Pager page) {
		return fansDao.pageBy(field, value, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page) {
		return fansDao.pageByAnd(field1, value1, field2, value2, page);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page) {
		return fansDao.pageByOr(field1, value1, field2, value2, page);
	}

	@Async
	@Override
	public void syncFromWx() {
		syncWxTag();
		syncWxUser();
	}

	private void syncWxTag() {
		ListTagResult list = tagWxUtil.list();
		List<Integer> wxTagIds = new ArrayList<>();
		list.getTags().forEach((ListTagContent listTagContent) -> {
			int id = NumberUtils.toInt(listTagContent.getId() + "");
			wxTagIds.add(id);
			String name = listTagContent.getName();
			List<Tag> tagList = tagDao.listBy("wxTagId", id);
			if (tagList.size() == 0) {
				Tag tag = new Tag();
				tag.setName(name);
				tag.setWxTagId(id);
				tagDao.add(tag);
				logger.info("新增标签成功:" + tag.toString());
			} else {
				Tag tag = tagList.get(0);
				tag.setName(name);
				tagDao.update(tag);
			}
		});
		int total = tagDao.count();
		if (total > wxTagIds.size()) {
			List<Integer> dbWxTagIds = tagDao.listAllWxTagIds();
			dbWxTagIds.forEach((wxTagId) -> {
				if (!wxTagIds.contains(wxTagId)) {
					tagDao.deleteByWxTagId(wxTagId);
				}
			});
		}
	}

	private void syncWxUser() {
		UserList userList = userWxUtil.listAttendUser(null);
		int total = userList.getTotal();
		Openids data = userList.getData();
		List<String> openidList = new ArrayList<>();
		String nextOpenID = userList.getNext_openid();
		syncOpenids(data, openidList);
		while (StringUtils.isNotEmpty(nextOpenID) && openidList.size() < total) {
			userList = userWxUtil.listAttendUser(nextOpenID);
			total = userList.getTotal();
			data = userList.getData();
			nextOpenID = userList.getNext_openid();
			syncOpenids(data, openidList);
		}
		int dbCount = fansDao.count();
		if (dbCount > openidList.size()) {
			List<String> dbOpenids = fansDao.listAllOpenids();
			dbOpenids.forEach((dbopenid) -> {
				if (!openidList.contains(dbopenid)) {
					fansDao.deleteByOpenid(dbopenid);
					logger.info("删除已取消关注粉丝成功:" + dbopenid);
				}
			});
		}
	}

	private void syncOpenids(Openids data, List<String> openidList) {
		data.getOpenid().forEach((openid) -> {
			openidList.add(openid);
			User wxUser = userWxUtil.getUserInfo(openid);
			List<Fans> fansList = fansDao.listBy("openid", openid);
			if (fansList.size() == 0) {
				Fans fans = new Fans();
				buildFans(openid, wxUser, fans);
				try {
					fansDao.add(fans);
					logger.info("新增粉丝成功:" + fans.toString());
					saveFansTag(fans, wxUser.getTagid_list());
				} catch (Exception e) {
					logger.error("新增粉丝异常:" + fans.toString(), e);
				}
			} else {
				Fans fans = fansList.get(0);
				buildFans(openid, wxUser, fans);
				fansDao.update(fans);
				saveFansTag(fans, wxUser.getTagid_list());
			}
		});
	}

	private void saveFansTag(Fans fans, List<Long> tagid_list) {
		int fansId = fans.getId();
		tagid_list.forEach((wxTagId) -> {
			Tag tag = tagDao.getBy("wxTagId", wxTagId);
			int tagId = tag.getId();
			List<TagFans> list = tagFansDao.listByAnd("tagId", tagId, "fansId", fansId);
			if (list.size() == 0) {
				TagFans tagFans = new TagFans();
				tagFans.setFansId(fansId);
				tagFans.setTagId(tagId);
				tagFansDao.add(tagFans);
			}
		});
	}

	private void buildFans(String openid, User wxUser, Fans fans) {
		fans.setOpenid(openid);
		fans.setNickname(wxUser.getNickname());
		fans.setRemark(wxUser.getRemark());
		fans.setSex(wxUser.getSex());
		fans.setCity(wxUser.getCity());
		fans.setProvince(wxUser.getProvince());
		fans.setCountry(wxUser.getCountry());
		fans.setHeadimgurl(wxUser.getHeadimgurl());
		fans.setSubscribeTime(new Date(NumberUtils.toLong(wxUser.getSubscribe_time() + "000")));
	}

	@Override
	public List<Fans> page(Pager pager, FansSearchForm searchForm) {
		return fansDao.page(pager, searchForm);
	}

	@Override
	public int count(FansSearchForm searchForm) {
		return fansDao.count(searchForm);
	}

	@Override
	public void batchBlack(List<Integer> ids) {
		List<Blacklist> blist = new ArrayList<>();
		List<String> openids = new ArrayList<>();
		ids.forEach((id) -> {
			int count = blacklistDao.countBy("fansId", id);
			if (count == 0) {
				Blacklist blacklist = new Blacklist();
				blacklist.setCreateTime(new Date());
				blacklist.setFansId(id);
				blist.add(blacklist);
				openids.add(fansDao.get(id).getOpenid());
			}
		});
		userWxUtil.batchBlackList(openids);
		blist.forEach((blacklist) -> {
			blacklistDao.add(blacklist);
		});
	}

	@Override
	public void updateRemark(int id, String remark) {
		Fans fans = fansDao.get(id);
		userWxUtil.setUserRemark(fans.getOpenid(), remark);
		fansDao.updateRemark(id, remark);
	}

	@Override
	public void setTag(int fansId, List<Integer> tagIds) {
		Fans fans = fansDao.get(fansId);
		String openid = fans.getOpenid();
		List<String> openids = new ArrayList<>(1);
		openids.add(openid);
		List<TagFans> tagFansList = tagFansDao.listBy("fansId", fansId);
		tagFansList.forEach((TagFans tagFans) -> {
			int tagId = tagFans.getTagId();
			Tag tag = tagDao.get(tagId);
			BatchTag batchTag = new BatchTag();
			batchTag.setTagid(tag.getWxTagId());
			batchTag.setOpenid_list(openids);
			tagWxUtil.batchCancelTag(batchTag);
		});
		tagIds.forEach((Integer tagId) -> {
			Tag tag = tagDao.get(tagId);
			BatchTag batchTag = new BatchTag();
			batchTag.setTagid(tag.getWxTagId());
			batchTag.setOpenid_list(openids);
			tagWxUtil.batchTag(batchTag);
		});
		tagFansDao.deleteByFansId(fansId);
		tagIds.forEach((Integer tagId) -> {
			TagFans tagFans = new TagFans();
			tagFans.setTagId(tagId);
			tagFans.setFansId(fansId);
			tagFansDao.add(tagFans);
		});
	}

	@Override
	public void clearTag(int fansId) {
		Fans fans = fansDao.get(fansId);
		String openid = fans.getOpenid();
		List<String> openids = new ArrayList<>(1);
		openids.add(openid);
		List<TagFans> tagFansList = tagFansDao.listBy("fansId", fansId);
		tagFansList.forEach((TagFans tagFans) -> {
			int tagId = tagFans.getTagId();
			Tag tag = tagDao.get(tagId);
			BatchTag batchTag = new BatchTag();
			batchTag.setTagid(tag.getWxTagId());
			batchTag.setOpenid_list(openids);
			tagWxUtil.batchCancelTag(batchTag);
		});
		tagFansDao.deleteByFansId(fansId);
	}

}
