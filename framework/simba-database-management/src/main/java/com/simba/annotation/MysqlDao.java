package com.simba.annotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * Mysql Dao的注解
 * 
 * @author caozhejun
 *
 */
@ConditionalOnProperty(value = "dbType", havingValue = "mysql")
public @interface MysqlDao {

}
