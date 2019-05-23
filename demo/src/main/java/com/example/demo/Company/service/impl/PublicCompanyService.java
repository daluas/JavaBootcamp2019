package com.example.demo.Company.service.impl;

import com.example.demo.Company.dto.Company;
import com.example.demo.Company.service.CompanyService;
import com.example.demo.GeneralUtilsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("publicCompanyService")
public class PublicCompanyService implements CompanyService {

    @Autowired
    private GeneralUtilsComponent generalUtilsComponent;

    public String create(Company company){

        System.out.println("Sunt in create");
        return generalUtilsComponent.print(Company::toString,company);
    }


}
