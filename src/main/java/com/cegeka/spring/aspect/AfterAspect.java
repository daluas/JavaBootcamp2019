package com.cegeka.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {

    @After("execution (void create(*))")
    public void afterCreate(JoinPoint joinPoint) {
        System.out.println("----- AFTER create() call: " + joinPoint.getStaticPart().getSignature());
    }
}
