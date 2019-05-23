package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturning {

    @org.aspectj.lang.annotation.AfterReturning(value = "execution(String create(*))",returning = "result")
    public void executeAfterReturning(String result){

        System.out.println("[AFTERRETURNING] ============== Acesta este raspunsul");
        System.out.println("[AFTERRETURNING] ============== "+result);
    }
}
