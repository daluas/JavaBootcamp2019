package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAspect {

    @AfterReturning(pointcut = "execution (* create(..))", returning = "returnedString")
    public void execute(String returnedString) {
        System.out.println("AFTERRETURN of method create witch return a string: " + returnedString);
    }

}
