package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.BicycleEntity;

import java.util.List;

public interface BicycleHibernateRepository {

    List<BicycleEntity> getAll();
}
