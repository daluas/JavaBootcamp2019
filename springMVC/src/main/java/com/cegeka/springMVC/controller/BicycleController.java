package com.cegeka.springMVC.controller;
import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/v1")
public class BicycleController {

    private BicycleService bicycleService;

    @Autowired
    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping("/bicycles")
    public List<Bicycle> getAllBikes() {
        return bicycleService.getAllBicycles();
    }

    @GetMapping("/addBike")
    public void addBike() {
        bicycleService.addBicycle(new Bicycle());
    }
}
