package com.example.Project1.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterTrowingAspect {
    @AfterThrowing(pointcut = "execution (void com.example.Project1.Company.Service.Impl.PrivateCompanyService.create(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable excep) throws Throwable {
        System.out.println("Inside CatchThrowException.afterThrowing() method...");
        System.out.println("Running after throwing exception...");
        System.out.println("Exception : " + excep);
    }

}
