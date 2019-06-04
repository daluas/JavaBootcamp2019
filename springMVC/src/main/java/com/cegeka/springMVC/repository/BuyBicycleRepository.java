package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.model.BuyBicycle;

import java.util.List;

public interface BuyBicycleRepository {

    List<BuyBicycle> getAllBuyBicycles();
    Integer createBuyBicycle(BuyBicycle buyBicycle);
    Boolean updateBuyBicycle(BuyBicycle buyBicycle);
    Boolean deleteBuyBicycle(Integer id);
}
