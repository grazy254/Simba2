package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.OpinionFeedback;
import com.simba.model.form.OpinionFeedbackSearchForm;

/**
 *意见反馈管理 Service
 * 
 * @author caozj
 * 
 */
public interface OpinionFeedbackService {
	//new add 
	void insertOpinionFeedback(OpinionFeedback opinionFeedback);
	
	List<OpinionFeedback> page(Pager page,OpinionFeedbackSearchForm searchForm);
	//new add end !!!

	void add(OpinionFeedback opinionFeedback);

	void update(OpinionFeedback opinionFeedback);

	void delete(Integer id);

	List<OpinionFeedback> listAll();

	Integer count();
	
	Integer countBy(String field, Object value);
	
	void deleteBy(String field, Object value);
	
	List<OpinionFeedback> page(Pager page);

	OpinionFeedback get(Integer id);
	
	void batchDelete(List<Integer> idList);

	OpinionFeedback getBy(String field, Object value);

	OpinionFeedback getByAnd(String field1, Object value1, String field2, Object value2);

	OpinionFeedback getByOr(String field1, Object value1, String field2, Object value2);

	List<OpinionFeedback> listBy(String field, Object value);

	List<OpinionFeedback> listByAnd(String field1, Object value1, String field2, Object value2);

	List<OpinionFeedback> listByOr(String field1, Object value1, String field2, Object value2);

	List<OpinionFeedback> pageBy(String field, Object value, Pager page);

	List<OpinionFeedback> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<OpinionFeedback> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
