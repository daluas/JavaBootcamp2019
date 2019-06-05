package com.cegeka.springMVC.service;

import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.BicycleToRent;

import java.util.List;
import java.util.Optional;

public interface BicycleToRentService {

    List<BicycleToRent> getAllBicycles();

    Optional<BicycleToRent> getBicycleById(Integer id);

    List<BicycleToRent> getBicyclesByName(String name);

    boolean addBicycle(BicycleToRentEntity BicycleToRentEntity);

    void deleteBicycleToRent(Integer id);
    
}
