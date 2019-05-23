package com.example.demo.Company.dto;
import com.example.demo.Address.dto.Address;
import org.springframework.stereotype.Component;

@Component
public class Company {

    private String name;
    private Address address;

    public Company(){

        this.name = "Cegeka";
        this.address = new Address();
    }

    @Override
    public String toString(){

        return "The company "+name+" and "+address;
    }



}
