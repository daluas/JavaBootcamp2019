package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BeforeAspect {

    @Before("execution(void com.cegeka.spring.address.service.impl.CompanyAddressService.create(..))")
    public void afiseaza(){
        System.out.println("BeforeAspect~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "\n");
    }
}
