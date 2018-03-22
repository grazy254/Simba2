package com.simba.dao;

import java.util.List;

import com.simba.controller.form.LooseMoneyBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.LooseMoneyBill;

/**
 * 零钱账单 Dao
 * 
 * @author caozj
 * 
 */
public interface LooseMoneyBillDao {

	void add(LooseMoneyBill looseMoneyBill);

	void update(LooseMoneyBill looseMoneyBill);

	void delete(Long id);

	List<LooseMoneyBill> listAll();

	Long count();

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> page(Pager page);

	LooseMoneyBill get(Long id);

	LooseMoneyBill getBy(String field, Object value);

	LooseMoneyBill getByAnd(String field1, Object value1, String field2, Object value2);

	LooseMoneyBill getByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> listBy(String field, Object value);

	List<LooseMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<LooseMoneyBill> pageBy(String field, Object value, Pager page);

	List<LooseMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<LooseMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<LooseMoneyBill> page(LooseMoneyBillSearchForm searchForm, Pager pager);

	Long count(LooseMoneyBillSearchForm searchForm);

}
