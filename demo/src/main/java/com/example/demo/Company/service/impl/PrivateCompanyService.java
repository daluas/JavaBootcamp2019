package com.example.demo.Company.service.impl;

import com.example.demo.Company.dto.Company;
import com.example.demo.Company.service.CompanyService;
import org.springframework.stereotype.Component;

@Component("privateCompanyService")
public class PrivateCompanyService implements CompanyService {

    public String create(Company company){

        System.out.println("Sunt in create");
        //return company.toString();
        throw new RuntimeException();

    }
}
