package com.simba.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.simba.cache.Redis;
import com.simba.model.AutoId;
import com.simba.service.AutoIdService;

/**
 * 自增id Service实现类
 * 
 * @author caozj
 * 
 */
@Service
public class AutoIdServiceImpl implements AutoIdService {

	private static final String suffix = "_autoId";

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
		String key = id + suffix;
		redisUtil.removeString(key);
	}

	@Override
	public List<AutoId> listAll(String key) {
		key = StringUtils.defaultString(key, StringUtils.EMPTY);
		String keys = key + "*" + suffix;
		List<String> keyList = redisUtil.keysString(keys);
		List<AutoId> autoIdList = new ArrayList<>(keyList.size());
		keyList.forEach((String k) -> {
			int index = k.lastIndexOf(suffix);
			String id = k.substring(0, index);
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
		String key = autoId.getId() + suffix;
		long num = autoId.getNum();
		redisUtil.setString(key, num + "");
	}

	@Override
	public AutoId get(String id) {
		String key = id + suffix;
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
		String key = id + suffix;
		return redisUtil.getAutoId(key);
	}

}
