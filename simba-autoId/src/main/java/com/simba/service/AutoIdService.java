package com.simba.service;

import java.util.List;

import com.simba.model.AutoId;

/**
 * 自增id Service
 * 
 * @author caozj
 * 
 */
public interface AutoIdService {

	void batchDelete(List<String> asList);

	void delete(String id);

	List<AutoId> listAll(String key);

	void add(AutoId autoId);

	AutoId get(String id);

	void update(AutoId autoId);

}
