package com.example.demo.Address.service.impl;

import com.example.demo.Address.dto.Address;
import com.example.demo.Address.service.AddressService;
import com.example.demo.GeneralUtilsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("companyAddressService")
public class CompanyAddressService implements AddressService {

    @Autowired
    private GeneralUtilsComponent generalUtilsComponent;

    public String create(Address address){

        System.out.println("Sunt in create");
        return generalUtilsComponent.print(Address::toString,address);
    }
}
