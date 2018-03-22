package com.simba.dao;

import java.util.List;

import com.simba.controller.form.PayBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.PayBill;

/**
 * 支付账单 Dao
 * 
 * @author caozj
 * 
 */
public interface PayBillDao {

	void add(PayBill payBill);

	void update(PayBill payBill);

	void delete(Long id);

	List<PayBill> listAll();

	Long count();

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> page(Pager page);

	PayBill get(Long id);

	PayBill getBy(String field, Object value);

	PayBill getByAnd(String field1, Object value1, String field2, Object value2);

	PayBill getByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> listBy(String field, Object value);

	List<PayBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<PayBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<PayBill> pageBy(String field, Object value, Pager page);

	List<PayBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<PayBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<PayBill> page(PayBillSearchForm searchForm, Pager pager);

	Long count(PayBillSearchForm searchForm);

}
