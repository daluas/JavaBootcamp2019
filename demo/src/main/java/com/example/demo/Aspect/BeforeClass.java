package com.example.demo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeClass {

    @Before("execution(String create(*))")
    public void executeBefore(){

        System.out.println("[BEFORE] ============== Inainte de create");
    }
}
