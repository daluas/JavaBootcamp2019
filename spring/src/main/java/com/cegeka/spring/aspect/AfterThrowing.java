package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowing {

    @org.aspectj.lang.annotation.AfterThrowing(pointcut = "execution (void com.cegeka.spring.company.service.CompanyService.*())",
            throwing = "e")
    public void afisareExceptie(RuntimeException e){
        System.out.println("Exception thrown" + e.toString());
    }
}
