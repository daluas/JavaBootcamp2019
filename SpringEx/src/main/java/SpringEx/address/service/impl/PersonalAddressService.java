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

    public Boolean validateAddress(Address address) throws AddressNotValidException {
        if(address.getStreet().contains("Iasi") && address.getNumber()>0)
            return true;
        else{
            throw new AddressNotValidException("Introduced address is not from Iasi or has a valid number");
        }
    }
}
