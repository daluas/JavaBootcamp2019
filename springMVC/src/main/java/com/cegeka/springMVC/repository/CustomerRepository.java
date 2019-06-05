package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.CustomerEntity;

public interface CustomerRepository {

    void insertCustomer(CustomerEntity customerEntity);

    Integer deleteCustomer(Integer id);

}
