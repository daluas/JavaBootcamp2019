package com.example.Project1.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {
    @Before("execution(* create(..))")
    public void createMethods(JoinPoint jp) {
        System.out.println("Before aspect -> Executing method: "+jp.getSignature().getName());
    }
}
