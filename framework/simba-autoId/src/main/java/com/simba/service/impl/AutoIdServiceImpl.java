package com.simba.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.simba.cache.Redis;
import com.simba.model.AutoId;
import com.simba.model.constant.SimbaRedisKey;
import com.simba.service.AutoIdService;

/**
 * 自增id Service实现类
 * 
 * @author caozj
 * 
 */
@Service
public class AutoIdServiceImpl implements AutoIdService {

	@Resource
	private Redis redisUtil;

	@Override
	public void batchDelete(List<String> asList) {
		asList.forEach((id) -> {
			this.delete(id);
		});
	}

	@Override
	public void delete(String id) {
		String key = SimbaRedisKey.autoIdKey + id;
		redisUtil.removeString(key);
	}

	@Override
	public List<AutoId> listAll(String key) {
		key = StringUtils.defaultString(key, StringUtils.EMPTY);
		String keys = SimbaRedisKey.autoIdKey + key + "*";
		List<String> keyList = redisUtil.keysString(keys);
		List<AutoId> autoIdList = new ArrayList<>(keyList.size());
		keyList.forEach((String k) -> {
			String id = k.substring(SimbaRedisKey.autoIdKey.length());
			long num = redisUtil.getNum(k);
			AutoId autoId = new AutoId();
			autoId.setId(id);
			autoId.setNum(num);
			autoIdList.add(autoId);
		});
		return autoIdList;
	}

	@Override
	public void add(AutoId autoId) {
		String key = SimbaRedisKey.autoIdKey + autoId.getId();
		long num = autoId.getNum();
		redisUtil.setString(key, num + "");
	}

	@Override
	public AutoId get(String id) {
		String key = SimbaRedisKey.autoIdKey + id;
		long num = redisUtil.getNum(key);
		AutoId autoId = new AutoId();
		autoId.setId(id);
		autoId.setNum(num);
		return autoId;
	}

	@Override
	public void update(AutoId autoId) {
		this.add(autoId);
	}

	@Override
	public long getAutoId(String id) {
		String key = SimbaRedisKey.autoIdKey + id;
		return redisUtil.getAutoId(key);
	}

}
