package com.cegeka.springMVC.repository.impl;

import com.cegeka.springMVC.entity.BuyBicycleEntity;
import com.cegeka.springMVC.model.BuyBicycle;
import com.cegeka.springMVC.repository.BuyBicycleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class BuyBicycleRepositoryImpl implements BuyBicycleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuyBicycle> getAllBuyBicycles() {
        String query = "SELECT a FROM BuyBicycleEntity a";
        return (List<BuyBicycle>) entityManager.createQuery(query).getResultList();
    }

    @Override
    public Integer createBuyBicycle(BuyBicycle buyBicycle) {
        return null;
    }

    @Override
    public Boolean updateBuyBicycle(BuyBicycle buyBicycle) {
        return null;
    }

    @Override
    public Boolean deleteBuyBicycle(Integer id) {
        return null;
    }
}
