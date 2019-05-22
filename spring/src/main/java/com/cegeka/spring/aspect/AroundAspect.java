package com.cegeka.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {

    @Around("execution(void com.cegeka.spring.company.service.impl.PrivateCompanyService.create(..))")
    public void afisare(){
        System.out.println("AroundAspect~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "\n");
    }

    @Around("execution (void com.cegeka.spring.company.service.CompanyService.throwException())")
    public void throwingAround(ProceedingJoinPoint proceedingJoinPoint){
        try{
            proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            System.out.println("Exception thrown");
        }
    }
}
