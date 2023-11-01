package com.yusuf.kusar.couriertracking.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ExecutionTimeAspect {
    @Around("@annotation(com.yusuf.kusar.couriertracking.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis()-startTime;
        log.info("{} excuted in {} ms",joinPoint.getSignature(),executionTime);
        return result;
    }
}
