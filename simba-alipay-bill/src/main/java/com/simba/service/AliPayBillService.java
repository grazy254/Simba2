package  com.simba.service;

import java.util.List;

import com.simba.framework.util.jdbc.Pager;
import com.simba.model.AliPayBill;
import com.simba.model.form.AliPayBillSearchForm;
/**
 *阿里支付账单 Service
 * 
 * @author caozj
 * 
 */
public interface AliPayBillService {

	void add(AliPayBill aliPayBill);

	void update(AliPayBill aliPayBill);

	void delete(Long id);

	List<AliPayBill> listAll();
		
	Long count();
	
	Long count(AliPayBillSearchForm aliPayBillSearchForm);
	Long countBy(String field, Object value);
	
	Long countByAnd(String field1, Object value1, String field2, Object value2);
	
	Long countByOr(String field1, Object value1, String field2, Object value2);
	
	void deleteBy(String field, Object value);
	
	void deleteByAnd(String field1, Object value1, String field2, Object value2);
	
	void deleteByOr(String field1, Object value1, String field2, Object value2);
	
	List<AliPayBill> page(Pager page);
	
	List<AliPayBill> page(Pager page, AliPayBillSearchForm aliPayBillSearchForm);
	AliPayBill get(Long id);
	
	void batchDelete(List<Long> idList);

	AliPayBill getBy(String field, Object value);

	AliPayBill getByAnd(String field1, Object value1, String field2, Object value2);

	AliPayBill getByOr(String field1, Object value1, String field2, Object value2);

	List<AliPayBill> listBy(String field, Object value);

	List<AliPayBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<AliPayBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<AliPayBill> pageBy(String field, Object value, Pager page);

	List<AliPayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<AliPayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

}
