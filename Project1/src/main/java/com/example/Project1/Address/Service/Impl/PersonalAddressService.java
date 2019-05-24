package com.example.Project1.Address.Service.Impl;
import com.example.Project1.Address.Dto.Address;
import com.example.Project1.Address.Service.AddressService;
import com.example.Project1.GeneralUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PersonalAddress")
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