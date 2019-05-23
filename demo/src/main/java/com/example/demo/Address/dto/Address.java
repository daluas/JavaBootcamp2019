package com.example.demo.Address.dto;

import org.springframework.stereotype.Component;

@Component
public class Address {

    private String location;

    public Address(){
        this.location = "Belgium";
    }

    @Override
    public String toString(){

        return "The Address is "+location;
    }


}
