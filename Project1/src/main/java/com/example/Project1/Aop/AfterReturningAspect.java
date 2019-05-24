package com.example.Project1.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspect {
    @AfterReturning(pointcut = "execution(* create(..))", returning = "returned")
    public void createMethodCall(String returned) {
        System.out.println("AfterReturning aspect: "+returned);
    }

}