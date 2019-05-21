package com.cegeka.spring.company.service.impl;

import com.cegeka.spring.GeneralUtils;
import com.cegeka.spring.company.dto.Company;
import com.cegeka.spring.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("privateCompanyBean")
public class PrivateCompanyService implements CompanyService {

    private GeneralUtils generalUtils;

    @Override
    public void create(Company company) {
        generalUtils.print(company, (Company::toString));
    }

    @Autowired
    public PrivateCompanyService(GeneralUtils generalUtils){
        this.generalUtils = generalUtils;
    }
}
