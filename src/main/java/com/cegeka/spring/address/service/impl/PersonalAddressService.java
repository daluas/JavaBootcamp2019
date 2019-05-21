package com.cegeka.spring.address.service.impl;

import com.cegeka.spring.address.dto.Address;
import com.cegeka.spring.address.service.AddressService;
import com.cegeka.spring.GeneralUtils;
import com.cegeka.spring.address.annotations.PersonalAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@PersonalAddress
@Service
public class PersonalAddressService implements AddressService {

    private GeneralUtils generalUtils;

    @Autowired
    public PersonalAddressService(GeneralUtils generalUtils) {
        this.generalUtils = generalUtils;
    }

    @Override
    public void create(Address address) {
        generalUtils.print(address, (Address::toString));
    }
}
