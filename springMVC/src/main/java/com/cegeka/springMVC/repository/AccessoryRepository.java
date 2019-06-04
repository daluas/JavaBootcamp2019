package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.AccessoryEntity;

import java.util.List;

public interface AccessoryRepository {

    List getAllAccessories();
    Integer insertIntoAccessories(AccessoryEntity accessoryEntity);
}
