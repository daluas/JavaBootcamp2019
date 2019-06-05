package com.cegeka.springMVC.service;

import com.cegeka.springMVC.entity.CustomerEntity;

public interface CustomerService {

    void addCustomer(CustomerEntity customerEntity);

    Integer deleteCustomer(Integer id);

}
