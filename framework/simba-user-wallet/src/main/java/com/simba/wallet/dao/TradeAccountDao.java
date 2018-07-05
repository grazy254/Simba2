package com.simba.wallet.dao;

import java.util.List;
import java.util.Map;
import com.simba.framework.util.jdbc.Pager;
import com.simba.wallet.model.TradeAccount;
import com.simba.wallet.util.Constants.AccountType;
import com.simba.wallet.util.Constants.TradeUserType;

/**
 * 支付账号 Dao
 * 
 * @author caozj
 * 
 */
public interface TradeAccountDao {

    long add(TradeAccount tradeAccount);

    void update(TradeAccount tradeAccount);

    void delete(Long id);

    List<TradeAccount> listAll();

    Long count();

    Long countBy(String field, Object value);

    Long countByAnd(String field1, Object value1, String field2, Object value2);

    Long countByOr(String field1, Object value1, String field2, Object value2);

    void deleteBy(String field, Object value);

    void deleteByAnd(String field1, Object value1, String field2, Object value2);

    void deleteByOr(String field1, Object value1, String field2, Object value2);

    List<TradeAccount> page(Pager page);

    TradeAccount get(Long id);

    TradeAccount get(String userID, TradeUserType userType);

    TradeAccount get(Long tradeUserID, TradeUserType userType);

    TradeAccount getBy(String field, Object value);

    TradeAccount getByAnd(String field1, Object value1, String field2, Object value2);

    TradeAccount getByAnd(String field1, Object value1, String field2, Object value2, String field3,
            Object value3);

    TradeAccount getByOr(String field1, Object value1, String field2, Object value2);

    List<TradeAccount> listBy(String field, Object value);

    List<TradeAccount> listByAnd(String field1, Object value1, String field2, Object value2);

    List<TradeAccount> listByOr(String field1, Object value1, String field2, Object value2);

    List<TradeAccount> pageBy(String field, Object value, Pager page);

    List<TradeAccount> pageByAnd(String field1, Object value1, String field2, Object value2,
            Pager page);

    List<TradeAccount> pageByOr(String field1, Object value1, String field2, Object value2,
            Pager page);

    Long countByAnd(String field1, Object value1, String field2, Object value2, String field3,
            Object value3);

    Map<String, Object> getBalance(AccountType accountType);

    Map<String, Object> getBalance(Long tradeUserID, AccountType accountType);

}
