package com.example.Project1.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AroundAspect {
    @Around("execution (void com.example.Project1.Company.Service.Impl.PrivateCompanyService.create(..))")
    public void createMethods(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("Around aspect: ");
            pjp.proceed();
        } catch (Throwable exception) {
            System.out.println("Exception: "+exception.getMessage());
        }

    }
}
