package com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.Fans;
import com.simba.model.form.FansSearchForm;

/**
 * 粉丝 Service
 * 
 * @author caozj
 * 
 */
public interface FansService {

	void add(Fans fans);

	void update(Fans fans);

	void delete(Integer id);

	List<Fans> listAll();

	int count();

	int countBy(String field, Object value);

	List<Fans> page(Pager page);

	Fans get(Integer id);

	void batchDelete(List<Integer> idList);

	Fans getBy(String field, Object value);

	Fans getByAnd(String field1, Object value1, String field2, Object value2);

	Fans getByOr(String field1, Object value1, String field2, Object value2);

	List<Fans> listBy(String field, Object value);

	List<Fans> listByAnd(String field1, Object value1, String field2, Object value2);

	List<Fans> listByOr(String field1, Object value1, String field2, Object value2);

	List<Fans> pageBy(String field, Object value, Pager page);

	List<Fans> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<Fans> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	/**
	 * 从微信服务器同步粉丝数据
	 */
	void syncFromWx();

	List<Fans> page(Pager pager, FansSearchForm searchForm);

	int count(FansSearchForm searchForm);

	void batchBlack(List<Integer> ids);

	/**
	 * 设置备注
	 * 
	 * @param id
	 * @param remark
	 */
	void updateRemark(int id, String remark);

	/**
	 * 设置标签
	 * 
	 * @param fansId
	 * @param tagIds
	 */
	void setTag(int fansId, List<Integer> tagIds);

	/**
	 * 清空标签
	 * 
	 * @param fansId
	 */
	void clearTag(int fansId);

}
