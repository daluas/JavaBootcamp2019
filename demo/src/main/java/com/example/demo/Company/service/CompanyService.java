package com.example.demo.Company.service;

import com.example.demo.Company.dto.Company;
import org.springframework.stereotype.Component;

@Component
public interface CompanyService {

    String create(Company company);
}
