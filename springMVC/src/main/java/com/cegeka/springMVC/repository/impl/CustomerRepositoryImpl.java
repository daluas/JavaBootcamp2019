package com.cegeka.springMVC.repository.impl;

import com.cegeka.springMVC.entity.CustomerEntity;
import com.cegeka.springMVC.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertCustomer(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
    }

    @Override
    public Integer deleteCustomer(Integer id) {
        String query = "DELETE CustomerEntity c WHERE c.id = :id";
        return entityManager.createQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

}
