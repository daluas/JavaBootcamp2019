package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.model.BuyBicycle;
import com.cegeka.springMVC.repository.BuyBicycleRepository;
import com.cegeka.springMVC.service.BuyBicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyBicycleServiceImpl implements BuyBicycleService {

    @Autowired
    private
    BuyBicycleRepository buyBicycleRepository;

    @Override
    public List<BuyBicycle> getAllBicycles() {
        return buyBicycleRepository.getAllBuyBicycles();
    }
}
