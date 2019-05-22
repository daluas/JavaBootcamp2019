package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterThrowingAspect {

    @AfterThrowing(pointcut = "execution (void com.cegeka.spring.company.service.CompanyService.*())",
            throwing = "exception")
    public void logException(RuntimeException exception) {
        System.out.println("AFTERTHROWING was called by throwException2 because throwException had the exception caught in around: "
                + exception.toString());
    }

}
