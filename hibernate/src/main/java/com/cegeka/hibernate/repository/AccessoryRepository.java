package com.cegeka.hibernate.repository;

import com.cegeka.hibernate.dto.AccessoryDto;
import com.cegeka.hibernate.model.Accessories;

import java.util.List;

public interface AccessoryRepository {

    List<AccessoryDto> getAllAccessories();
}
