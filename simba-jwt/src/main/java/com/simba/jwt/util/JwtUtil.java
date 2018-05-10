package com.simba.jwt.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.math.NumberUtils;

import com.simba.registry.util.RegistryUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * jwt工具类
 * 
 * @author caozhejun
 *
 */
public class JwtUtil {

	/**
	 * 解析jwt
	 * 
	 * @param jsonWebToken
	 *            加密后的token
	 * @param base64Security
	 *            秘钥
	 * @return
	 */
	public static Claims parseJWT(String jsonWebToken, String base64Security) {
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security)).parseClaimsJws(jsonWebToken).getBody();
	}

	/**
	 * 解析jwt
	 * 
	 * @param jsonWebToken
	 *            加密后的token
	 * @return
	 */
	public static Claims parseJWT(String jsonWebToken) {
		String base64Security = RegistryUtil.get("jwt.base64Security");
		return parseJWT(jsonWebToken, base64Security);
	}

	/**
	 * 解析jwt里面的主体内容
	 * 
	 * @param jsonWebToken
	 *            加密后的token
	 * @return
	 */
	public static String parseJWTContent(String jsonWebToken) {
		String base64Security = RegistryUtil.get("jwt.base64Security");
		return parseJWTContent(jsonWebToken, base64Security);
	}

	/**
	 * 解析jwt里面的主体内容
	 * 
	 * @param jsonWebToken
	 *            加密后的token
	 * @param base64Security
	 *            秘钥
	 * @return
	 */
	public static String parseJWTContent(String jsonWebToken, String base64Security) {
		return parseJWT(jsonWebToken, base64Security).get("content", String.class);
	}

	/**
	 * 构建jwt
	 * 
	 * @param content
	 *            签名主体内容
	 * @param audience
	 *            接收该JWT的一方
	 * @param issuer
	 *            该JWT的签发者
	 * @param ttlMillis
	 *            过期时间
	 * @param base64Security
	 *            秘钥
	 * @return
	 */
	public static String createJWT(String content, String audience, String issuer, long ttlMillis, String base64Security) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").claim("content", content).setIssuer(issuer).setAudience(audience).signWith(signatureAlgorithm, signingKey);
		// 添加Token过期时间
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp).setNotBefore(now);
		}
		// 生成JWT
		return builder.compact();
	}

	/**
	 * 构建jwt
	 * 
	 * @param content
	 *            签名主体内容
	 * @return
	 */
	public static String createJWT(String content) {
		String base64Security = RegistryUtil.get("jwt.base64Security");
		String audience = RegistryUtil.get("jwt.audience");
		String issuer = RegistryUtil.get("jwt.issuer");
		String ttlMillis = RegistryUtil.get("jwt.ttlMillis");
		long time = NumberUtils.toLong(ttlMillis, 1800000);
		return createJWT(content, audience, issuer, time, base64Security);
	}
}
