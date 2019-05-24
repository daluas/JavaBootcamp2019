package com.example.Project1.Company.Service;
import com.example.Project1.Company.Dto.Company;

public interface CompanyService {

    void create(Company company);
    default String create() {
        System.out.println("Create() from CompanyService");
        return "company";
    }
}