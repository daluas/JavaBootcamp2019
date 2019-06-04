package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.BicycleToBuyEntity;
import com.cegeka.springMVC.model.BicycleToBuy;
import com.cegeka.springMVC.repository.BicycleToBuyRepository;
import com.cegeka.springMVC.service.BicycleToBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BicycleToBuyServiceImpl implements BicycleToBuyService {

    private BicycleToBuyRepository bicycleToBuyRepository;

    @Autowired
    public BicycleToBuyServiceImpl(BicycleToBuyRepository bicycleToBuyRepository) {
        this.bicycleToBuyRepository = bicycleToBuyRepository;
    }

    @Override
    public List<BicycleToBuy> getAllBicycles() {
        List<BicycleToBuyEntity> bicycleToBuyEntities = bicycleToBuyRepository.getAllBicyclesToBuy();
        return mapToModel(bicycleToBuyEntities);
    }

    @Override
    public void addBicycle(BicycleToBuyEntity bicycleToBuyEntity) {
        bicycleToBuyRepository.insertBicycle(bicycleToBuyEntity);
    }

    @Override
    public Integer deleteBicycleToBuy(Long id) {
        return bicycleToBuyRepository.deleteBicycleToBuy(id);
    }

    @Override
    public Optional<BicycleToBuy> getBicycleById(Long id) {
        Optional<BicycleToBuyEntity> bicycleToBuyEntity = bicycleToBuyRepository.getBicycleById(id);
        return bicycleToBuyEntity.map(this::mapToModel);
    }

    @Override
    public List<BicycleToBuy> getBicyclesByName(String name) {
        List<BicycleToBuyEntity> bicycleToBuyEntities = bicycleToBuyRepository.getBicyclesByName(name);
        return mapToModel(bicycleToBuyEntities);
    }

    private List<BicycleToBuy> mapToModel(List<BicycleToBuyEntity> bicycleToBuyEntities) {
        List<BicycleToBuy> bicycleToBuyList = new ArrayList<>();
        for(BicycleToBuyEntity bicycleToBuyEntity : bicycleToBuyEntities) {
            bicycleToBuyList.add(mapToModel(bicycleToBuyEntity));
        }
        return bicycleToBuyList;
    }

    private BicycleToBuy mapToModel(BicycleToBuyEntity bicycleToBuyEntity) {
        BicycleToBuy result = new BicycleToBuy();
        result.setId(bicycleToBuyEntity.getId());
        result.setName(bicycleToBuyEntity.getName());
        result.setModel(bicycleToBuyEntity.getModel());
        result.setPrice(bicycleToBuyEntity.getPrice());
        return result;
    }

}

