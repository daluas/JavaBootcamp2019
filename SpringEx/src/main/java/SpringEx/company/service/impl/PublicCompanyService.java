package SpringEx.company.service.impl;

import SpringEx.GeneralUtils;
import SpringEx.company.dto.Company;
import SpringEx.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("publicCompanyService")
public class PublicCompanyService implements CompanyService {

    private GeneralUtils generalUtils;

    @Override
    public void create(Company publicCompany) {
        System.out.println(publicCompany.toString());
    }

    @Autowired
    public PublicCompanyService(GeneralUtils generalUtils) {
        this.generalUtils = generalUtils;
    }
}
