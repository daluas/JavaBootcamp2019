package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.CustomerEntity;
import com.cegeka.springMVC.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CompanyService companyService;

    @Autowired
    public CustomerController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(value = "/customer")
    public ResponseEntity postCustomer(CustomerEntity customerEntity)  {
        //TODO
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable long id) {
        //TODO
        return new ResponseEntity(HttpStatus.OK);
    }

}
