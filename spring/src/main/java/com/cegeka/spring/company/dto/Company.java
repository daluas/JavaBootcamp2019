package com.cegeka.spring.company.dto;

import com.cegeka.spring.address.dto.Address;

public class Company {
    private String name;
    private Address address;

    public Company(String name, Address address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", " + this.address.toString();
    }
}
