package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturning {

    @org.aspectj.lang.annotation.AfterReturning(pointcut = "execution(* create(..))", returning = "returnedString")
    public void afisare(String returnedString){
        System.out.println("AfterReturning from getter~~~~~~~~~~~~~~~~~ " +
                returnedString + "\n");
    }
}
