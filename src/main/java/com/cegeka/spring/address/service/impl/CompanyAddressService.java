package com.cegeka.spring.address.service.impl;

import com.cegeka.spring.address.dto.AddressDto;
import com.cegeka.spring.address.service.AddressService;
import com.cegeka.spring.GeneralUtils;
import com.cegeka.spring.address.annotations.CompanyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@CompanyAddress
@Service
public class CompanyAddressService implements AddressService {

    private GeneralUtils generalUtils;

    @Autowired
    public CompanyAddressService(GeneralUtils generalUtils) {
        this.generalUtils = generalUtils;
    }

    @Override
    public void create(AddressDto address) {
        generalUtils.print(address, (AddressDto::toString));
    }
}
