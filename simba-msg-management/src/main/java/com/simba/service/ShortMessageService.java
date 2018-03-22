package com.simba.service;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.ShortMessage;
import com.simba.model.Vo.ShortMessageVo;
import com.simba.model.form.ShortMsgSearchForm;

import java.util.List;

/**
 * Service
 * 
 * @author caozj
 * 
 */
public interface ShortMessageService {

	void add(ShortMessage shortMessage);

	void update(ShortMessage shortMessage);

	void delete(Long id);

	List<ShortMessage> listAll();

	Long count();
	
	Long countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<ShortMessage> page(Pager page);

    List<ShortMessage> page(Pager page, ShortMsgSearchForm msgSearchForm);

    Long count(ShortMsgSearchForm msgSearchForm);

	ShortMessage get(Long id);
	
	void batchDelete(List<Long> idList);

	ShortMessage getBy(String field, Object value);

	ShortMessage getByAnd(String field1, Object value1, String field2, Object value2);

	ShortMessage getByOr(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> listBy(String field, Object value);

	List<ShortMessage> listByAnd(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> listByOr(String field1, Object value1, String field2, Object value2);

	List<ShortMessage> pageBy(String field, Object value, Pager page);

	List<ShortMessage> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<ShortMessage> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<ShortMessageVo> pageVo(Pager page);

    List<ShortMessageVo> pageVo(Pager page, ShortMsgSearchForm msgSearchForm);

}
