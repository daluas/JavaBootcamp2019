package com.cegeka.springMVC.service;

import com.cegeka.springMVC.model.Accessory;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccessoryService {

    List<Accessory> getAllAccessories();
    Integer insertAccessory(Accessory accessory);
}
