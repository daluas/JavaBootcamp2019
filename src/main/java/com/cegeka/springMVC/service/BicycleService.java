package com.cegeka.springMVC.service;

import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.service.impl.BicycleServiceImpl;

import java.util.List;
import java.util.Optional;


public interface BicycleService {

    List<Bicycle> getAllBicycles();

    Optional<Bicycle> getBicycleById(long id);

    List<Bicycle> getBicycleByName(String name);

    void addBicycle(Bicycle bicycle);

    BicycleServiceImpl.UpdateStatus updateBicycle(long id, Bicycle bicycle);

}
