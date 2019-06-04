package com.cegeka.springMVC.repository.impl;

import com.cegeka.springMVC.entity.AccessoryEntity;
import com.cegeka.springMVC.model.Accessory;
import com.cegeka.springMVC.repository.AccessoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AccessoryRepositoryImpl implements AccessoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Accessory> getAllAccessories() {
        String query = "SELECT a FROM AccessoryEntity a";
        return (List<Accessory>)entityManager.createQuery(query).getResultList();
    }

    @Override
    public Integer insertIntoAccessories(AccessoryEntity accessoryEntity) {
        AccessoryEntity acc = accessoryEntity;
        entityManager.persist(acc);
        return accessoryEntity.getId();
    }
}
