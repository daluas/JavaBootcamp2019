package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.entity.RentOrderEntity;
import com.cegeka.springMVC.repository.RentOrderRepository;
import com.cegeka.springMVC.service.RentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class RentOrderServiceImpl implements RentOrderService {

    private RentOrderRepository rentOrderRepository;

    @Autowired
    public RentOrderServiceImpl(RentOrderRepository rentOrderRepository) {
        this.rentOrderRepository = rentOrderRepository;
    }

    @Override
    public boolean addRentOrder(RentOrderEntity rentOrderEntity) {
        if(areAnyFieldsNull(rentOrderEntity)) {
            return false;
        }
        rentOrderRepository.save(rentOrderEntity);
        return true;
    }

    private boolean areAnyFieldsNull(RentOrderEntity rentOrderEntity) {
        Integer idCustomer = rentOrderEntity.getIdCustomer();
        Integer idBike = rentOrderEntity.getIdBike();
        Date startDate = rentOrderEntity.getStartDate();
        Date endDate = rentOrderEntity.getEndDate();
        Integer amount = rentOrderEntity.getAmount();
        return Stream.of(idCustomer, idBike, startDate, endDate, amount).anyMatch(Objects::isNull);
    }

}
