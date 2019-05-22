package com.cegeka.spring.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterAspect {

    @After("execution(void com.cegeka.spring.address.service.impl.PersonalAddressService.create(..))")
    public void afisare(){
        System.out.println("AfterAspect~~~~~~~~~~~~~~~~~~~~~~~~~" +
                "\n");
    }
}
