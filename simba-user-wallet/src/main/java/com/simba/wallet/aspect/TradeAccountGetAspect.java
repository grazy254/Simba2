package com.simba.wallet.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TradeAccountGetAspect {
    // @Around("execution(* com.simba.wallet.dao.impl.TradeUserDaoImpl.get(..))")
    // public Object tradeUserAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    // System.out.println("Before invoking getName() method");
    // Object value = null;
    // try {
    // value = proceedingJoinPoint.proceed();
    // } catch (Throwable e) {
    // if (e instanceof BussException) {
    // System.out.println("aspect exception: ===" + e.getMessage());
    // throw e;
    // }
    // }
    // System.out.println("After invoking getName() method. Return value=" + value);
    // return value;
    // }
    //
    // @AfterThrowing(throwing = "ex",
    // pointcut = "execution(* com.simba.wallet.dao.impl.TradeUserDaoImpl.get(..)) &&
    // args(userID,type)")
    // public void access(String userID, String type, Throwable ex) {
    // System.out.println("目标方法中Strig参数为:" + userID);
    // System.out.println("目标方法中Date参数为:" + type);
    // System.out.println("抛出的异常..." + ex);
    //
    // }
}
