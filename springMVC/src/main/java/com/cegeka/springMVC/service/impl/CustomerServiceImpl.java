package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.CustomerEntity;
import com.cegeka.springMVC.repository.CustomerRepository;
import com.cegeka.springMVC.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void addCustomer(CustomerEntity customerEntity) {
        customerRepository.insertCustomer(customerEntity);
    }

    @Override
    public Integer deleteCustomer(Long id) {
        return customerRepository.deleteCustomer(id);
    }

}
