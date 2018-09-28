package com.simba.model.constant;

/**
 * 用来保存框架用到的所有Redis的Key，Key格式为${项目名}:${值类型}:${模块名}:${主键}
 * 
 * @author caozhejun
 *
 */
public interface SimbaRedisKey {

	String userIdOpenIdKey = "Simba:String:UserId_OpenId:";

	String thirdUserIdKey = "Simba:String:ThirdUserId_UserId:";
	
	String autoIdKey = "Simba:Long:AutoId:";

}
