package com.cegeka.spring.company.service.impl;

import com.cegeka.spring.GeneralUtils;
import com.cegeka.spring.company.dto.Company;
import com.cegeka.spring.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("privateCompany")
public class PrivateCompanyService implements CompanyService  {

    private GeneralUtils generalUtils;

    @Autowired
    public PrivateCompanyService(GeneralUtils generalUtils) {
        this.generalUtils = generalUtils;
    }

    @Override
    public void create(Company company) {
        generalUtils.print(company, Company::toString);
    }
}
