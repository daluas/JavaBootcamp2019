package com.example.demo.Address.service;

import com.example.demo.Address.dto.Address;
import org.springframework.stereotype.Component;

@Component
public interface AddressService {

    String create(Address address);
}
