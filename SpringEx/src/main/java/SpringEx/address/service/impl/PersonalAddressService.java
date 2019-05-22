package SpringEx.address.service.impl;

import SpringEx.address.dto.Address;
import SpringEx.address.service.AddressService;
import org.springframework.stereotype.Component;

@Component("personalAddressService")
public class PersonalAddressService implements AddressService {

    @Override
    public void create(Address address) {
        System.out.println(address.toString());
    }
}
