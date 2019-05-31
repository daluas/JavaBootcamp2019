package com.springBoot.BicycleStore.service;

import com.springBoot.BicycleStore.model.Bicycle;

import java.util.List;

public interface BicycleService {
    Bicycle findById(long id);

    Bicycle findByName(String name);

    void saveBicycle(Bicycle bicycle);

    void updateBicycle(Bicycle bicycle);

    void deleteBicycleById(long id);

    List<Bicycle> findAllBicycles();

    void deleteAllBicycles();

    boolean isBicycleExist(Bicycle bicycle);
}
