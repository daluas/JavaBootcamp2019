package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowing {


    @org.aspectj.lang.annotation.AfterThrowing(value = "execution(String create(*))",throwing = "e")
    public void executeAfterThrowin(RuntimeException e){

        System.out.println("[AFTERTHROWING] ============== O exceptie gasita");
    }
}
