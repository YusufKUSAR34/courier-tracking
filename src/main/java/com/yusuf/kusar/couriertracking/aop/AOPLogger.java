package com.yusuf.kusar.couriertracking.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class AOPLogger {
    @Around("""
            execution(* com.yusuf.kusar.couriertracking..*(..)) &&
            !execution(* com.yusuf.kusar.couriertracking.mapper..*(..)) &&
            !@annotation(com.yusuf.kusar.couriertracking.aop.NoLogging)
            !target(com.yusuf.kusar.couriertracking.aop.NoLogging)""")
    public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
         String args = Arrays.toString(joinPoint.getArgs());

        log.info("Enter: {}.{}() with arguments = {}",joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature().getName(),args);
       long startTime = System.currentTimeMillis();
        Object joinPointObject;
        try {
            joinPointObject = joinPoint.proceed();
        } catch (Exception e) {
            log.error("Error Occurred: {}.{}() {}()",joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature().getName(),e.getMessage());
            throw e;
        }
        log.error("Exit: {}.{}() with return value = {},Executed in {} ms",joinPoint.getTarget().getClass().getSimpleName(),joinPoint.getSignature().getName(),joinPointObject,
                System.currentTimeMillis()-startTime);
        return joinPointObject;
    }
}
