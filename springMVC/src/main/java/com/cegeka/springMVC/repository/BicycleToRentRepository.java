package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.BicycleToRent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicycleToRentRepository extends JpaRepository<BicycleToRentEntity, Integer> {

    List<BicycleToRentEntity> findAllByName(String name);

}
