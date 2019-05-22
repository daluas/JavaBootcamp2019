package com.cegeka.spring.company.dto;

import com.cegeka.spring.address.dto.AddressDto;

public class CompanyDto {
    private String name;
    private AddressDto address;

    public CompanyDto(String name, AddressDto address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "name='" + name + '\'' +
                ", com.cegeka.spring.address=" + address +
                '}';
    }
}
