package com.simba.wallet.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnalysisActuatorAspect {
    // final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);
    //
    // ThreadLocal<Long> beginTime = new ThreadLocal<>();
    //
    // @Pointcut("@annotation(analysisActuator)")
    // public void serviceStatistics(AnalysisActuator analysisActuator) {}
    //
    // @Before("serviceStatistics(analysisActuator)")
    // public void doBefore(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
    // // 记录请求到达时间
    // beginTime.set(System.currentTimeMillis());
    // log.info("cy666 note:{}", analysisActuator.note());
    // }
    //
    // @After("serviceStatistics(analysisActuator)")
    // public void doAfter(AnalysisActuator analysisActuator) {
    // log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(),
    // analysisActuator.note());
    // }

}
