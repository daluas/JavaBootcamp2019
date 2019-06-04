package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.BuyBicycle;
import com.cegeka.springMVC.service.BuyBicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuyBicycleController {

    private BuyBicycleService buyBicycleService;

    @Autowired
    public BuyBicycleController(BuyBicycleService buyBicycleService) {
        this.buyBicycleService = buyBicycleService;
    }

    @GetMapping("/buybicycles")
    public List<BuyBicycle> getAllBikes() {
        return buyBicycleService.getAllBicycles();
    }
}
