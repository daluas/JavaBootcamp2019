package com.cegeka.spring.company.service;

import com.cegeka.spring.company.dto.Company;

import java.awt.*;

public interface CompanyService {

    void create(Company company);

    default String create() {
        System.out.println("default create()");
        return "company";
    }

    default void throwException(){
        throw new RuntimeException();
    }

    default void throwNewException(){
        throw new RuntimeException();
    }


}
