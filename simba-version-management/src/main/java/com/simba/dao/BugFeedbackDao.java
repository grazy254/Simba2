package com.simba.dao;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.BugFeedback;
import com.simba.model.form.BugFeedbackSearchForm;

/**
 * bug反馈管理 Dao
 * 
 * @author caozj
 * 
 */
public interface BugFeedbackDao {

	void add(BugFeedback bugFeedback);

	void update(BugFeedback bugFeedback);

	void delete(Integer id);

	List<BugFeedback> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<BugFeedback> page(Pager page);
	
	//new add
	List<BugFeedback> page(Pager page,BugFeedbackSearchForm searchForm);
	//new add !!

	BugFeedback get(Integer id);
	
	BugFeedback getBy(String field, Object value);

	BugFeedback getByAnd(String field1, Object value1, String field2, Object value2);

	BugFeedback getByOr(String field1, Object value1, String field2, Object value2);

	List<BugFeedback> listBy(String field, Object value);

	List<BugFeedback> listByAnd(String field1, Object value1, String field2, Object value2);

	List<BugFeedback> listByOr(String field1, Object value1, String field2, Object value2);

	List<BugFeedback> pageBy(String field, Object value, Pager page);

	List<BugFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<BugFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
