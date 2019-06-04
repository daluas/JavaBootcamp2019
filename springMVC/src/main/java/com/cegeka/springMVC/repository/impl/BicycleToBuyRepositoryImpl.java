package com.cegeka.springMVC.repository.impl;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;
import com.cegeka.springMVC.repository.BicycleToBuyRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@SuppressWarnings("unchecked")
public class BicycleToBuyRepositoryImpl implements BicycleToBuyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertBicycle(BicycleToBuyEntity bicycleToBuyEntity) {
        entityManager.persist(bicycleToBuyEntity);
    }

    @Override
    public List<BicycleToBuyEntity> getAllBicyclesToBuy() {
        String query = "Select btb from BicycleToBuyEntity btb";
        return entityManager.createQuery(query)
                .getResultList();
    }

    @Override
    public Optional<BicycleToBuyEntity> getBicycleById(Long id) {
        String query = "Select btb from BicycleToBuyEntity btb WHERE btb.id = :id";
        try {
            BicycleToBuyEntity result = (BicycleToBuyEntity) entityManager.createQuery(query)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.of(result);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<BicycleToBuyEntity> getBicyclesByName(String name) {
        String query = "Select btb from BicycleToBuyEntity btb WHERE btb.name = :name";
        return (List<BicycleToBuyEntity>) entityManager.createQuery(query)
                    .setParameter("name", name)
                    .getResultList();
    }

    @Override
    public Integer deleteBicycleToBuy(Long id) {
        String query = "DELETE BicycleToBuyEntity btb WHERE btb.id = :id";
        return entityManager.createQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

}
