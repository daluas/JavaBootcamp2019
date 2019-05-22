package SpringEx.company.service;

import SpringEx.company.dto.Company;
import org.springframework.stereotype.Component;

@Component
public interface CompanyService {
    void create(Company company);
}
