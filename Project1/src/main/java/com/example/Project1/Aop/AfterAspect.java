package com.example.Project1.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {
    @After("execution (void com.example.Project1.Company.Service.Impl.PrivateCompanyService.create(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("After aspect");
    }

}
