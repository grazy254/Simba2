package com.simba.annotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * MongoDB Dao的注解
 * 
 * @author caozhejun
 *
 */
@ConditionalOnProperty(value = "dbType", havingValue = "mongodb")
public @interface MongoDBDao {

}
