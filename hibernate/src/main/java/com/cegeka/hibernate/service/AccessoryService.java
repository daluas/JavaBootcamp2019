package com.cegeka.hibernate.service;

import com.cegeka.hibernate.dto.AccessoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccessoryService {

    public List<AccessoryDto> getAllAccessories();
}
