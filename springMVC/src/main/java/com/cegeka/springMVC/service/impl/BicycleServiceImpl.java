package com.cegeka.springMVC.service.impl;

import com.cegeka.springMVC.entity.BicycleEntity;
import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.repository.BicycleHibernateRepository;
import com.cegeka.springMVC.repository.BicycleRepository;
import com.cegeka.springMVC.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BicycleServiceImpl implements BicycleService {
    @Autowired
    private BicycleHibernateRepository bicycleHibernateRepository;



    public List<Bicycle> getAllBicyclesHibernate() {
        List<BicycleEntity> bikes = bicycleHibernateRepository.getAll();
        bicycleList = mapToModel(bikes);
        return bicycleList;
    }

    @Autowired
    private BicycleRepository bicycleRepository;


    @Override
    public List<Bicycle> getAllBicycles() {
        List<BicycleEntity> bikes = bicycleHibernateRepository.getAll();
        bicycleList = mapToModel(bikes);
        return bicycleList;
    }

    public Bicycle getByName() {
        BicycleEntity bike = bicycleRepository.findByName("test1");
        Bicycle bicycle = mapToModel(bike);
        return bicycle;
    }

    public Bicycle getByNameCustom() {
        BicycleEntity bike = bicycleRepository.retrieveByName("test1");
        Bicycle bicycle = mapToModel(bike);
        return bicycle;
    }

    private Bicycle mapToModel(BicycleEntity bike) {
        return new Bicycle();
    }

    private List<Bicycle> mapToModel(List<BicycleEntity> bikes) {
        BicycleEntity bikEnt = bikes.get(0);
        Bicycle bike = new Bicycle();
        bike.setId(bikEnt.getId());
        bike.setModel(bikEnt.getModel());
        bike.setName(bikEnt.getName());
        bike.setPrice(17);
        List<Bicycle> list = new ArrayList<>();
        list.add(bike);
        return list;
    }

    @Override
    public Optional<Bicycle> getBicycleById(long id) {
        BicycleEntity bike = bicycleRepository.findById(id).get();
        return Optional.empty();
    }

    @Override
    public List<Bicycle> getBicycleByName(String name) {
        if (bicycleList == null) {
            return new ArrayList<>();
        }
        return bicycleList.stream()
                .filter(bicycle -> bicycle.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void addBicycle(Bicycle bicycle) {
        BicycleEntity bike = new BicycleEntity();
        bike.setModel("new model");
        bike.setName(" new name");
        bicycleRepository.save(bike);
    }

    @Override
    public UpdateStatus updateBicycle(long id, Bicycle bicycle) {
        for (Bicycle currentBicycle : bicycleList) {
            if (currentBicycle.getId() == id) {
                return getUpdateResponseStatus(currentBicycle, bicycle);
            }
        }
        return UpdateStatus.NOT_FOUND;
    }

    @Override
    public UpdateStatus partialUpdateBicycle(long id, Bicycle bicycleUpdater) {
        Optional<Bicycle> currentBicycle = getBicycleById(id);
        if (currentBicycle.isPresent()) {
            return getPartialUpdateResponseStatus(currentBicycle.get(), bicycleUpdater);
        }
        return UpdateStatus.NOT_FOUND;
    }

    @Override
    public boolean deleteBicycle(long id) {
        for (Bicycle bicycle : bicycleList) {
            if (bicycle.getId() == id) {
                bicycleList.remove(bicycle);
                return true;
            }
        }
        return false;
    }

    private UpdateStatus getPartialUpdateResponseStatus(Bicycle bicycleToUpdate, Bicycle bicycleUpdater) {
        boolean isBicycleNameChanged = setNewBicycleName(bicycleToUpdate, bicycleUpdater);
        boolean isBicycleModelChanged = setNewBicycleModel(bicycleToUpdate, bicycleUpdater);
        boolean isBicyclePriceChanged = setNewBicyclePrice(bicycleToUpdate, bicycleUpdater);

        if (isBicycleNameChanged || isBicycleModelChanged || isBicyclePriceChanged)
            return UpdateStatus.UPDATED;
        return UpdateStatus.NOT_UPDATED;
    }

    private boolean setNewBicycleName(Bicycle bicycleToUpdate, Bicycle bicycleUpdater) {
        if (bicycleUpdater.getName() != null && !bicycleUpdater.getName().equals(bicycleToUpdate.getName())) {
            bicycleToUpdate.setName(bicycleUpdater.getName());
            return true;
        } else {
            return false;
        }
    }

    private boolean setNewBicycleModel(Bicycle bicycleToUpdate, Bicycle bicycleUpdater) {
        if (bicycleUpdater.getModel() != null && !bicycleUpdater.getModel().equals(bicycleToUpdate.getModel())) {
            bicycleToUpdate.setModel(bicycleUpdater.getModel());
            return true;
        } else {
            return false;
        }
    }

    private boolean setNewBicyclePrice(Bicycle bicycleToUpdate, Bicycle bicycleUpdater) {
        if (bicycleUpdater.getPrice() != 0 && bicycleUpdater.getPrice() != bicycleToUpdate.getPrice()) {
            bicycleToUpdate.setPrice(bicycleUpdater.getPrice());
            return true;
        } else {
            return false;
        }
    }

    private UpdateStatus getUpdateResponseStatus(Bicycle bicycleToUpdate, Bicycle bicycle) {
        if (bicycleToUpdate.equals(bicycle)) {
            return UpdateStatus.NOT_UPDATED;
        } else {
            bicycleToUpdate.setName(bicycle.getName());
            bicycleToUpdate.setModel(bicycle.getModel());
            bicycleToUpdate.setPrice(bicycle.getPrice());
            return UpdateStatus.UPDATED;
        }
    }

    private long getLastId() {
        return bicycleList
                .get(bicycleList.size() - 1)
                .getId();
    }

    public enum UpdateStatus {
        UPDATED, NOT_UPDATED, NOT_FOUND
    }

    private List<Bicycle> bicycleList = new ArrayList<Bicycle>() {{
        add(new Bicycle(1, "Cube", "Analog", 300));
        add(new Bicycle(2, "Rockrider", "540", 100));
        add(new Bicycle(3, "Rockrider", "340", 90));
        add(new Bicycle(4, "Cube", "Ams 100", 450));
    }};

}

