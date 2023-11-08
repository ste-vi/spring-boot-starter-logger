package com.stevi.springbootstarterlogger.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class RepositoryLoggerAspect {

    @Pointcut("execution(* org.springframework.data.repository.Repository+.*(..))")
    public void allRepositoryMethods() {
    }

    @Around("allRepositoryMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long endTime = System.currentTimeMillis();

        log.info("Repository method %s execution took %s milliseconds"
                .formatted(joinPoint.getSignature().getName(), endTime - startTime));

        return proceed;
    }
}
