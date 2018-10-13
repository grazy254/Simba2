package com.simba.baidu.ai.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simba.baidu.ai.exception.BaiduAIException;
import com.simba.baidu.ai.util.BaiduAiAccessTokenUtil;

/**
 * 百度AI工具类的Aspect Aop工具类，用来处理access_token过期无效
 * 
 * @author caozhejun
 *
 */
@Aspect
@Component
public class BaiduAIUtilAspect {

	private static final Log logger = LogFactory.getLog(BaiduAIUtilAspect.class);

	@Autowired
	private BaiduAiAccessTokenUtil baiduAiAccessTokenUtil;

	@Around(value = "execution(* com.*.baidu.ai.util.*.*AIUtil.*(..))")
	public Object dealAccessToken(ProceedingJoinPoint pjd) throws Throwable {
		// 获取目标方法签名
		String signature = pjd.getSignature().toString();
		logger.info("调用百度AI接口工具类:" + signature);
		long now = System.currentTimeMillis();
		Object result = null;
		try {
			result = pjd.proceed();
		} catch (BaiduAIException e) {
			if (e.getErrcode() == 110 || e.getErrcode() == 111) {
				baiduAiAccessTokenUtil.requestAccessToken();
				result = pjd.proceed();
			} else {
				throw e;
			}
		}
		long consumeTime = System.currentTimeMillis() - now;
		logger.info("执行" + signature + "消耗的时间为" + consumeTime + "毫秒");
		return result;
	}
}
