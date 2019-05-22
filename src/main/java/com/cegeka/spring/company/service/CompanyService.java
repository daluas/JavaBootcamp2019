package com.cegeka.spring.company.service;

import com.cegeka.spring.company.dto.CompanyDto;

public interface CompanyService {

    void create(CompanyDto company);

    default String create() {
        System.out.println("Create() from CompanyService");
        return "company";
    }

    default void throwException() {
        throw new RuntimeException();
    }

    default void throwException2() {
        throw new RuntimeException();
    }

}
