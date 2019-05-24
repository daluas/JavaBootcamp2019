package com.example.Project1.Company.Service.Impl;
import com.example.Project1.Company.Dto.Company;
import com.example.Project1.Company.Service.CompanyService;
import com.example.Project1.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PrivateCompany")
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