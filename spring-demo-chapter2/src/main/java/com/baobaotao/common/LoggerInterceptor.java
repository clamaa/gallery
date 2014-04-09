package com.baobaotao.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author mazhiqiang
 * @date 14-4-9.
 */
@Aspect
public class LoggerInterceptor {

    @Pointcut("execution(* com.baobaotao.service.UserService.*(..))")
    public void perform(){

    }

    @Around("perform()")
    public void around(ProceedingJoinPoint proceedingJoinPoint){
        Logger.getLogger(proceedingJoinPoint.getTarget().getClass()).error(String.format("%s start...", proceedingJoinPoint.getSignature()));
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Logger.getLogger(proceedingJoinPoint.getTarget().getClass()).error(String.format("%s end...", proceedingJoinPoint.getSignature()));

    }


}
