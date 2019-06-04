package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.CustomerEntity;
import com.cegeka.springMVC.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<CustomerEntity> postCustomer(@RequestBody CustomerEntity customerEntity)  {
        customerService.addCustomer(customerEntity);
        return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        //TODO
        Integer deletedEntities = customerService.deleteCustomer(id);
        if(deletedEntities == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
