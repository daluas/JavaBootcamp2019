package com.example.Project1.Address.Service;
import com.example.Project1.Address.Dto.Address;

public interface AddressService {
    void create(Address address);
    default String create() {
        System.out.println("Create() from AddressService");
        return "address";
    }
}
