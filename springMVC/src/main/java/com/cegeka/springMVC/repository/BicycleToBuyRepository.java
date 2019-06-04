package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;

import java.util.List;
import java.util.Optional;

public interface BicycleToBuyRepository {

    void insertBicycle(BicycleToBuyEntity bicycleToBuy);

    List<BicycleToBuyEntity> getAllBicyclesToBuy();

    Optional<BicycleToBuyEntity> getBicycleById(Long id);

    List<BicycleToBuyEntity> getBicyclesByName(String name);

    Integer deleteBicycleToBuy(Long id);

}
