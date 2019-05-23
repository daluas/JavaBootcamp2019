package com.example.demo.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundClass {


    @Around("execution(String create(*))")
    public Object executeAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        System.out.println("[AROUND] ============== Inainte de create");
        return proceedingJoinPoint.proceed();
    }


}
