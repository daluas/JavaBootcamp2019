package com.cegeka.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {

    @Before("execution (void create(*))")
    public void beforeCreate(JoinPoint joinPoint) {
        System.out.println("----- BEFORE create() call: " + joinPoint.getStaticPart().getSignature());
    }

}
