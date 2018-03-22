package com.simba.dao;

import java.util.List;

import com.simba.controller.form.CardMoneyBillSearchForm;
import com.simba.framework.util.jdbc.Pager;
import com.simba.model.CardMoneyBill;

/**
 * 银行卡账单 Dao
 * 
 * @author caozj
 * 
 */
public interface CardMoneyBillDao {

	void add(CardMoneyBill cardMoneyBill);

	void update(CardMoneyBill cardMoneyBill);

	void delete(Long id);

	List<CardMoneyBill> listAll();

	Long count();

	Long countBy(String field, Object value);

	Long countByAnd(String field1, Object value1, String field2, Object value2);

	Long countByOr(String field1, Object value1, String field2, Object value2);

	void deleteBy(String field, Object value);

	void deleteByAnd(String field1, Object value1, String field2, Object value2);

	void deleteByOr(String field1, Object value1, String field2, Object value2);

	List<CardMoneyBill> page(Pager page);

	CardMoneyBill get(Long id);

	CardMoneyBill getBy(String field, Object value);

	CardMoneyBill getByAnd(String field1, Object value1, String field2, Object value2);

	CardMoneyBill getByOr(String field1, Object value1, String field2, Object value2);

	List<CardMoneyBill> listBy(String field, Object value);

	List<CardMoneyBill> listByAnd(String field1, Object value1, String field2, Object value2);

	List<CardMoneyBill> listByOr(String field1, Object value1, String field2, Object value2);

	List<CardMoneyBill> pageBy(String field, Object value, Pager page);

	List<CardMoneyBill> pageByAnd(String field1, Object value1, String field2, Object value2, Pager page);

	List<CardMoneyBill> pageByOr(String field1, Object value1, String field2, Object value2, Pager page);

	List<CardMoneyBill> page(CardMoneyBillSearchForm searchForm, Pager pager);

	Long count(CardMoneyBillSearchForm searchForm);

}
