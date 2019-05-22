package com.cegeka.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Around("execution (void create(*))")
    public void aroundCreate(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("***** BEFORE in around");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Exception thrown but caught in Around");
        }
        System.out.println("***** AFTER in around");
    }

    @Around("execution (void com.cegeka.spring.company.service.CompanyService.throwException())")
    public void aroundThrowing(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println("Exception thrown but caught in Around for throwException");
        }
    }
}
