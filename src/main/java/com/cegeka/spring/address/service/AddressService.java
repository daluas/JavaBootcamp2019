package com.cegeka.spring.address.service;

import com.cegeka.spring.address.dto.AddressDto;

public interface AddressService {

    void create(AddressDto address);

    default String create() {
        System.out.println("Create() from AddressService");
        return "address";
    }

    default void throwException() {
        throw new RuntimeException();
    }

}
