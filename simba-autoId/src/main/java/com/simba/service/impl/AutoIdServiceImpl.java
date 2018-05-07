package com.simba.service.impl;

import java.util.List;

import javax.annotation.Resource;

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

	@Resource
	private Redis redisUtil;

	@Override
	public void batchDelete(List<String> asList) {

	}

	@Override
	public void delete(String id) {

	}

	@Override
	public List<AutoId> listAll(String key) {

		return null;
	}

	@Override
	public void add(AutoId autoId) {

	}

	@Override
	public AutoId get(String id) {
		return null;
	}

	@Override
	public void update(AutoId autoId) {

	}

}
