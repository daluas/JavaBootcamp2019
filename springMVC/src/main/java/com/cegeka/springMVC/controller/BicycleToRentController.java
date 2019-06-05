package com.cegeka.springMVC.controller;

import com.cegeka.springMVC.entity.BicycleToRentEntity;
import com.cegeka.springMVC.model.BicycleToRent;
import com.cegeka.springMVC.service.BicycleToRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BicycleToRentController {

    private BicycleToRentService bicycleToRentService;

    @Autowired
    public BicycleToRentController(BicycleToRentService bicycleToRentService) {
        this.bicycleToRentService = bicycleToRentService;
    }

    @GetMapping("/bicyclestorent")
    public ResponseEntity<List<BicycleToRent>> getAllBicyclesToRent() {
        List<BicycleToRent> bicycleToRentList = bicycleToRentService.getAllBicycles();
        return handleBicycleToRentListResponse(bicycleToRentList);
    }

    @GetMapping("/bicyclestorent/{id}")
    public ResponseEntity<BicycleToRent> getBicycleById(@PathVariable Integer id) {
        Optional<BicycleToRent> bicycleToRent = bicycleToRentService.getBicycleById(id);
        return bicycleToRent.
                map(bicycleToRent1 -> new ResponseEntity<>(bicycleToRent1, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/bicyclestorent", params = {"name"})
    public ResponseEntity<List<BicycleToRent>> getBicycleByName(@RequestParam(name = "name") String name) {
        List<BicycleToRent> bicycleToRentList = bicycleToRentService.getBicyclesByName(name);
        if(bicycleToRentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bicycleToRentList, HttpStatus.OK);
    }

    @PostMapping("/bicyclestorent")
    public ResponseEntity<BicycleToRentEntity> postBicycleToRent(@RequestBody BicycleToRentEntity bicycleToRentEntity) {
        if(bicycleToRentEntity == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        boolean result = bicycleToRentService.addBicycle(bicycleToRentEntity);
        if(result) {
            return new ResponseEntity<>(bicycleToRentEntity, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("bicyclestorent/{id}")
    public ResponseEntity deleteBicycleToRent(@PathVariable Integer id) {
        bicycleToRentService.deleteBicycleToRent(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    private ResponseEntity<List<BicycleToRent>> handleBicycleToRentListResponse(List<BicycleToRent> bicycleList) {
        if (bicycleList.isEmpty()) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bicycleList, HttpStatus.OK);
    }

}
