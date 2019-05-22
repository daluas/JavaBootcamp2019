package SpringEx.address.service.impl;

import SpringEx.GeneralUtils;
import SpringEx.address.dto.Address;
import SpringEx.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("companyAddressService")
public class CompanyAddressService implements AddressService {

    private GeneralUtils generalUtils;

    @Override
    public void create(Address address) {
        System.out.println(address.toString());
    }

    @Autowired
    public CompanyAddressService(GeneralUtils generalUtils) {
        this.generalUtils = generalUtils;
    }
}
