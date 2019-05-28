package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.model.Bicycle;
import com.cegeka.springMVC.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BicycleController {

    private BicycleService bicycleService;

    @Autowired
    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping(value = "/bicycles")
    public ResponseEntity<List<Bicycle>> getAllBicycles() {
        List<Bicycle> bicycleList = bicycleService.getAllBicycles();
        return handleBicycleListResponse(bicycleList);
    }

    @GetMapping(value = "/bicycle/{id}")
    public ResponseEntity<Optional<Bicycle>> getBicycleById(@PathVariable long id) {
        Optional<Bicycle> bicycle = bicycleService.getBicycleById(id);
        if (bicycle.isPresent()) {
            return new ResponseEntity<>(bicycle, HttpStatus.OK);
        }
        return new ResponseEntity<>(bicycle, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/bicycles/{name}")
    public ResponseEntity<List<Bicycle>> getBicyclesByName(@PathVariable String name) {
        List<Bicycle> bicycleList = bicycleService.getBicycleByName(name);
        return handleBicycleListResponse(bicycleList);
    }

    @PostMapping(value = "/bicycle")
    public ResponseEntity postBicycle(@RequestBody Bicycle bicycle) {
        bicycleService.addBicycle(bicycle);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "bicycle/{id}")
    public void updateBicycle(@PathVariable long id,
                              @RequestBody Bicycle bicycle) {
        //TODO
//        boolean succes = bicycleService.updateBicycle(id, bicycle);
//        if(succes) {
//            return new ResponseEntity(HttpStatus.OK);
//        }
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "bicycles")
    public ResponseEntity updateAllBicycles() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<List<Bicycle>> handleBicycleListResponse(List<Bicycle> bicycleList) {
        if (bicycleList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bicycleList, HttpStatus.OK);
    }
}
