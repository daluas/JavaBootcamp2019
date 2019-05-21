package com.cegeka.spring.company.dto;

import com.cegeka.spring.address.dto.Address;

public class Company {
    private String name;
    private Address address;

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", com.cegeka.spring.address=" + address +
                '}';
    }
}
