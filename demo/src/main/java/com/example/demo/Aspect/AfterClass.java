package com.example.demo.Aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterClass {

    @After("execution(String com.example.demo.Address.service.impl.CompanyAddressService.create(*))")
    public void executeAfter(){

        System.out.println("[AFTER] ============== Dupa create");
    }
}
