package com.cegeka.springMVC.repository;

import com.cegeka.springMVC.entity.RentOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentOrderRepository extends JpaRepository<RentOrderEntity, Integer> {
}
