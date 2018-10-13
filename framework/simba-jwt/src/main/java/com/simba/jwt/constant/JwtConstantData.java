package com.simba.jwt.constant;

/**
 * jwt常量类
 * 
 * @author caozhejun
 *
 */
public interface JwtConstantData {

	/**
	 * 存到request中的key
	 */
	String requestAttributeName = "jwtTokenContent";

	/**
	 * 存在jwt里的payload的key
	 */
	String tokenContentName = "content";

	/**
	 * 在controller页面中的参数名称
	 */
	String tokenPageName = "jwtTokenContent";
}
