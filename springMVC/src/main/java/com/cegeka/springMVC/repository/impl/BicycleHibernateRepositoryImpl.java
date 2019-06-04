package com.cegeka.springMVC.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cegeka.springMVC.entity.BicycleEntity;
import com.cegeka.springMVC.repository.BicycleHibernateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BicycleHibernateRepositoryImpl implements BicycleHibernateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BicycleEntity> getAll() {
        String query = "Select b FROM BicycleEntity b ORDER BY b.id";
        return (List<BicycleEntity>) entityManager.createQuery(query).getResultList();
    }
}
