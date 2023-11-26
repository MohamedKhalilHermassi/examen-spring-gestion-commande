package com.example.commande.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Slf4j
public class PerformenceAspect {

    @Around("execution(* com.example.commande.services.*.*(..))")

    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("Method " + pjp.getSignature().getName() + " took " + (end - start) + " ms");
        return retVal;
    }
}
