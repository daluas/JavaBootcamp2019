package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.BicycleToBuy;
import com.cegeka.springMVC.model.BicycleToRent;
import com.cegeka.springMVC.repository.BicycleToRentRepository;
import com.cegeka.springMVC.service.BicycleToRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BicycleToRentServiceImpl implements BicycleToRentService {

    private BicycleToRentRepository bicycleToRentRepository;

    @Autowired
    public BicycleToRentServiceImpl(BicycleToRentRepository bicycleToRentRepository) {
        this.bicycleToRentRepository = bicycleToRentRepository;
    }

    @Override
    public List<BicycleToRent> getAllBicycles() {
        List<BicycleToRentEntity> bicycleToRentList = bicycleToRentRepository.findAll();
        return mapToModel(bicycleToRentList);
    }

    @Override
    public Optional<BicycleToRent> getBicycleById(Integer id) {
        Optional<BicycleToRentEntity> bicycleToRentEntity = bicycleToRentRepository.findById(id);
        return bicycleToRentEntity.map(this::mapToModel);
    }

    @Override
    public List<BicycleToRent> getBicyclesByName(String name) {
        List<BicycleToRentEntity> bicycleToRentEntityList = bicycleToRentRepository.findAllByName(name);
        return mapToModel(bicycleToRentEntityList);
    }

    @Override
    public boolean addBicycle(BicycleToRentEntity bicycleToRentEntity) {
        if(areAnyFieldsNull(bicycleToRentEntity)) {
            return false;
        }
        bicycleToRentRepository.save(bicycleToRentEntity);
        return true;
    }

    @Override
    public void deleteBicycleToRent(Integer id) {
        bicycleToRentRepository.deleteById(id);
    }

    private boolean areAnyFieldsNull(BicycleToRentEntity bicycleToRentEntity) {
        String model  = bicycleToRentEntity.getModel();
        String name = bicycleToRentEntity.getName();
        Float pricePerHour = bicycleToRentEntity.getPricePerHour();
        Integer amount = bicycleToRentEntity.getAmount();
        return Stream.of(model, name, pricePerHour, amount).anyMatch(Objects::isNull);
    }

    private List<BicycleToRent> mapToModel(List<BicycleToRentEntity> bicycleToRentEntities) {
        List<BicycleToRent> bicycleToRentList = new ArrayList<>();
        for(BicycleToRentEntity bicycleToRentEntity : bicycleToRentEntities) {
            bicycleToRentList.add(mapToModel(bicycleToRentEntity));
        }
        return bicycleToRentList;
    }

    private BicycleToRent mapToModel(BicycleToRentEntity bicycleToRentEntity) {
        BicycleToRent result = new BicycleToRent();
        result.setId(bicycleToRentEntity.getId());
        result.setName(bicycleToRentEntity.getName());
        result.setModel(bicycleToRentEntity.getModel());
        result.setPricePerHour(bicycleToRentEntity.getPricePerHour());
        return result;
    }
    
}
