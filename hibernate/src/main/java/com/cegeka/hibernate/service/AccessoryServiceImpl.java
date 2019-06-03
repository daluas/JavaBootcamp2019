package com.cegeka.hibernate.service;

import com.cegeka.hibernate.dto.AccessoryDto;
import com.cegeka.hibernate.repository.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccessoryServiceImpl implements AccessoryService {
    @Autowired
    AccessoryRepository accessoryRepository;
    @Override
    public List<AccessoryDto> getAllAccessories() {
        return accessoryRepository.getAllAccessories();
    }
}
