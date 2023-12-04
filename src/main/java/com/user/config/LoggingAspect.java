package com.user.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Before("execution(* com.user..*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("Entering: " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* com.user..*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
    	log.info("Exiting: " + joinPoint.getSignature().toShortString());
    }
}