package SpringEx.company.service.impl;

import SpringEx.company.dto.Company;
import SpringEx.company.service.CompanyService;
import org.springframework.stereotype.Component;

@Component("privateCompanyService")
public class PrivateCompanyService implements CompanyService {
    @Override
    public void create(Company privateCompany) {
        System.out.println(privateCompany.toString());
    }
}
