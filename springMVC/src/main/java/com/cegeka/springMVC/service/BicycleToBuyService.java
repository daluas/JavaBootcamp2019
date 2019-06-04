package com.cegeka.springMVC.service;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;
import com.cegeka.springMVC.model.BicycleToBuy;

import java.util.List;
import java.util.Optional;


public interface BicycleToBuyService {

    List<BicycleToBuy> getAllBicycles();

    Optional<BicycleToBuy> getBicycleById(Long id);

    List<BicycleToBuy> getBicyclesByName(String name);

    void addBicycle(BicycleToBuyEntity bicycleToBuyEntity);

    Integer deleteBicycleToBuy(Long id);

}
