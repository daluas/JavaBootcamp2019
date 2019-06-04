package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.AccessoryEntity;
import com.cegeka.springMVC.model.Accessory;
import com.cegeka.springMVC.repository.AccessoryRepository;
import com.cegeka.springMVC.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryServiceImpl implements AccessoryService {
    @Autowired
    private
    AccessoryRepository accessoryRepository;
    @Override
    public List<Accessory> getAllAccessories() {
        return accessoryRepository.getAllAccessories();
    }

    @Override
    public Integer insertAccessory(Accessory accessory) {
        return 1;
    }
}
