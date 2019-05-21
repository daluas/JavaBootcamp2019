package com.cegeka.spring.address.service.impl;

import com.cegeka.spring.GeneralUtils;
import com.cegeka.spring.address.dto.Address;
import com.cegeka.spring.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personalAddressBean")
public class PersonalAddressService implements AddressService{

    private GeneralUtils generalUtils;

    @Override
    public void create(Address address) {
        generalUtils.print(address, (Address::toString));
    }

    @Autowired
    public PersonalAddressService(GeneralUtils generalUtils){
        this.generalUtils = generalUtils;
    }
}
