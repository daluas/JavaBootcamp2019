package SpringEx.address.service.impl;

import SpringEx.GeneralUtils;
import SpringEx.address.dto.Address;
import SpringEx.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Boolean validateAddress(Address address) throws AddressNotValidException {
        if(address.getStreet().contains("Iasi") && address.getNumber()>0)
            return true;
        else{
            throw new AddressNotValidException("Introduced address is not from Iasi or has a valid number");
        }
    }
}
