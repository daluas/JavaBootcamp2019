package com.cegeka.hibernate.repository;

import com.cegeka.hibernate.dto.AccessoryDto;
import com.cegeka.hibernate.model.Accessories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AccessoryRepositoryImpl implements AccessoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AccessoryDto> getAllAccessories() {
        String query = "SELECT a FROM ACCESSORIES a";
       List<AccessoryDto> accessoriesList = entityManager.createQuery(query).getResultList();
        return accessoriesList;
    }
}
