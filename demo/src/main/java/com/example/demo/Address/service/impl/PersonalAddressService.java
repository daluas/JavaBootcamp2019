package com.example.demo.Address.service.impl;

import com.example.demo.Address.dto.Address;
import com.example.demo.Address.service.AddressService;
import org.springframework.stereotype.Component;


@Component("personalAddressService")
public class PersonalAddressService implements AddressService {

    public String create(Address address){

        System.out.println("Sunt in create");
        return address.toString();
    }
}
